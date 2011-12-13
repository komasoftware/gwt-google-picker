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

import com.floreysoft.gwt.picker.client.domain.ViewId;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * ViewId: PHOTOS, PHOTO_UPLOAD
 */
public final class PhotoResult extends JavaScriptObject {
  protected PhotoResult() {
  }

  /**
   * @return The documents
   */
  public native JsArray<Document> getDocs() /*-{
    return this.docs;
  }-*/;

  /**
   * @return The parent documents
   */
  public native JsArray<ParentDocument> getParents() /*-{
    return this.parents;
  }-*/;

  /**
   * @return One of the following values, in the google.picker.ViewId namespace: PHOTOS, PHOTO_UPLOAD.
   */
  public ViewId getView() {
    return ViewId.findByValue(getNativeView());
  }
  public native String getNativeView() /*-{
    return this.view;
  }-*/;

  public static final class Document extends JavaScriptObject {

    protected Document() {
    }

    /**
     * @return ID of the Picasa Web image.
     */
    public native String getId() /*-{
      return this.id;
    }-*/;

    /**
     * @return "picasa"
     */
    public native String getServiceId() /*-{
      return this.serviceId;
    }-*/;

    /**
     * @return Picasa Web Album photo: application/vnd.google-apps.photo
     */
    public native String getMimeType() /*-{
      return this.mimeType;
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
     * @return The number of milliseconds since January 1, 1970, 00:00:00 GMT.
     */
    public Long getLastEditedUtc() {
      return getNativeLastEditedUtc() != null ? Long.parseLong(getNativeLastEditedUtc()) : null;
    }
    private native String getNativeLastEditedUtc() /*-{
      return this.lastEditedUtc ? this.lastEditedUtc.toFixed() : null;
    }-*/;

    /**
     * @return A URL for a publicly accessible version for an icon, if available.
     */
    public native String getIconUrl() /*-{
      return this.iconUrl;
    }-*/;

    /**
     * @return An optional description
     */
    public native String getDescription() /*-{
      return this.description;
    }-*/;

    /**
     * @return Picasa Web page containing the image or the album.
     */
    public native String getUrl() /*-{
      return this.url;
    }-*/;

    /**
     * @return The image thumbnails
     */
    public native JsArray<Thumbnail> getThumbnails() /*-{
      return this.thumbnails;
    }-*/;

    /**
     * @return ID of the Picasa Web Album containing the image.
     */
    public native String getParentId() /*-{
      return this.parentId;
    }-*/;

    /**
     * @return Latitude of the location, in degrees, if the value is public.
     */
    public native Double getLatitude() /*-{
      return this.latitude ? @java.lang.Double::valueOf(D)(this.latitude) : null;
    }-*/;

    /**
     * @return Longitude of the location, in degrees, if the value is public.
     */
    public native Double getLongitude() /*-{
      return this.longitude ? @java.lang.Double::valueOf(D)(this.longitude) : null;
    }-*/;
  }

  public static final class ParentDocument extends JavaScriptObject {
    protected ParentDocument() {
    }

    /**
     * @return ID of the Picasa Web Album.
     */
    public native String getId() /*-{
      return this.id;
    }-*/;

    /**
     * @return "picasa"
     */
    public native String getServiceId() /*-{
      return this.serviceId;
    }-*/;

    /**
     * @return Picasa Web Album photo album: application/vnd.google-apps.photoalbum
     */
    public native String getMimeType() /*-{
      return this.mimeType;
    }-*/;

    /**
     * @return Filename of the image.
     */
    public native String getName() /*-{
      return this.name;
    }-*/;

    /**
     * @return "album"
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
    private native String getNativeLastEditedUtc() /*-{
      return this.lastEditedUtc ? this.lastEditedUtc.toFixed() : null;
    }-*/;

    /**
     * @return A URL for a publicly accessible version for an icon, if available.
     */
    public native String getIconUrl() /*-{
      return this.iconUrl;
    }-*/;

    /**
     * @return An optional description
     */
    public native String getDescription() /*-{
      return this.description;
    }-*/;

    /**
     * @return Picasa Web page containing the image or the album.
     */
    public native String getUrl() /*-{
      return this.url;
    }-*/;

    /**
     * @return The image thumbnails
     */
    public native JsArray<Thumbnail> getThumbnails() /*-{
      return this.thumbnails;
    }-*/;
  }
}
