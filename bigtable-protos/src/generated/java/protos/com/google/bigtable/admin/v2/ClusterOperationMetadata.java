// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/bigtable/admin/v2/bigtable_instance_admin.proto

package com.google.bigtable.admin.v2;

/**
 * Protobuf type {@code google.bigtable.admin.v2.ClusterOperationMetadata}
 */
public  final class ClusterOperationMetadata extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:google.bigtable.admin.v2.ClusterOperationMetadata)
    ClusterOperationMetadataOrBuilder {
  // Use ClusterOperationMetadata.newBuilder() to construct.
  private ClusterOperationMetadata(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private ClusterOperationMetadata() {
    name_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ClusterOperationMetadata(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 18: {
            com.google.bigtable.admin.v2.Progress.Builder subBuilder = null;
            if (tablesCopied_ != null) {
              subBuilder = tablesCopied_.toBuilder();
            }
            tablesCopied_ = input.readMessage(com.google.bigtable.admin.v2.Progress.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(tablesCopied_);
              tablesCopied_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.google.bigtable.admin.v2.Progress.Builder subBuilder = null;
            if (serveNodesAllocated_ != null) {
              subBuilder = serveNodesAllocated_.toBuilder();
            }
            serveNodesAllocated_ = input.readMessage(com.google.bigtable.admin.v2.Progress.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(serveNodesAllocated_);
              serveNodesAllocated_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw new RuntimeException(e.setUnfinishedMessage(this));
    } catch (java.io.IOException e) {
      throw new RuntimeException(
          new com.google.protobuf.InvalidProtocolBufferException(
              e.getMessage()).setUnfinishedMessage(this));
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.bigtable.admin.v2.BigtableInstanceAdminProto.internal_static_google_bigtable_admin_v2_ClusterOperationMetadata_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.bigtable.admin.v2.BigtableInstanceAdminProto.internal_static_google_bigtable_admin_v2_ClusterOperationMetadata_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.bigtable.admin.v2.ClusterOperationMetadata.class, com.google.bigtable.admin.v2.ClusterOperationMetadata.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <code>optional string name = 1;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>optional string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TABLES_COPIED_FIELD_NUMBER = 2;
  private com.google.bigtable.admin.v2.Progress tablesCopied_;
  /**
   * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
   *
   * <pre>
   * Present if the operation involves the copying of table data
   * into the cluster.
   * </pre>
   */
  public boolean hasTablesCopied() {
    return tablesCopied_ != null;
  }
  /**
   * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
   *
   * <pre>
   * Present if the operation involves the copying of table data
   * into the cluster.
   * </pre>
   */
  public com.google.bigtable.admin.v2.Progress getTablesCopied() {
    return tablesCopied_ == null ? com.google.bigtable.admin.v2.Progress.getDefaultInstance() : tablesCopied_;
  }
  /**
   * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
   *
   * <pre>
   * Present if the operation involves the copying of table data
   * into the cluster.
   * </pre>
   */
  public com.google.bigtable.admin.v2.ProgressOrBuilder getTablesCopiedOrBuilder() {
    return getTablesCopied();
  }

  public static final int SERVE_NODES_ALLOCATED_FIELD_NUMBER = 3;
  private com.google.bigtable.admin.v2.Progress serveNodesAllocated_;
  /**
   * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
   *
   * <pre>
   * Present if the operation involves (de)allocating serve nodes
   * in the cluster.
   * </pre>
   */
  public boolean hasServeNodesAllocated() {
    return serveNodesAllocated_ != null;
  }
  /**
   * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
   *
   * <pre>
   * Present if the operation involves (de)allocating serve nodes
   * in the cluster.
   * </pre>
   */
  public com.google.bigtable.admin.v2.Progress getServeNodesAllocated() {
    return serveNodesAllocated_ == null ? com.google.bigtable.admin.v2.Progress.getDefaultInstance() : serveNodesAllocated_;
  }
  /**
   * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
   *
   * <pre>
   * Present if the operation involves (de)allocating serve nodes
   * in the cluster.
   * </pre>
   */
  public com.google.bigtable.admin.v2.ProgressOrBuilder getServeNodesAllocatedOrBuilder() {
    return getServeNodesAllocated();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, name_);
    }
    if (tablesCopied_ != null) {
      output.writeMessage(2, getTablesCopied());
    }
    if (serveNodesAllocated_ != null) {
      output.writeMessage(3, getServeNodesAllocated());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, name_);
    }
    if (tablesCopied_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getTablesCopied());
    }
    if (serveNodesAllocated_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getServeNodesAllocated());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.google.bigtable.admin.v2.ClusterOperationMetadata parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.bigtable.admin.v2.ClusterOperationMetadata prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code google.bigtable.admin.v2.ClusterOperationMetadata}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.bigtable.admin.v2.ClusterOperationMetadata)
      com.google.bigtable.admin.v2.ClusterOperationMetadataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.bigtable.admin.v2.BigtableInstanceAdminProto.internal_static_google_bigtable_admin_v2_ClusterOperationMetadata_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.bigtable.admin.v2.BigtableInstanceAdminProto.internal_static_google_bigtable_admin_v2_ClusterOperationMetadata_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.bigtable.admin.v2.ClusterOperationMetadata.class, com.google.bigtable.admin.v2.ClusterOperationMetadata.Builder.class);
    }

    // Construct using com.google.bigtable.admin.v2.ClusterOperationMetadata.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      name_ = "";

      if (tablesCopiedBuilder_ == null) {
        tablesCopied_ = null;
      } else {
        tablesCopied_ = null;
        tablesCopiedBuilder_ = null;
      }
      if (serveNodesAllocatedBuilder_ == null) {
        serveNodesAllocated_ = null;
      } else {
        serveNodesAllocated_ = null;
        serveNodesAllocatedBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.bigtable.admin.v2.BigtableInstanceAdminProto.internal_static_google_bigtable_admin_v2_ClusterOperationMetadata_descriptor;
    }

    public com.google.bigtable.admin.v2.ClusterOperationMetadata getDefaultInstanceForType() {
      return com.google.bigtable.admin.v2.ClusterOperationMetadata.getDefaultInstance();
    }

    public com.google.bigtable.admin.v2.ClusterOperationMetadata build() {
      com.google.bigtable.admin.v2.ClusterOperationMetadata result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.bigtable.admin.v2.ClusterOperationMetadata buildPartial() {
      com.google.bigtable.admin.v2.ClusterOperationMetadata result = new com.google.bigtable.admin.v2.ClusterOperationMetadata(this);
      result.name_ = name_;
      if (tablesCopiedBuilder_ == null) {
        result.tablesCopied_ = tablesCopied_;
      } else {
        result.tablesCopied_ = tablesCopiedBuilder_.build();
      }
      if (serveNodesAllocatedBuilder_ == null) {
        result.serveNodesAllocated_ = serveNodesAllocated_;
      } else {
        result.serveNodesAllocated_ = serveNodesAllocatedBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.bigtable.admin.v2.ClusterOperationMetadata) {
        return mergeFrom((com.google.bigtable.admin.v2.ClusterOperationMetadata)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.bigtable.admin.v2.ClusterOperationMetadata other) {
      if (other == com.google.bigtable.admin.v2.ClusterOperationMetadata.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.hasTablesCopied()) {
        mergeTablesCopied(other.getTablesCopied());
      }
      if (other.hasServeNodesAllocated()) {
        mergeServeNodesAllocated(other.getServeNodesAllocated());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.bigtable.admin.v2.ClusterOperationMetadata parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.bigtable.admin.v2.ClusterOperationMetadata) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>optional string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private com.google.bigtable.admin.v2.Progress tablesCopied_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        com.google.bigtable.admin.v2.Progress, com.google.bigtable.admin.v2.Progress.Builder, com.google.bigtable.admin.v2.ProgressOrBuilder> tablesCopiedBuilder_;
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public boolean hasTablesCopied() {
      return tablesCopiedBuilder_ != null || tablesCopied_ != null;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Progress getTablesCopied() {
      if (tablesCopiedBuilder_ == null) {
        return tablesCopied_ == null ? com.google.bigtable.admin.v2.Progress.getDefaultInstance() : tablesCopied_;
      } else {
        return tablesCopiedBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public Builder setTablesCopied(com.google.bigtable.admin.v2.Progress value) {
      if (tablesCopiedBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        tablesCopied_ = value;
        onChanged();
      } else {
        tablesCopiedBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public Builder setTablesCopied(
        com.google.bigtable.admin.v2.Progress.Builder builderForValue) {
      if (tablesCopiedBuilder_ == null) {
        tablesCopied_ = builderForValue.build();
        onChanged();
      } else {
        tablesCopiedBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public Builder mergeTablesCopied(com.google.bigtable.admin.v2.Progress value) {
      if (tablesCopiedBuilder_ == null) {
        if (tablesCopied_ != null) {
          tablesCopied_ =
            com.google.bigtable.admin.v2.Progress.newBuilder(tablesCopied_).mergeFrom(value).buildPartial();
        } else {
          tablesCopied_ = value;
        }
        onChanged();
      } else {
        tablesCopiedBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public Builder clearTablesCopied() {
      if (tablesCopiedBuilder_ == null) {
        tablesCopied_ = null;
        onChanged();
      } else {
        tablesCopied_ = null;
        tablesCopiedBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Progress.Builder getTablesCopiedBuilder() {
      
      onChanged();
      return getTablesCopiedFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ProgressOrBuilder getTablesCopiedOrBuilder() {
      if (tablesCopiedBuilder_ != null) {
        return tablesCopiedBuilder_.getMessageOrBuilder();
      } else {
        return tablesCopied_ == null ?
            com.google.bigtable.admin.v2.Progress.getDefaultInstance() : tablesCopied_;
      }
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress tables_copied = 2;</code>
     *
     * <pre>
     * Present if the operation involves the copying of table data
     * into the cluster.
     * </pre>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.bigtable.admin.v2.Progress, com.google.bigtable.admin.v2.Progress.Builder, com.google.bigtable.admin.v2.ProgressOrBuilder> 
        getTablesCopiedFieldBuilder() {
      if (tablesCopiedBuilder_ == null) {
        tablesCopiedBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.bigtable.admin.v2.Progress, com.google.bigtable.admin.v2.Progress.Builder, com.google.bigtable.admin.v2.ProgressOrBuilder>(
                getTablesCopied(),
                getParentForChildren(),
                isClean());
        tablesCopied_ = null;
      }
      return tablesCopiedBuilder_;
    }

    private com.google.bigtable.admin.v2.Progress serveNodesAllocated_ = null;
    private com.google.protobuf.SingleFieldBuilder<
        com.google.bigtable.admin.v2.Progress, com.google.bigtable.admin.v2.Progress.Builder, com.google.bigtable.admin.v2.ProgressOrBuilder> serveNodesAllocatedBuilder_;
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public boolean hasServeNodesAllocated() {
      return serveNodesAllocatedBuilder_ != null || serveNodesAllocated_ != null;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Progress getServeNodesAllocated() {
      if (serveNodesAllocatedBuilder_ == null) {
        return serveNodesAllocated_ == null ? com.google.bigtable.admin.v2.Progress.getDefaultInstance() : serveNodesAllocated_;
      } else {
        return serveNodesAllocatedBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public Builder setServeNodesAllocated(com.google.bigtable.admin.v2.Progress value) {
      if (serveNodesAllocatedBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        serveNodesAllocated_ = value;
        onChanged();
      } else {
        serveNodesAllocatedBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public Builder setServeNodesAllocated(
        com.google.bigtable.admin.v2.Progress.Builder builderForValue) {
      if (serveNodesAllocatedBuilder_ == null) {
        serveNodesAllocated_ = builderForValue.build();
        onChanged();
      } else {
        serveNodesAllocatedBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public Builder mergeServeNodesAllocated(com.google.bigtable.admin.v2.Progress value) {
      if (serveNodesAllocatedBuilder_ == null) {
        if (serveNodesAllocated_ != null) {
          serveNodesAllocated_ =
            com.google.bigtable.admin.v2.Progress.newBuilder(serveNodesAllocated_).mergeFrom(value).buildPartial();
        } else {
          serveNodesAllocated_ = value;
        }
        onChanged();
      } else {
        serveNodesAllocatedBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public Builder clearServeNodesAllocated() {
      if (serveNodesAllocatedBuilder_ == null) {
        serveNodesAllocated_ = null;
        onChanged();
      } else {
        serveNodesAllocated_ = null;
        serveNodesAllocatedBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.Progress.Builder getServeNodesAllocatedBuilder() {
      
      onChanged();
      return getServeNodesAllocatedFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    public com.google.bigtable.admin.v2.ProgressOrBuilder getServeNodesAllocatedOrBuilder() {
      if (serveNodesAllocatedBuilder_ != null) {
        return serveNodesAllocatedBuilder_.getMessageOrBuilder();
      } else {
        return serveNodesAllocated_ == null ?
            com.google.bigtable.admin.v2.Progress.getDefaultInstance() : serveNodesAllocated_;
      }
    }
    /**
     * <code>optional .google.bigtable.admin.v2.Progress serve_nodes_allocated = 3;</code>
     *
     * <pre>
     * Present if the operation involves (de)allocating serve nodes
     * in the cluster.
     * </pre>
     */
    private com.google.protobuf.SingleFieldBuilder<
        com.google.bigtable.admin.v2.Progress, com.google.bigtable.admin.v2.Progress.Builder, com.google.bigtable.admin.v2.ProgressOrBuilder> 
        getServeNodesAllocatedFieldBuilder() {
      if (serveNodesAllocatedBuilder_ == null) {
        serveNodesAllocatedBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            com.google.bigtable.admin.v2.Progress, com.google.bigtable.admin.v2.Progress.Builder, com.google.bigtable.admin.v2.ProgressOrBuilder>(
                getServeNodesAllocated(),
                getParentForChildren(),
                isClean());
        serveNodesAllocated_ = null;
      }
      return serveNodesAllocatedBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:google.bigtable.admin.v2.ClusterOperationMetadata)
  }

  // @@protoc_insertion_point(class_scope:google.bigtable.admin.v2.ClusterOperationMetadata)
  private static final com.google.bigtable.admin.v2.ClusterOperationMetadata DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.bigtable.admin.v2.ClusterOperationMetadata();
  }

  public static com.google.bigtable.admin.v2.ClusterOperationMetadata getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ClusterOperationMetadata>
      PARSER = new com.google.protobuf.AbstractParser<ClusterOperationMetadata>() {
    public ClusterOperationMetadata parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new ClusterOperationMetadata(input, extensionRegistry);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof
            com.google.protobuf.InvalidProtocolBufferException) {
          throw (com.google.protobuf.InvalidProtocolBufferException)
              e.getCause();
        }
        throw e;
      }
    }
  };

  public static com.google.protobuf.Parser<ClusterOperationMetadata> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ClusterOperationMetadata> getParserForType() {
    return PARSER;
  }

  public com.google.bigtable.admin.v2.ClusterOperationMetadata getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

