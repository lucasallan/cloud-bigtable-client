/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.grpc.v2;

import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Entry;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.cloud.bigtable.config.BigtableOptions;
import com.google.cloud.bigtable.config.Logger;
import com.google.cloud.bigtable.config.RetryOptions;
import com.google.cloud.bigtable.grpc.async.BigtableAsyncUtilities;
import com.google.cloud.bigtable.grpc.async.RetryingCollectingClientCallListener;
import com.google.cloud.bigtable.grpc.async.RetryingUnaryRpcListener;
import com.google.cloud.bigtable.grpc.async.AbstractRetryingRpcListener;
import com.google.cloud.bigtable.grpc.async.BigtableAsyncRpc;
import com.google.cloud.bigtable.grpc.io.CancellationToken;
import com.google.cloud.bigtable.grpc.io.ChannelPool;
import com.google.cloud.bigtable.grpc.scanner.BigtableResultScannerFactory;
import com.google.cloud.bigtable.grpc.scanner.ResponseQueueReader;
import com.google.cloud.bigtable.grpc.scanner.ResultScanner;
import com.google.cloud.bigtable.grpc.scanner.v2.ResumingStreamingResultScanner;
import com.google.cloud.bigtable.grpc.scanner.v2.RowMerger;
import com.google.cloud.bigtable.grpc.scanner.v2.StreamObserverAdapter;
import com.google.cloud.bigtable.grpc.scanner.v2.StreamingBigtableResultScanner;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ServiceException;

/**
 * A gRPC client to access the v2 Bigtable service.
 */
public class BigtableDataGrpcClient implements BigtableDataClient {

  private static final Logger LOG = new Logger(BigtableDataGrpcClient.class);

  // Retryable Predicates

  @VisibleForTesting
  public static final Predicate<MutateRowRequest> IS_RETRYABLE_MUTATION =
      new Predicate<MutateRowRequest>() {
        @Override
        public boolean apply(MutateRowRequest mutateRowRequest) {
          return mutateRowRequest != null
              && allCellsHaveTimestamps(mutateRowRequest.getMutationsList());
        }
      };

  @VisibleForTesting
  public static final Predicate<MutateRowsRequest> ARE_RETRYABLE_MUTATIONS =
      new Predicate<MutateRowsRequest>() {
        @Override
        public boolean apply(MutateRowsRequest mutateRowsRequest) {
          if (mutateRowsRequest == null) {
            return false;
          }
          for (Entry entry : mutateRowsRequest.getEntriesList()) {
            if (!allCellsHaveTimestamps(entry.getMutationsList())) {
              return false;
            }
          }
          return true;
        }
      };

  @VisibleForTesting
  public static final Predicate<CheckAndMutateRowRequest> IS_RETRYABLE_CHECK_AND_MUTATE =
      new Predicate<CheckAndMutateRowRequest>() {
        @Override
        public boolean apply(CheckAndMutateRowRequest checkAndMutateRowRequest) {
          return checkAndMutateRowRequest != null
              && allCellsHaveTimestamps(checkAndMutateRowRequest.getTrueMutationsList())
              && allCellsHaveTimestamps(checkAndMutateRowRequest.getFalseMutationsList());
        }
      };

  private static final boolean allCellsHaveTimestamps(Iterable<Mutation> mutations) {
    for (Mutation mut : mutations) {
      if (mut.getSetCell().getTimestampMicros() <= 0) {
        return false;
      }
    }
    return true;
  }

  // Streaming API transformers

  private static Function<List<ReadRowsResponse>, List<Row>> ROW_TRANSFORMER =
      new Function<List<ReadRowsResponse>, List<Row>>() {
        @Override
        public List<Row> apply(List<ReadRowsResponse> responses) {
          return RowMerger.toRows(responses);
        }
      };

  // Member variables

  private final ChannelPool channelPool;
  private final ScheduledExecutorService retryExecutorService;
  private final RetryOptions retryOptions;
  private final BigtableOptions bigtableOptions;
  private final BigtableResultScannerFactory<ReadRowsRequest, Row> streamingScannerFactory =
      new BigtableResultScannerFactory<ReadRowsRequest, Row>() {
        @Override
        public ResultScanner<Row> createScanner(ReadRowsRequest request) {
          return streamRows(request);
        }
      };

  private final BigtableAsyncUtilities asyncUtilities;

  private final BigtableAsyncRpc<SampleRowKeysRequest, SampleRowKeysResponse> sampleRowKeysAsync;
  private final BigtableAsyncRpc<ReadRowsRequest, ReadRowsResponse> readRowsAsync;

