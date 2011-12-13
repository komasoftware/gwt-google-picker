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
 * Action is an enumerated type representing the action taken by the user to
 * dismiss the dialog. This value will be in the 'action' field in the callback data.
 */
public enum Action implements JavaScriptEnum<String> {

  /**
   * User cancelled the picker dialog.
   */
  CANCEL("CANCEL"),

  /**
   * User has chosen an at least one item.
   */
  PICKED("PICKED");

  private final String value;

  private Action(String value) {
    this.value = value;
  }

  public String getValue() {
    return JavaScriptUtils.enumValue("Action", value);
  }

  /**
   * Finds the action by value
   *
   * @param value The value
   * @return The action
   */
  public static Action findByValue(String value) {
    for (Action action : Action.values()) {
      if (action.getValue().equals(value)) {
        return action;
      }
    }

    return null;
  }
}
