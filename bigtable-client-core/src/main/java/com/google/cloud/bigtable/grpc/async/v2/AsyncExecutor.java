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
package com.google.cloud.bigtable.grpc.async.v2;

import java.io.IOException;
import java.util.List;

import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.Row;
import com.google.cloud.bigtable.config.Logger;
import com.google.cloud.bigtable.grpc.async.RpcThrottler;
import com.google.cloud.bigtable.grpc.v2.BigtableDataClient;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.GeneratedMessage;

/**
 * This class provides management of asynchronous Bigtable RPCs. It ensures that there aren't too
 * many concurrent, in flight asynchronous RPCs and also makes sure that the memory used by the
 * requests doesn't exceed a threshold.
 */
public class AsyncExecutor {

  protected static final Logger LOG = new Logger(AsyncExecutor.class);

  protected interface AsyncCall<RequestT, ResponseT> {
    ListenableFuture<ResponseT> call(BigtableDataClient client, RequestT request);
  }

  /**
   * Calls {@link BigtableDataClient#mutateRowAsync(MutateRowRequest)}.
   */
  protected static AsyncCall<MutateRowRequest, MutateRowResponse> MUTATE_ROW_ASYNC =
      new AsyncCall<MutateRowRequest, MutateRowResponse>() {
        @Override
        public ListenableFuture<MutateRowResponse> call(BigtableDataClient client, MutateRowRequest request) {
          return client.mutateRowAsync(request);
        }
      };

  /**
   * Calls {@link BigtableDataClient#mutateRowsAsync(MutateRowsRequest)}.
   */
  protected static AsyncCall<MutateRowsRequest, List<MutateRowsResponse>> MUTATE_ROWS_ASYNC =
      new AsyncCall<MutateRowsRequest, List<MutateRowsResponse>>() {
        @Override
        public ListenableFuture<List<MutateRowsResponse>> call(BigtableDataClient client,
            MutateRowsRequest request) {
          return client.mutateRowsAsync(request);
        }
      };

  /**
   * Calls {@link BigtableDataClient#readModifyWriteRowAsync(ReadModifyWriteRowRequest)}.
   */
  protected static AsyncCall<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> READ_MODIFY_WRITE_ASYNC =
      new AsyncCall<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>() {
        @Override
        public ListenableFuture<ReadModifyWriteRowResponse> call(BigtableDataClient client,
            ReadModifyWriteRowRequest request) {
          return client.readModifyWriteRowAsync(request);
        }
      };

  /**
   * Calls {@link BigtableDataClient#checkAndMutateRowAsync(CheckAndMutateRowRequest)}.
   */
  protected static AsyncCall<CheckAndMutateRowRequest, CheckAndMutateRowResponse> CHECK_AND_MUTATE_ASYNC =
      new AsyncCall<CheckAndMutateRowRequest, CheckAndMutateRowResponse>() {
        @Override
        public ListenableFuture<CheckAndMutateRowResponse> call(BigtableDataClient client,
            CheckAndMutateRowRequest request) {
          return client.checkAndMutateRowAsync(request);
        }
      };

  /**
   * Calls {@link BigtableDataClient#readRowsAsync(ReadRowsRequest)}.
   */
  protected static AsyncCall<ReadRowsRequest, List<Row>> READ_ROWS_ASYNC =
      new AsyncCall<ReadRowsRequest, List<Row>>() {
        @Override
        public ListenableFuture<List<Row>> call(BigtableDataClient client, ReadRowsRequest request) {
          return client.readRowsAsync(request);
        }
      };

  private final BigtableDataClient client;
  private final RpcThrottler rpcThrottler;

  public AsyncExecutor(BigtableDataClient client, RpcThrottler rpcThrottler) {
    this.client = client;
    this.rpcThrottler = rpcThrottler;
  }

