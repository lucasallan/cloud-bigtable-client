// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/bigtable/admin/v2/bigtable_instance_admin.proto

package com.google.bigtable.admin.v2;

public interface CreateClusterRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.bigtable.admin.v2.CreateClusterRequest)
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
   * <code>optional string cluster_id = 2;</code>
   */
  java.lang.String getClusterId();
  /**
   * <code>optional string cluster_id = 2;</code>
   */
  com.google.protobuf.ByteString
      getClusterIdBytes();

  /**
   * <code>optional .google.bigtable.admin.v2.Cluster cluster = 3;</code>
   */
  boolean hasCluster();
  /**
   * <code>optional .google.bigtable.admin.v2.Cluster cluster = 3;</code>
   */
  com.google.bigtable.admin.v2.Cluster getCluster();
  /**
   * <code>optional .google.bigtable.admin.v2.Cluster cluster = 3;</code>
   */
  com.google.bigtable.admin.v2.ClusterOrBuilder getClusterOrBuilder();
}
