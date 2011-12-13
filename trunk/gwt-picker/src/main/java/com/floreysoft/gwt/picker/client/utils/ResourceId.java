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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * ResourceId is a static class used to generate resource IDs suitable for the Google Documents List API.
 */
public class ResourceId {

  /**
   * ToDo: Whats the type of the expected document?
   * Map a document object to a resource ID.
   *
   * @param document The document to generate an id for
   * @return The generated resource id
   */
  public native static String generate(JavaScriptObject document) /*-{
    return $wnd.google.picker.ResourceId.generate(document);
  }-*/;
}
