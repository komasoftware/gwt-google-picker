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
 * ViewId: IMAGE_SEARCH
 */
public final class ImageSearchResult extends JavaScriptObject {
  protected ImageSearchResult() {
  }

  /**
   * @return The documents
   */
  public native JsArray<Document> getDocs() /*-{
    return this.docs;
  }-*/;

  /**
   * @return Concatenation of the string 'image-search/' and the URL-escaped version of the query term.
   */
  public native String getView() /*-{
    return this.view;
  }-*/;

  public static final class Document extends JavaScriptObject {
    protected Document() {
    }

    /**
     * @return Unique ID of the image.
     */
    public native String getId() /*-{
      return this.id;
    }-*/;

    /**
     * @return "search-api"
     */
    public native String getServiceId() /*-{
      return this.serviceId;
    }-*/;

    /**
     * @return Filename of the image.
     */
    public native String getName() /*-{
      return this.name;
    }-*/;

    /**
     * @return "photo"
     */
    public native String getType() /*-{
      return this.type;
    }-*/;

    /**
     * @return Image MIME type.
     */
    public native String getMimeType() /*-{
      return this.mimeType;
    }-*/;

    /**
     * @return Description of the image, if available.
     */
    public native String getDescription() /*-{
      return this.description;
    }-*/;

    /**
     * @return URL of the page containing the image.
     */
    public native String getUrl() /*-{
      return this.url;
    }-*/;

    /**
     * @return The thumbnails
     */
    public native JsArray<Thumbnail> getThumbnails() /*-{
      return this.thumbnails;
    }-*/;

    public Thumbnail geSmallThumbnail() {
      final JsArray<Thumbnail> thumbnails = getThumbnails();
      return thumbnails != null && thumbnails.length() > 0 ? thumbnails.get(0) : null;
    }

    public Thumbnail geLargeThumbnail() {
      final JsArray<Thumbnail> thumbnails = getThumbnails();
      return thumbnails != null && thumbnails.length() > 1 ? thumbnails.get(1) : null;
    }
  }
}
