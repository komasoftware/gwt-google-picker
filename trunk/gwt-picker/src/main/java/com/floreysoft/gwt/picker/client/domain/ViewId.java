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
 * ViewId is an enumerated type, used for constructing View and ViewGroup objects.
 * Visit <a href="http://code.google.com/intl/de-DE/apis/picker/docs/reference.html">the reference</a>
 */
public enum ViewId implements JavaScriptEnum<String> {
  /**
   * All Google Docs document types.
   */
  DOCS("DOCS"),

  /**
   * All Google Docs image types.
   */
  DOCS_IMAGES("DOCS_IMAGES"),

  /**
   * Google Docs Document.
   */
  DOCUMENTS("DOCUMENTS"),
  /**
   * Google Docs Documents by collections.
   */
  FOLDERS("FOLDERS"),
  /**
   * Google Docs Forms.
   */
  FORMS("FORMS"),
  /**
   * Google Image Search.
   */
  IMAGE_SEARCH("IMAGE_SEARCH"),

  /**
   * PDF files stored in Google Docs.
   */
  PDFS("PDFS"),
  /**
   * Upload to Picasa Web Albums.
   */
  PHOTO_UPLOAD("PHOTO_UPLOAD"),
  /**
   * Picasa Web Albums.
   */
  PHOTOS("PHOTOS"),

  /**
   * Google Docs Presentations.
   */
  PRESENTATIONS("PRESENTATIONS"),

  /**
   * A collection of most recently selected items.
   */
  RECENTLY_PICKED("RECENTLY_PICKED"),

  /**
   * Google Docs Spreadsheet.
   */
  SPREADSHEETS("SPREADSHEETS"),

  /**
   * Google Video Search.
   */
  VIDEO_SEARCH("VIDEO_SEARCH"),

  /**
   * Your YouTube videos.
   */
  YOUTUBE("YOUTUBE"),

  /**
   * Your webcam
   */
  WEBCAM("WEBCAM"),
  
  /**
   * The maps view
   */
  MAPS("MAPS");

  private final String value;

  private ViewId(String value) {
    this.value = value;
  }

  public String getValue() {
    return JavaScriptUtils.enumValue("ViewId", value);
  }

  /**
   * Finds the view id by value
   *
   * @param value The value
   * @return The view id
   */
  public static ViewId findByValue(String value) {
    for (ViewId viewId : ViewId.values()) {
      if (viewId.getValue().equals(value)) {
        return viewId;
      }
    }

    return null;
  }
}
