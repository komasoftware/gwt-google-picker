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

package com.floreysoft.gwt.picker.client.domain.result;

import com.floreysoft.gwt.picker.client.domain.ViewId;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains information about the picker and the user query.
 */
public final class ViewToken extends JavaScriptObject {
  protected ViewToken() {}

  /**
   * Returns the picked view id. If null, try to handle the result of
   * @see #getNativeViewId().
   *
   * @return The view id of the picker
   */
  public ViewId getViewId() {
    return ViewId.findByValue(getNativeViewId());
  }
  public native String getNativeViewId() /*-{
    return this.viewId;
  }-*/;

  /**
   * @return A map with view options
   */
  public Map<String, String> getViewOptions() {
    final Map<String, String> result = new HashMap<String, String>();
    if (getNativeViewOptions() != null) {
      copyViewOptions(result);
    }

    return result;
  }

  public native static ViewToken create(JsArray array) /*-{
    return array && array.length >= 3 ? new Object({
      viewId: array[0],
      viewOptions: array[2]
    }) : {};
  }-*/;

  private native JavaScriptObject getNativeViewOptions() /*-{
    return this.viewOptions;
  }-*/;

  private native void copyViewOptions(Map target) /*-{
    for (var key in this.viewOptions) {
      target.@java.util.Map::put(Ljava/lang/Object;Ljava/lang/Object;)(key, this.viewOptions[key]);
    }
  }-*/;
}
