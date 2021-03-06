// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/bigtable/v2/bigtable.proto

package com.google.bigtable.v2;

public interface ReadRowsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.bigtable.v2.ReadRowsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string table_name = 1;</code>
   *
   * <pre>
   * The unique name of the table from which to read.
   * Values are of the form
   * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
   * </pre>
   */
  java.lang.String getTableName();
  /**
   * <code>optional string table_name = 1;</code>
   *
   * <pre>
   * The unique name of the table from which to read.
   * Values are of the form
   * projects/&lt;project&gt;/instances/&lt;instance&gt;/tables/&lt;table&gt;
   * </pre>
   */
  com.google.protobuf.ByteString
      getTableNameBytes();

  /**
   * <code>optional .google.bigtable.v2.RowSet rows = 2;</code>
   *
   * <pre>
   * The row keys and/or ranges to read. If not specified, reads from all rows.
   * </pre>
   */
  boolean hasRows();
  /**
   * <code>optional .google.bigtable.v2.RowSet rows = 2;</code>
   *
   * <pre>
   * The row keys and/or ranges to read. If not specified, reads from all rows.
   * </pre>
   */
  com.google.bigtable.v2.RowSet getRows();
  /**
   * <code>optional .google.bigtable.v2.RowSet rows = 2;</code>
   *
   * <pre>
   * The row keys and/or ranges to read. If not specified, reads from all rows.
   * </pre>
   */
  com.google.bigtable.v2.RowSetOrBuilder getRowsOrBuilder();

  /**
   * <code>optional .google.bigtable.v2.RowFilter filter = 3;</code>
   *
   * <pre>
   * The filter to apply to the contents of the specified row(s). If unset,
   * reads the entirety of each row.
   * </pre>
   */
  boolean hasFilter();
  /**
   * <code>optional .google.bigtable.v2.RowFilter filter = 3;</code>
   *
   * <pre>
   * The filter to apply to the contents of the specified row(s). If unset,
   * reads the entirety of each row.
   * </pre>
   */
  com.google.bigtable.v2.RowFilter getFilter();
  /**
   * <code>optional .google.bigtable.v2.RowFilter filter = 3;</code>
   *
   * <pre>
   * The filter to apply to the contents of the specified row(s). If unset,
   * reads the entirety of each row.
   * </pre>
   */
  com.google.bigtable.v2.RowFilterOrBuilder getFilterOrBuilder();

  /**
   * <code>optional int64 rows_limit = 4;</code>
   *
   * <pre>
   * The read will terminate after committing to N rows' worth of results. The
   * default (zero) is to return all results.
   * </pre>
   */
  long getRowsLimit();
}
