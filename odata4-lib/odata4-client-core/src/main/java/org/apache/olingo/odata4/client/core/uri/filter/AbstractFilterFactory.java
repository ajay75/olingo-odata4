/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.odata4.client.core.uri.filter;

import org.apache.olingo.odata4.client.api.uri.filter.URIFilter;
import org.apache.olingo.odata4.client.api.uri.filter.FilterArg;
import org.apache.olingo.odata4.client.api.uri.filter.FilterFactory;

public abstract class AbstractFilterFactory implements FilterFactory {

  private static final long serialVersionUID = -6141317149802621836L;

  protected static final String NULL = "null";

  @Override
  public URIFilter match(final FilterArg arg) {
    return new MatchFilter(arg);
  }

  @Override
  public URIFilter eq(final String key, final Object value) {
    return new EqFilter(FilterArgFactory.property(key), FilterArgFactory.literal(value));
  }

  @Override
  public URIFilter eq(final FilterArg left, final FilterArg right) {
    return new EqFilter(left, right);
  }

  @Override
  public URIFilter ne(final String key, final Object value) {
    return new NeFilter(FilterArgFactory.property(key), FilterArgFactory.literal(value));
  }

  @Override
  public URIFilter ne(final FilterArg left, final FilterArg right) {
    return new NeFilter(left, right);
  }

  @Override
  public URIFilter gt(final String key, final Object value) {
    return new GtFilter(FilterArgFactory.property(key), FilterArgFactory.literal(value));
  }

  @Override
  public URIFilter gt(final FilterArg left, final FilterArg right) {
    return new GtFilter(left, right);
  }

  @Override
  public URIFilter ge(final String key, final Object value) {
    return new GeFilter(FilterArgFactory.property(key), FilterArgFactory.literal(value));
  }

  @Override
  public URIFilter ge(final FilterArg left, final FilterArg right) {
    return new GeFilter(left, right);
  }

  @Override
  public URIFilter lt(final String key, final Object value) {
    return new LtFilter(FilterArgFactory.property(key), FilterArgFactory.literal(value));
  }

  @Override
  public URIFilter lt(final FilterArg left, final FilterArg right) {
    return new LtFilter(left, right);
  }

  @Override
  public URIFilter le(final String key, final Object value) {
    return new LeFilter(FilterArgFactory.property(key), FilterArgFactory.literal(value));
  }

  @Override
  public URIFilter le(final FilterArg left, final FilterArg right) {
    return new LeFilter(left, right);
  }

  @Override
  public URIFilter and(final URIFilter left, final URIFilter right) {
    return new AndFilter(left, right);
  }

  @Override
  public URIFilter or(final URIFilter left, final URIFilter right) {
    return new OrFilter(left, right);
  }

  @Override
  public URIFilter not(final URIFilter filter) {
    return new NotFilter(filter);
  }
}
