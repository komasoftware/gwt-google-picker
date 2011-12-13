/*
 * Copyright 2011 floreysoft GmbH
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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Some JavaScript utility methods
 */
public class JavaScriptUtils {
  /**
   * Change this namespace to the javascript library namaspace. e.g google.maps.
   * Deafult is "google.picker"
   */
  public static String NAMESPACE = "google.picker";

  /**
   * Returns the enum value for the given path within the.
   * @see JavaScriptUtils#NAMESPACE
   *
   * To access the value of an enum e.g. google.picker.Action.CANCEL the method
   * call would be: JavaScriptUtils.enumValue("Action", "CANCEL");
   *
   * @param path The path to the enum
   * @return The enum value
   */
  public static String enumValue(String... path) {
    return nativeEnumValue(NAMESPACE, convert(path));
  }

  /**
   * Converts a string array to a javascript array
   *
   * @param javaArray The array to convert
   * @return The converted javascript string array
   */
  public static JsArrayString convert(String[] javaArray) {
    JsArrayString result = JavaScriptObject.createArray().cast();
    for (int i = 0; i < javaArray.length; i++) {
      result.set(i, javaArray[i]);
    }
    return result;
  }

  private native static String nativeEnumValue(String namespace, JsArrayString path) /*-{
    var root = $wnd;
    path = [].concat(namespace.split("."), path);

    for (var j = 0; j < path.length; j++) {
      root = root ? root[path[j]] : $wnd[path[j]];
    }

    if (root == undefined || root == null) {
      throw "Undefined enum value for path: " + path;
    }
    return root;
  }-*/;
}
