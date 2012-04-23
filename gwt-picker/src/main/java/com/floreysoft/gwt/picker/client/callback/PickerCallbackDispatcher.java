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

package com.floreysoft.gwt.picker.client.callback;

import com.floreysoft.gwt.picker.client.domain.Action;
import com.floreysoft.gwt.picker.client.domain.result.BaseResult;
import com.floreysoft.gwt.picker.client.domain.result.ViewToken;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

/**
 * Dispatches the callback to the receiver.
 */
public class PickerCallbackDispatcher {

  /**
   * Depends on the picked result executes the
   * {@link PickerCallback#onPicked(com.floreysoft.gwt.picker.client.domain.result.ViewToken, com.google.gwt.core.client.JavaScriptObject)}
   * or {@link PickerCallback#onCanceled()} methods.
   * 
   * @param callback
   *          The callback
   * @param result
   *          The picker result
   * @param <T>
   *          The type of the callback result
   * @deprecated
   */
  public static <T extends JavaScriptObject> void dispatch(
      PickerCallback<T> callback, T result) {
    final BaseResult baseResult = result.cast();
    final ViewToken viewToken = baseResult.getViewToken();
    if (Action.PICKED.equals(baseResult.getAction())) {
      callback.onPicked(viewToken, result);
    } else if (Action.CANCEL.equals(baseResult.getAction())) {
      callback.onCanceled();
    }
  }

  /**
   * Dispatches the picked result to the given callback.
   * 
   * @param callback
   *          The callback
   * @param result
   *          The result to dispatch
   */
  public static void dispatch(AbstractPickerCallback callback, BaseResult result) {
    final BaseResult baseResult = result.cast();
    final ViewToken viewToken = baseResult.getViewToken();
    if (Action.PICKED.equals(baseResult.getAction())) {
      if (callback.isApplicable(viewToken)) {
        callback.onPicked(viewToken, result);
      }
    } else if (Action.CANCEL.equals(baseResult.getAction())) {
      callback.onCanceled();
    }
  }
}