  /**
   * Performs a {@link BigtableDataClient#mutateRowAsync(MutateRowRequest)} on the
   * {@link MutateRowRequest} given an operationId generated from
   * {@link RpcThrottler#registerOperationWithHeapSize(long)}.
   *
   * @param request The {@link MutateRowRequest} to send.
   * @param operationId The Id generated from
   *          {@link RpcThrottler#registerOperationWithHeapSize(long)} that will be released when
   *          the mutate operation is completed.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<MutateRowResponse> mutateRowAsync(MutateRowRequest request,
      long operationId) {
    return call(MUTATE_ROW_ASYNC, request, operationId);
  }

  /**
   * Performs a {@link BigtableDataClient#mutateRowsAsync(MutateRowsRequest)} on the
   * {@link MutateRowsRequest} given an operationId generated from
   * {@link RpcThrottler#registerOperationWithHeapSize(long)}.
   *
   * @param request The {@link MutateRowsRequest} to send.
   * @param operationId The Id generated from
   *          {@link RpcThrottler#registerOperationWithHeapSize(long)} that will be released when
   *          the mutate operation is completed.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<List<MutateRowsResponse>> mutateRowAsync(MutateRowsRequest request,
      long operationId) {
    return call(MUTATE_ROWS_ASYNC, request, operationId);
  }

  /**
   * Performs a {@link BigtableDataClient#checkAndMutateRowAsync(CheckAndMutateRowRequest)} on the
   * {@link CheckAndMutateRowRequest} given an operationId generated from
   * {@link RpcThrottler#registerOperationWithHeapSize(long)}.
   *
   * @param request The {@link CheckAndMutateRowRequest} to send.
   * @param operationId The Id generated from
   *          {@link RpcThrottler#registerOperationWithHeapSize(long)} that will be released when
   *          the checkAndMutateRow operation is completed.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<CheckAndMutateRowResponse> checkAndMutateRowAsync(
      CheckAndMutateRowRequest request, long operationId) {
    return call(CHECK_AND_MUTATE_ASYNC, request, operationId);
  }

  /**
   * Performs a {@link BigtableDataClient#readModifyWriteRowAsync(ReadModifyWriteRowRequest)} on the
   * {@link ReadModifyWriteRowRequest} given an operationId generated from
   * {@link RpcThrottler#registerOperationWithHeapSize(long)}.
   *
   * @param request The {@link ReadModifyWriteRowRequest} to send.
   * @param operationId The Id generated from
   *          {@link RpcThrottler#registerOperationWithHeapSize(long)} that will be released when
   *          the readModifyWriteRowAsync operation is completed.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<ReadModifyWriteRowResponse>
      readModifyWriteRowAsync(ReadModifyWriteRowRequest request, long operationId) {
    return call(READ_MODIFY_WRITE_ASYNC, request, operationId);
  }

  /**
   * Performs a {@link BigtableDataClient#readRowsAsync(ReadRowsRequest)} on the
   * {@link ReadRowsRequest} given an operationId generated from
   * {@link RpcThrottler#registerOperationWithHeapSize(long)}.
   *
   * @param request The {@link ReadRowsRequest} to send.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<List<Row>> readRowsAsync(ReadRowsRequest request, long operationId) {
    return call(READ_ROWS_ASYNC, request, operationId);
  }

  /**
   * Performs a {@link BigtableDataClient#mutateRowAsync(MutateRowRequest)} on the
   * {@link MutateRowRequest}. This method may block if
   * {@link RpcThrottler#registerOperationWithHeapSize(long)} blocks.
   *
   * @param request The {@link MutateRowRequest} to send.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<MutateRowResponse> mutateRowAsync(MutateRowRequest request)
      throws InterruptedException {
    return call(MUTATE_ROW_ASYNC, request);
  }

  /**
   * Performs a {@link BigtableDataClient#mutateRowsAsync(MutateRowsRequest)} on the
   * {@link MutateRowsRequest}. This method may block if
   * {@link RpcThrottler#registerOperationWithHeapSize(long)} blocks.
   * @param request The {@link MutateRowRequest} to send.
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<List<MutateRowsResponse>> mutateRowsAsync(MutateRowsRequest request)
      throws InterruptedException {
    return call(MUTATE_ROWS_ASYNC, request);
  }

  /**
   * Performs a {@link BigtableDataClient#checkAndMutateRowAsync(CheckAndMutateRowRequest)} on the
   * {@link CheckAndMutateRowRequest}. This method may block if
   * {@link RpcThrottler#registerOperationWithHeapSize(long)} blocks.
   *
   * @param request The {@link CheckAndMutateRowRequest} to send.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<CheckAndMutateRowResponse> checkAndMutateRowAsync(
      CheckAndMutateRowRequest request) throws InterruptedException {
    return call(CHECK_AND_MUTATE_ASYNC, request);
  }

  /**
   * Performs a {@link BigtableDataClient#readModifyWriteRow(ReadModifyWriteRowRequest)} on the
   * {@link ReadModifyWriteRowRequest}. This method may block if
   * {@link RpcThrottler#registerOperationWithHeapSize(long)} blocks.
   *
   * @param request The {@link ReadModifyWriteRowRequest} to send.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<ReadModifyWriteRowResponse>
      readModifyWriteRowAsync(ReadModifyWriteRowRequest request) throws InterruptedException {
    return call(READ_MODIFY_WRITE_ASYNC, request);
  }

  /**
   * Performs a {@link BigtableDataClient#readRowsAsync(ReadRowsRequest)} on the
   * {@link ReadRowsRequest}. This method may block if
   * {@link RpcThrottler#registerOperationWithHeapSize(long)} blocks.
   *
   * @param request The {@link ReadRowsRequest} to send.
   *
   * @return a {@link ListenableFuture} which can be listened to for completion events.
   */
  public ListenableFuture<List<Row>> readRowsAsync(ReadRowsRequest request)
      throws InterruptedException {
    return call(READ_ROWS_ASYNC, request);
  }

  private <RequestT extends GeneratedMessage, ResponseT> ListenableFuture<ResponseT> call(
      AsyncCall<RequestT, ResponseT> rpc, RequestT request) throws InterruptedException {
    // Wait until both the memory and rpc count maximum requirements are achieved before getting a
    // unique id used to track this request.
    long id = rpcThrottler.registerOperationWithHeapSize(request.getSerializedSize());
    return call(rpc, request, id);
  }

  private <ResponseT, RequestT extends GeneratedMessage> ListenableFuture<ResponseT>
      call(AsyncCall<RequestT, ResponseT> rpc, RequestT request, long id) {
    ListenableFuture<ResponseT> future;
    try {
      future = rpc.call(client, request);
    } catch (Exception e) {
      future = Futures.immediateFailedFuture(e);
    }
    rpcThrottler.addCallback(future, id);
    return future;
  }

  /**
   * Waits until all operations managed by the {@link RpcThrottler} complete. See
   * {@link RpcThrottler#awaitCompletion()} for more information.
   *
   * @throws IOException if something goes wrong.
   */
  public void flush() throws IOException {
    LOG.trace("Flushing");
    try {
      rpcThrottler.awaitCompletion();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IOException("Batch operations were interrupted.");
    }
    LOG.trace("Done flushing");
  }

  public boolean hasInflightRequests() {
    return rpcThrottler.hasInflightRequests();
  }

  public long getMaxHeapSize() {
    return rpcThrottler.getMaxHeapSize();
  }

  public BigtableDataClient getClient() {
    return client;
  }

  public RpcThrottler getRpcThrottler() {
    return rpcThrottler;
  }
}