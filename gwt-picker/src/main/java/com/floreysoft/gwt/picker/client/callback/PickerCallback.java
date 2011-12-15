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

import com.floreysoft.gwt.picker.client.domain.result.ViewToken;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Use this callback to get the picked documents or get informed when the user cancels the picking process.
 * This class is not intended to be used directly. Instead use one of the derived classes or implement
 * an own callback with a concrete result class.
 *
 * The structure of the callback object is described in the
 * <a href="http://code.google.com/intl/de-DE/apis/picker/docs/results.html">JSON Guide</a>.
 */
public abstract class PickerCallback<RESULT extends JavaScriptObject> {

  /**
   * Will be called, if the user picked an object
   *
   * @param viewToken The view token
   * @param result The picker result
   */
  public abstract void onPicked(ViewToken viewToken, RESULT result);

  /**
   * Will be called, it the user skips the picking process.
   */
  public abstract void onCanceled();
}
