// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/bigtable/v2/bigtable.proto

package com.google.bigtable.v2;

/**
 * Protobuf type {@code google.bigtable.v2.SampleRowKeysRequest}
 *
 * <pre>
 * Request message for Bigtable.SampleRowKeys.
 * </pre>
 */
public  final class SampleRowKeysRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:google.bigtable.v2.SampleRowKeysRequest)
    SampleRowKeysRequestOrBuilder {
  // Use SampleRowKeysRequest.newBuilder() to construct.
  private SampleRowKeysRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private SampleRowKeysRequest() {
    tableName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private SampleRowKeysRequest(
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

            tableName_ = s;
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
    return com.google.bigtable.v2.BigtableProto.internal_static_google_bigtable_v2_SampleRowKeysRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.bigtable.v2.BigtableProto.internal_static_google_bigtable_v2_SampleRowKeysRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.bigtable.v2.SampleRowKeysRequest.class, com.google.bigtable.v2.SampleRowKeysRequest.Builder.class);
  }

  public static final int TABLE_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object tableName_;
  /**
   * <code>optional string table_name = 1;</code>
   *
   * <pre>
   * The unique name of the table from which to sample row keys.
   * Values are of the form
   * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
   * </pre>
   */
  public java.lang.String getTableName() {
    java.lang.Object ref = tableName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      tableName_ = s;
      return s;
    }
  }
  /**
   * <code>optional string table_name = 1;</code>
   *
   * <pre>
   * The unique name of the table from which to sample row keys.
   * Values are of the form
   * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
   * </pre>
   */
  public com.google.protobuf.ByteString
      getTableNameBytes() {
    java.lang.Object ref = tableName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      tableName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getTableNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, tableName_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTableNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, tableName_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.google.bigtable.v2.SampleRowKeysRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.bigtable.v2.SampleRowKeysRequest prototype) {
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
   * Protobuf type {@code google.bigtable.v2.SampleRowKeysRequest}
   *
   * <pre>
   * Request message for Bigtable.SampleRowKeys.
   * </pre>
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.bigtable.v2.SampleRowKeysRequest)
      com.google.bigtable.v2.SampleRowKeysRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.bigtable.v2.BigtableProto.internal_static_google_bigtable_v2_SampleRowKeysRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.bigtable.v2.BigtableProto.internal_static_google_bigtable_v2_SampleRowKeysRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.bigtable.v2.SampleRowKeysRequest.class, com.google.bigtable.v2.SampleRowKeysRequest.Builder.class);
    }

    // Construct using com.google.bigtable.v2.SampleRowKeysRequest.newBuilder()
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
      tableName_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.bigtable.v2.BigtableProto.internal_static_google_bigtable_v2_SampleRowKeysRequest_descriptor;
    }

    public com.google.bigtable.v2.SampleRowKeysRequest getDefaultInstanceForType() {
      return com.google.bigtable.v2.SampleRowKeysRequest.getDefaultInstance();
    }

    public com.google.bigtable.v2.SampleRowKeysRequest build() {
      com.google.bigtable.v2.SampleRowKeysRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.bigtable.v2.SampleRowKeysRequest buildPartial() {
      com.google.bigtable.v2.SampleRowKeysRequest result = new com.google.bigtable.v2.SampleRowKeysRequest(this);
      result.tableName_ = tableName_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.bigtable.v2.SampleRowKeysRequest) {
        return mergeFrom((com.google.bigtable.v2.SampleRowKeysRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.bigtable.v2.SampleRowKeysRequest other) {
      if (other == com.google.bigtable.v2.SampleRowKeysRequest.getDefaultInstance()) return this;
      if (!other.getTableName().isEmpty()) {
        tableName_ = other.tableName_;
        onChanged();
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
      com.google.bigtable.v2.SampleRowKeysRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.bigtable.v2.SampleRowKeysRequest) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object tableName_ = "";
    /**
     * <code>optional string table_name = 1;</code>
     *
     * <pre>
     * The unique name of the table from which to sample row keys.
     * Values are of the form
     * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
     * </pre>
     */
    public java.lang.String getTableName() {
      java.lang.Object ref = tableName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tableName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string table_name = 1;</code>
     *
     * <pre>
     * The unique name of the table from which to sample row keys.
     * Values are of the form
     * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
     * </pre>
     */
    public com.google.protobuf.ByteString
        getTableNameBytes() {
      java.lang.Object ref = tableName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        tableName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string table_name = 1;</code>
     *
     * <pre>
     * The unique name of the table from which to sample row keys.
     * Values are of the form
     * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
     * </pre>
     */
    public Builder setTableName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      tableName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string table_name = 1;</code>
     *
     * <pre>
     * The unique name of the table from which to sample row keys.
     * Values are of the form
     * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
     * </pre>
     */
    public Builder clearTableName() {
      
      tableName_ = getDefaultInstance().getTableName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string table_name = 1;</code>
     *
     * <pre>
     * The unique name of the table from which to sample row keys.
     * Values are of the form
     * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
     * </pre>
     */
    public Builder setTableNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      tableName_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:google.bigtable.v2.SampleRowKeysRequest)
  }

  // @@protoc_insertion_point(class_scope:google.bigtable.v2.SampleRowKeysRequest)
  private static final com.google.bigtable.v2.SampleRowKeysRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.bigtable.v2.SampleRowKeysRequest();
  }

  public static com.google.bigtable.v2.SampleRowKeysRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SampleRowKeysRequest>
      PARSER = new com.google.protobuf.AbstractParser<SampleRowKeysRequest>() {
    public SampleRowKeysRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new SampleRowKeysRequest(input, extensionRegistry);
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

  public static com.google.protobuf.Parser<SampleRowKeysRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SampleRowKeysRequest> getParserForType() {
    return PARSER;
  }

  public com.google.bigtable.v2.SampleRowKeysRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

