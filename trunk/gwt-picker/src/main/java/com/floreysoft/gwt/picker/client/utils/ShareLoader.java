/*
 * Copyright 2011 floreysoft GmbH (www.floreysoft.net)
 *
 * Written by Sergej Soller (ssoller@q-ric.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.floreysoft.gwt.picker.client.utils;

import com.google.gwt.ajaxloader.client.AjaxLoader;

/**
 * A wrapper around the ajax loader that provides convenient methods to
 * load the picker api.
 */
public class ShareLoader {
  public static final String DRIVE_SHARE_API = "drive-share";
  public static String DRIVE_SHARE_VERSION = "1";

  /**
   * Loads the picker API with the version
   * @see ShareLoader#DRIVE_SHARE_VERSION
   *
   * @param runnable The callback
   */
  public static void loadApi(String apiKey, Runnable runnable) {
    loadApi(apiKey, DRIVE_SHARE_VERSION, runnable);
  }

  /**
   * Loads the picker api with the given version
   *
   * @param version The picker version
   * @param runnable The callback
   */
  public static void loadApi(String apiKey, String version, Runnable runnable) {
    final AjaxLoader.AjaxLoaderOptions loaderOptions = AjaxLoader.AjaxLoaderOptions.newInstance();
    loadApi(apiKey, version, runnable, loaderOptions);
  }

  /**
   * Loads the picker api with the given version and options
   *
   * @param version The version to load
   * @param runnable The callback
   * @param options The ajax-loader options
   */
  public static void loadApi(String apiKey, String version, Runnable runnable, AjaxLoader.AjaxLoaderOptions options) {
    AjaxLoader.init(apiKey);
    AjaxLoader.loadApi(DRIVE_SHARE_API, version, runnable, options);
  }
}
