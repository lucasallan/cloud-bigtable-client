// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/bigtable/admin/v2/bigtable_instance_admin.proto

package com.google.bigtable.admin.v2;

public interface ClusterOperationMetadataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.bigtable.admin.v2.ClusterOperationMetadata)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
   *
   * <pre>
   * Present if the operation involves the copying of table data
   * into the cluster.
   * </pre>
   */
  boolean hasTablesCopied();
  /**
   * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
   *
   * <pre>
   * Present if the operation involves the copying of table data
   * into the cluster.
   * </pre>
   */
  com.google.bigtable.admin.v2.Progress getTablesCopied();
  /**
   * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
   *
   * <pre>
   * Present if the operation involves the copying of table data
   * into the cluster.
   * </pre>
   */
  com.google.bigtable.admin.v2.ProgressOrBuilder getTablesCopiedOrBuilder();

  /**
   * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
   *
   * <pre>
   * Present if the operation involves (de)allocating serve nodes
   * in the cluster.
   * </pre>
   */
  boolean hasServeNodesAllocated();
  /**
   * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
   *
   * <pre>
   * Present if the operation involves (de)allocating serve nodes
   * in the cluster.
   * </pre>
   */
  com.google.bigtable.admin.v2.Progress getServeNodesAllocated();
  /**
   * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
   *
   * <pre>
   * Present if the operation involves (de)allocating serve nodes
   * in the cluster.
   * </pre>
   */
  com.google.bigtable.admin.v2.ProgressOrBuilder getServeNodesAllocatedOrBuilder();
}
