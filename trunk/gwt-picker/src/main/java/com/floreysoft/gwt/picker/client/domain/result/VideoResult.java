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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * ViewId: VIDEO_SEARCH, YOUTUBE
 */
public final class VideoResult extends JavaScriptObject {
  protected VideoResult() {}

  /**
   * @return The documents
   */
  public native JsArray<Document> getDocs() /*-{
    return this.docs;
  }-*/;

  /**
   * @return For ViewId.VIDEO_SEARCH, a concatenation of the string 'video-search/'
   * and the URL-escaped version of the query term. Alternatively, ViewId.YOUTUBE.
   */
  public native String getView() /*-{
    return this.view;
  }-*/;

  public static final class Document extends JavaScriptObject {
    protected Document() {
    }

    /**
     * @return View from which the selection was made; either ViewId.VIDEO_SEARCH or ViewId.YOUTUBE.
     */
    public native String getId() /*-{
      return this.id;
    }-*/;

    /**
     * @return Either search-api or youtube, for ViewId.VIDEO_SEARCH and ViewId.YOUTUBE, respectively.
     */
    public native String getServiceId() /*-{
      return this.serviceId;
    }-*/;

    /**
     * @return Video MIME type, typically application/vnd.google-apps.video.
     */
    public native String getMimeType() /*-{
      return this.mimeType;
    }-*/;

    /**
     * @return Title associated with the selected video.
     */
    public native String getName() /*-{
      return this.name;
    }-*/;

    /**
     * @return "video"
     */
    public native String getType() /*-{
      return this.type;
    }-*/;

    /**
     * @return The number of milliseconds since January 1, 1970, 00:00:00 GMT.
     */
    public Long getLastEditedUtc() {
      return getNativeLastEditedUtc() != null ? Long.parseLong(getNativeLastEditedUtc()) : null;
    }

    /**
     * The YouTube time comes as a string.
     *
     * @return The time in millis
     */
    private native String getNativeLastEditedUtc() /*-{
      var millis = typeof(this.lastEditedUtc) != 'number' ? Date.parse(this.lastEditedUtc) : this.lastEditedUtc;
      return millis ? millis.toFixed() : null;
    }-*/;

    /**
     * @return A URL for a publicly accessible version for an icon, if available.
     */
    public native String getIconUrl() /*-{
      return this.iconUrl;
    }-*/;

    /**
     * @return Description of the video, if provided.
     */
    public native String getDescription() /*-{
      return this.description;
    }-*/;

    /**
     * @return URL of the page containing the video.
     */
    public native String getUrl() /*-{
      return this.url;
    }-*/;

    /**
     * @return URL of an embeddable version of the video, if available.
     */
    public native String getEmbedUrl() /*-{
      return this.embedUrl;
    }-*/;

    /**
     * @return The thumbnails
     */
    public native JsArray<Thumbnail> getThumbnails() /*-{
      return this.thumbnails;
    }-*/;

    /**
     * @return Length of the video, in seconds.
     */
    public native String getDuration() /*-{
      return this.duration;
    }-*/;
  }
}
