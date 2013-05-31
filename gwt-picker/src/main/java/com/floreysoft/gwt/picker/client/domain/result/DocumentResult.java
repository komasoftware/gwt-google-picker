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
 * ViewId: DOCS, DOCUMENTS, SPREADSHEETS, FORMS, PRESENTATIONS, FOLDERS, PDFS
 */
public final class DocumentResult extends JavaScriptObject {
  protected DocumentResult() {
  }

  /**
   * @return The documents
   */
  public native JsArray<Document> getDocs() /*-{
    return this.docs;
  }-*/;

  public static final class Document extends JavaScriptObject {
    protected Document() {}

    /**
     * @return Name of the item, as you would reference it while using the Google Documents List API.
     */
    public native String getId() /*-{
      return this.id;
    }-*/;

    /**
     * @return "docs"
     */
    public native String getServiceId() /*-{
      return this.serviceId;
    }-*/;

    /**
     * @return Title of the item.
     */
    public native String getName() /*-{
      return this.name;
    }-*/;

    /**
     * @return "document"
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
     * @return A description of the item, if provided.
     */
    public native String getDescription() /*-{
      return this.description;
    }-*/;

    /**
     * @return The mimeType of the item, if provided.
     */
    public native String getMimeType() /*-{
      return this.mimeType;
    }-*/;

    /**
     * @return A URL for an embeddable version of the item.
     */
    public native String getUrl() /*-{
      return this.url;
    }-*/;

    /**
     * @return A URL for an embeddable version of the item.
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
     * @return A visibility enumeration, if known.
     *         One of the following literal values: public, private, or unlisted.
     */
    public Visibility getVisibility() {
      return Visibility.findByValue(getNativeVisibility());
    }
    private native String getNativeVisibility() /*-{
      return this.visibility;
    }-*/;

    /**
     * @return A time-limited access AuthSub token for fetching the item via the Google Documents List API.
     *         Note that the Google Documents List API requires a resource ID, derived in part from an access token,
     *         to identify items. Generate a resource ID by calling the static method google.​picker.​ResourceId.​generate()
     *         with an item of the docs array.
     */
    public native String getAccessToken() /*-{
      return this.accessToken;
    }-*/;

    /**
     * @return ID of parent folder, if available.
     */
    public native String getParentId() /*-{
      return this.parentId;
    }-*/;
  }

  public static enum Visibility {
    PUBLIC("public"),
    PRIVATE("private"),
    UNLISTED("unlisted");

    private final String value;

    private Visibility(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public static Visibility findByValue(String value) {
      for (Visibility visibility : values()) {
        if (visibility.getValue().equals(value)) {
          return visibility;
        }
      }
      return null;
    }
  }
}
