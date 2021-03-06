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
package com.google.cloud.bigtable.grpc.scanner.v2;

import com.google.bigtable.v2.Row;
import com.google.cloud.bigtable.grpc.scanner.ResultScanner;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Abstract base class for Bigtable ResultScanner implementations that provides
 * a common next(int) implementation.
 */
public abstract class AbstractBigtableResultScanner implements ResultScanner<Row> {
  @Override
  public final Row[] next(int count) throws IOException {
    ArrayList<Row> resultList = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      Row row = next();
      if (row == null) {
        break;
      }
      resultList.add(row);
    }
    return resultList.toArray(new Row[resultList.size()]);
  }
}