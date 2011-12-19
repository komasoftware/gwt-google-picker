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

import com.floreysoft.gwt.picker.client.domain.Action;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Provides some basic methods to access common fields of the picker result.
 */
public final class BaseResult extends JavaScriptObject {
  protected BaseResult() {}

  /**
   * @return Information about the view.
   */
  public ViewToken getViewToken() {
    return ViewToken.create(getProperty("viewToken").<JsArray>cast());
  }

  /**
   * @return The user action
   */
  public Action getAction() {
    String action = getNativeAction();
    return Action.findByValue(action);
  }
  private native String getNativeAction() /*-{
    return this.action;
  }-*/;

  /**
   * Access each other property that is a complex javascript object
   *
   * @param property The property
   * @return The JavaScriptObject
   */
  public native JavaScriptObject getProperty(String property) /*-{
    return this[property];
  }-*/;
}
