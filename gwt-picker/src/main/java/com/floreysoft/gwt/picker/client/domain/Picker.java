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

import com.floreysoft.gwt.picker.client.callback.PickerCallback;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Picker is the top level object representing the UI action with the user.
 * These objects are not created directly, but instead use the PickerBuilder object.
 */
public final class Picker extends JavaScriptObject {
  protected Picker() {}

  /**
   * @return Get a boolean indicating the current Picker visibility.
   */
  public native boolean isVisible() /*-{
    return this.isVisible();
  }-*/;

  /**
   * Specify the callback method called whenever the user has picked an item (or canceled.)
   *
   * @param callback The callback to execute
   * @deprecated Use {@link PickerBuilder#addCallback(com.floreysoft.gwt.picker.client.callback.AbstractPickerCallback)} instead
   */
  public native void setCallback(PickerCallback callback) /*-{
    return this.setCallback(function(object) {
      @com.floreysoft.gwt.picker.client.callback.PickerCallbackDispatcher::dispatch(Lcom/floreysoft/gwt/picker/client/callback/PickerCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, object);
    });
  }-*/;

  /**
   * Specify a relay URL to circumvent cross-domain issues.
   *
   * @param url The relay url
   */
  public native void setRelayUrl(String url) /*-{
    this.setRelayUrl(url);
  }-*/;

  /**
   * Control the visibility of the Picker object.
   *
   * @param visible True, if visible. Otherwise false
   */
  public native void setVisible(boolean visible) /*-{
    this.setVisible(visible);
  }-*/;
}