  private final BigtableAsyncRpc<MutateRowRequest, MutateRowResponse> mutateRowRpc;
  private final BigtableAsyncRpc<MutateRowsRequest, MutateRowsResponse> mutateRowsRpc;
  private final BigtableAsyncRpc<CheckAndMutateRowRequest, CheckAndMutateRowResponse> checkAndMutateRpc;
  private final BigtableAsyncRpc<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> readWriteModifyRpc;

  public BigtableDataGrpcClient(ChannelPool channelPool,
      ScheduledExecutorService retryExecutorService, BigtableOptions bigtableOptions) {
    this(channelPool, retryExecutorService, bigtableOptions,
        new BigtableAsyncUtilities.Default(channelPool));
  }

  @VisibleForTesting
  BigtableDataGrpcClient(
      ChannelPool channelPool,
      ScheduledExecutorService retryExecutorService,
      BigtableOptions bigtableOptions,
      BigtableAsyncUtilities asyncUtilities) {
    this.channelPool = channelPool;
    this.retryExecutorService = retryExecutorService;
    this.bigtableOptions = bigtableOptions;
    this.retryOptions = bigtableOptions.getRetryOptions();
    this.asyncUtilities = asyncUtilities;

    this.sampleRowKeysAsync =
        asyncUtilities.createStreamingAsyncRpc(
            BigtableGrpc.METHOD_SAMPLE_ROW_KEYS);
    this.readRowsAsync =
        asyncUtilities.createStreamingAsyncRpc(
            BigtableGrpc.METHOD_READ_ROWS);
    this.mutateRowRpc =
        asyncUtilities.createAsyncUnaryRpc(
            BigtableGrpc.METHOD_MUTATE_ROW,
            getMutationRetryableFunction(IS_RETRYABLE_MUTATION));
    this.mutateRowsRpc =
        asyncUtilities.createAsyncUnaryRpc(
            BigtableGrpc.METHOD_MUTATE_ROWS,
            getMutationRetryableFunction(ARE_RETRYABLE_MUTATIONS));
    this.checkAndMutateRpc =
        asyncUtilities.createAsyncUnaryRpc(
            BigtableGrpc.METHOD_CHECK_AND_MUTATE_ROW,
            getMutationRetryableFunction(IS_RETRYABLE_CHECK_AND_MUTATE));
    this.readWriteModifyRpc =
        asyncUtilities.createAsyncUnaryRpc(
            BigtableGrpc.METHOD_READ_MODIFY_WRITE_ROW,
            Predicates.<ReadModifyWriteRowRequest> alwaysFalse());
  }

  private <T> Predicate<T> getMutationRetryableFunction(Predicate<T> isRetryableMutation) {
    if (retryOptions.allowRetriesWithoutTimestamp()) {
      return Predicates.<T> alwaysTrue();
    } else {
      return isRetryableMutation;
    }
  }

  @Override
  public MutateRowResponse mutateRow(MutateRowRequest request) throws ServiceException {
    return getBlockingUnaryResult(request, mutateRowRpc);
  }

  @Override
  public ListenableFuture<MutateRowResponse> mutateRowAsync(MutateRowRequest request) {
    return getUnaryFuture(request, mutateRowRpc);
  }

  @Override
  public List<MutateRowsResponse> mutateRows(MutateRowsRequest request) throws ServiceException {
    return getBlockingStreamingResult(request, mutateRowsRpc);
  }

  @Override
  public ListenableFuture<List<MutateRowsResponse>> mutateRowsAsync(MutateRowsRequest request) {
    return getStreamingFuture(request, mutateRowsRpc);
  }

  @Override
  public CheckAndMutateRowResponse checkAndMutateRow(CheckAndMutateRowRequest request)
      throws ServiceException {
    return getBlockingUnaryResult(request, checkAndMutateRpc);
  }

  @Override
  public ListenableFuture<CheckAndMutateRowResponse> checkAndMutateRowAsync(
      CheckAndMutateRowRequest request) {
    return getUnaryFuture(request, checkAndMutateRpc);
  }

  @Override
  public ReadModifyWriteRowResponse readModifyWriteRow(ReadModifyWriteRowRequest request) {
    return getBlockingUnaryResult(request, readWriteModifyRpc);
  }

  @Override
  public ListenableFuture<ReadModifyWriteRowResponse> readModifyWriteRowAsync(
      ReadModifyWriteRowRequest request) {
    return getUnaryFuture(request, readWriteModifyRpc);
  }

  @Override
  public ImmutableList<SampleRowKeysResponse> sampleRowKeys(SampleRowKeysRequest request) {
    return ImmutableList.copyOf(getBlockingStreamingResult(request, sampleRowKeysAsync));
  }

