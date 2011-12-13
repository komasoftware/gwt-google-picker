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

package com.floreysoft.gwt.picker.client.domain;

import com.floreysoft.gwt.picker.client.utils.JavaScriptUtils;

/**
 * Feature is an enumerated type, for turning on/off features for various views.
 * Use these values in calls to @see PickerBuilder#enableFeature and @see PickerBuilder#disableFeature.
 */
public enum Feature implements JavaScriptEnum<String> {
  /**
   * Allow user to choose more than one item.
   */
  MULTISELECT_ENABLED("MULTISELECT_ENABLED"),

  /**
   * Hide the navigation pane. If the navigation pane is hidden, users can only select from the first view chosen.
   */
  NAV_HIDDEN("NAV_HIDDEN"),

  /**
   * For photo uploads, controls whether per-photo selection (as opposed to per-album) selection is enabled.
   */
  SIMPLE_UPLOAD_ENABLED("SIMPLE_UPLOAD_ENABLED");

  private final String value;

  private Feature(String value) {
    this.value = value;
  }

  public String getValue() {
    return JavaScriptUtils.enumValue("Feature", value);
  }
}
