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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * PhotosView is a subclass of View. Finer aspects of photos selection can be controlled using this class.
 */
public final class PhotosView extends JavaScriptObject {
  protected PhotosView() {}

  public ViewId getId() {
    return ViewId.findByValue(getNativeId());
  }
  private native String getNativeId() /*-{
    return this.getId();
  }-*/;

  public native void setQuery(String string) /*-{
    this.setQuery(string);
  }-*/;

  /**
   * Filter photos shown in the view by PhotosView.Type.
   *
   * @param type The photo type
   */
  public native void setType(Type type) /*-{
    this.setType(type.@com.floreysoft.gwt.picker.client.domain.PhotosView.Type::getValue()());
  }-*/;

  /**
   * @return A new instance of PhotosView
   */
  public native static PhotosView create() /*-{
    return new $wnd.google.picker.PhotosView();
  }-*/;

  public enum Type implements JavaScriptEnum<String> {
    /**
     * Select photos from Picasa's "Featured Photos" gallery rather the the user's own photos.
     */
    FEATURED("FEATURED"),

    /**
     * Select from the user's most recently uploaded Picasa photos,
     * from any album, with the most recently uploaded photos shown first.
     */
    UPLOADED("UPLOADED"),;

    private final String value;

    private Type(String value) {
      this.value = value;
    }

    public String getValue() {
      return JavaScriptUtils.enumValue("PhotosView", "Type", value);
    }
  }
}