  @Override
  public ListenableFuture<List<SampleRowKeysResponse>>
      sampleRowKeysAsync(SampleRowKeysRequest request) {
    return getStreamingFuture(request, sampleRowKeysAsync);
  }

  @Override
  public ListenableFuture<List<Row>> readRowsAsync(ReadRowsRequest request) {
    return Futures.transform(getStreamingFuture(request, readRowsAsync), ROW_TRANSFORMER);
  }

  // Helper methods

  protected <ReqT, RespT> ListenableFuture<List<RespT>> getStreamingFuture(ReqT request,
      final BigtableAsyncRpc<ReqT, RespT> rpc) {
    return getCompletionFuture(
      new RetryingCollectingClientCallListener<>(retryOptions, request, rpc, retryExecutorService));
  }

  private <ReqT, RespT> List<RespT> getBlockingStreamingResult(ReqT request,
      BigtableAsyncRpc<ReqT, RespT> rpc) {
    return getBlockingResult(
      new RetryingCollectingClientCallListener<>(retryOptions, request, rpc, retryExecutorService));
  }

  private <ReqT, RespT> ListenableFuture<RespT> getUnaryFuture(ReqT request,
      BigtableAsyncRpc<ReqT, RespT> rpc) {
    expandPoolIfNecessary(this.bigtableOptions.getChannelCount());
    return getCompletionFuture(
      new RetryingUnaryRpcListener<>(retryOptions, request, rpc, retryExecutorService));
  }

  private <ReqT, RespT> RespT getBlockingUnaryResult(ReqT request,
      BigtableAsyncRpc<ReqT, RespT> rpc) {
    return getBlockingResult(
      new RetryingUnaryRpcListener<>(retryOptions, request, rpc, retryExecutorService));
  }

  private static <ReqT, RespT, OutputT> ListenableFuture<OutputT>
      getCompletionFuture(AbstractRetryingRpcListener<ReqT, RespT, OutputT> listener) {
    listener.run();
    return listener.getCompletionFuture();
  }

  private static <ReqT, RespT, OutputT> OutputT
      getBlockingResult(AbstractRetryingRpcListener<ReqT, RespT, OutputT> listener) {
    try {
      listener.run();
      return listener.getCompletionFuture().get();
    } catch (InterruptedException e) {
      listener.cancel();
      Thread.currentThread().interrupt();
      throw Status.CANCELLED.withCause(e).asRuntimeException();
    } catch (ExecutionException e) {
      listener.cancel();
      throw Status.fromThrowable(e).asRuntimeException();
    }
  }

  // Scanner methods

  @Override
  public ResultScanner<Row> readRows(ReadRowsRequest request) {
    // Delegate all resumable operations to the scanner. It will request a non-resumable
    // scanner during operation.
    if (retryOptions.enableRetries()) {
      return new ResumingStreamingResultScanner(retryOptions, request, streamingScannerFactory);
    } else {
      return streamRows(request);
    }
  }

  private ResultScanner<Row> streamRows(ReadRowsRequest request) {
    expandPoolIfNecessary(this.bigtableOptions.getChannelCount());

    ClientCall<ReadRowsRequest, ReadRowsResponse> readRowsCall =
        channelPool.newCall(BigtableGrpc.METHOD_READ_ROWS, CallOptions.DEFAULT);

    ResponseQueueReader<Row> responseQueueReader = new ResponseQueueReader<>(
        retryOptions.getReadPartialRowTimeoutMillis(), retryOptions.getStreamingBufferSize());

    StreamObserver<ReadRowsResponse> rowMerger = new RowMerger(responseQueueReader);
    ClientCall.Listener<ReadRowsResponse> listener =
        new StreamObserverAdapter<>(readRowsCall, rowMerger);
    asyncUtilities.asyncServerStreamingCall(readRowsCall, request, listener);

    CancellationToken cancellationToken = createCancellationToken(readRowsCall);
    return new StreamingBigtableResultScanner(responseQueueReader, cancellationToken);
  }

  private CancellationToken
      createCancellationToken(final ClientCall<ReadRowsRequest, ReadRowsResponse> readRowsCall) {
    // If the scanner is closed before we're done streaming, we want to cancel the RPC.
    CancellationToken cancellationToken = new CancellationToken();
    cancellationToken.addListener(new Runnable() {
      @Override
      public void run() {
        readRowsCall.cancel();
      }
    }, MoreExecutors.directExecutor());
    return cancellationToken;
  }

  private void expandPoolIfNecessary(int channelCount) {
    try {
      this.channelPool.ensureChannelCount(channelCount);
    } catch (IOException e) {
      LOG.info("Could not expand the channel pool.", e);
    }
  }
}
