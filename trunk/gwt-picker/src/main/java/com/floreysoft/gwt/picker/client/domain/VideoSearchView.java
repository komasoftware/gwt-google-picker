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
 * VideoSearchView is a subclass of View. Use this class to select URLs of videos.
 */
public final class VideoSearchView extends JavaScriptObject {
  /**
   * A string constant suitable for the VideoSearchView.setSite() method.
   */
  public static String YOUTUBE = JavaScriptUtils.enumValue("VideoSearchView", "YOUTUBE");
  
  protected VideoSearchView() {}

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
   * Constrain the video search results to a particular domain.
   *
   * @param site The site to set
   */
  public native void setSite(String site) /*-{
    this.setSite(site);
  }-*/;

  /**
   * @return A new instance of PhotosView
   */
  public native static VideoSearchView create() /*-{
    return new $wnd.google.picker.VideoSearchView();
  }-*/;
}
