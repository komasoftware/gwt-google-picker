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
import com.google.gwt.core.client.JsArrayString;

/**
 * ViewId: MAPS
 */
public final class MapResult extends JavaScriptObject {
  protected MapResult() {
  }

  /**
   * @return The documents
   */
  public native JsArray<Document> getDocs() /*-{
    return this.docs;
  }-*/;

  /**
   * @return "maps"
   */
  public native String getView() /*-{
    return this.view;
  }-*/;

  public static final class Document extends JavaScriptObject {
    protected Document() {
    }

    /**
     * @return URL of map, at maps.google.com.
     */
    public native String getUrl() /*-{
      return this.url;
    }-*/;

    /**
     * @return URL of embeddable map, at maps.google.com.
     */
    public native String getEmbedUrl() /*-{
      return this.embedUrl;
    }-*/;

    /**
     * @return Name of the location. This can be return by the search engine, or modified by the user.
     */
    public native String getName() /*-{
      return this.name;
    }-*/;

    /**
     * @return Address of the location. The addressLines field is optional.
     */
    public native JsArrayString getAddressLines() /*-{
      return this.addressLines;
    }-*/;

    /**
     * @return The phone numbers
     */
    public native JsArray<PhoneNumber> getPhoneNumbers() /*-{
      return this.phoneNumbers;
    }-*/;

    /**
     * @return Latitude of the location, in degrees.
     */
    public native Double getLatitude() /*-{
      return this.latitude ? @java.lang.Double::valueOf(D)(this.latitude) : null;
    }-*/;

    /**
     * @return Longitude of the location, in degrees.
     */
    public native Double getLongitude() /*-{
      return this.longitude ? new @java.lang.Double::valueOf(D)(this.longitude) : null;
    }-*/;

    /**
     * @return The thumbnails
     */
    public native JsArray<Thumbnail> getThumbnails() /*-{
      return this.thumbnails;
    }-*/;
  }

  public static final class PhoneNumber extends JavaScriptObject {
    protected PhoneNumber() {
    }

    /**
     * @return Type of phone. This can be one of the following, or blank: Voice, Fax, TDD, Data, Mobile.
     */
    public native String getType() /*-{
      return this.type;
    }-*/;

    /**
     * @return Phone number. The phoneNumbers field is optional.
     */
    public native String getNumber() /*-{
      return this.number;
    }-*/;
  }
}
