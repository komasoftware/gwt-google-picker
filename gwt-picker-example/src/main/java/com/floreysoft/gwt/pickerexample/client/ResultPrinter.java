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

package com.floreysoft.gwt.pickerexample.client;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.picker.client.domain.result.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

public class ResultPrinter {

  public static void print(ViewToken token, DocumentResult result) {
    print(token);
    for (int i = 0; i < result.getDocs().length(); i++) {
      final DocumentResult.Document document = result.getDocs().get(i);
      writeToOutput("getAccessToken = " + document.getAccessToken());
      writeToOutput("getDescription = " + document.getDescription());
      writeToOutput("getEmbedUrl = " + document.getEmbedUrl());
      writeToOutput("getIconUrl = " + document.getIconUrl());
      writeToOutput("getId = " + document.getId());
      writeToOutput("getLastEditedUtc = " + document.getLastEditedUtc());
      writeToOutput("getName = " + document.getName());
      writeToOutput("getParentId = " + document.getParentId());
      writeToOutput("getServiceId = " + document.getServiceId());
      writeToOutput("getType = " + document.getType());
      writeToOutput("getUrl = " + document.getUrl());
      writeToOutput("getVisibility = " + document.getVisibility());
      print(document.getThumbnails());
    }
  }

  public static void print(ViewToken token, ImageSearchResult result) {
    print(token);
    for (int i = 0; i < result.getDocs().length(); i++) {
      final ImageSearchResult.Document document = result.getDocs().get(i);
      writeToOutput("getId = " + document.getId());
      writeToOutput("getDescription = " + document.getDescription());
      writeToOutput("getMimeType = " + document.getMimeType());
      writeToOutput("getName = " + document.getName());
      writeToOutput("getServiceId = " + document.getServiceId());
      writeToOutput("getType = " + document.getType());
      writeToOutput("getUrl = " + document.getUrl());
      print(document.getThumbnails());
    }
  }

  public static void print(ViewToken viewToken, MapResult result) {
    print(viewToken);
    for (int i = 0; i < result.getDocs().length(); i++) {
      final MapResult.Document document = result.getDocs().get(i);
      writeToOutput("getEmbedUrl = " + document.getEmbedUrl());
      writeToOutput("getName = " + document.getName());
      writeToOutput("getUrl = " + document.getUrl());
      writeToOutput("getLatitude = " + document.getLatitude());
      writeToOutput("getLongitude = " + document.getLongitude());

      for (int j = 0; j < document.getAddressLines().length(); j++) {
        final String addressLine = document.getAddressLines().get(j);
        writeToOutput("Addressline. " + j + " = " + addressLine);
      }
      for (int j = 0; j < document.getPhoneNumbers().length(); j++) {
        final MapResult.PhoneNumber phoneNumber = document.getPhoneNumbers().get(j);
        writeToOutput("PhoneNumber. " + j + ".number = " + phoneNumber.getNumber());
        writeToOutput("PhoneNumber. " + j + ".type = " + phoneNumber.getType());
      }
      print(document.getThumbnails());
    }
  }

  public static void print(ViewToken viewToken, PhotoResult result) {
    print(viewToken);
    for (int i = 0; i < result.getDocs().length(); i++) {
      final PhotoResult.Document document = result.getDocs().get(i);
      writeToOutput("this.getId = " + document.getId());
      writeToOutput("this.getDescription = " + document.getDescription());
      writeToOutput("this.getMimeType = " + document.getMimeType());
      writeToOutput("this.getName = " + document.getName());
      writeToOutput("this.getServiceId = " + document.getServiceId());
      writeToOutput("this.getType = " + document.getType());
      writeToOutput("this.getUrl = " + document.getUrl());
      writeToOutput("this.getIconUrl = " + document.getIconUrl());
      writeToOutput("this.getLastEditedUtc = " + document.getLastEditedUtc());
      writeToOutput("this.getLatitude = " + document.getLatitude());
      writeToOutput("this.getLongitude = " + document.getLongitude());
      writeToOutput("this.getParentId = " + document.getParentId());
      print(document.getThumbnails());
    }
    for (int i = 0; i < result.getParents().length(); i++) {
      final PhotoResult.ParentDocument document = result.getParents().get(i);
      writeToOutput("this.getId = " + document.getId());
      writeToOutput("this.getDescription = " + document.getDescription());
      writeToOutput("this.getMimeType = " + document.getMimeType());
      writeToOutput("this.getName = " + document.getName());
      writeToOutput("this.getServiceId = " + document.getServiceId());
      writeToOutput("this.getType = " + document.getType());
      writeToOutput("this.getUrl = " + document.getUrl());
      writeToOutput("this.getIconUrl = " + document.getIconUrl());
      writeToOutput("this.getLastEditedUtc = " + document.getLastEditedUtc());
      print(document.getThumbnails());
    }
  }

  public static void print(ViewToken viewToken, VideoResult result) {
    print(viewToken);
    for (int i = 0; i < result.getDocs().length(); i++) {
      final VideoResult.Document document = result.getDocs().get(i);
      writeToOutput("getId = " + document.getId());
      writeToOutput("getDescription = " + document.getDescription());
      writeToOutput("getMimeType = " + document.getMimeType());
      writeToOutput("getName = " + document.getName());
      writeToOutput("getServiceId = " + document.getServiceId());
      writeToOutput("getType = " + document.getType());
      writeToOutput("getUrl = " + document.getUrl());
      writeToOutput("getDuration = " + document.getDuration());
      writeToOutput("getEmbedUrl = " + document.getEmbedUrl());
      writeToOutput("getIconUrl = " + document.getIconUrl());
      writeToOutput("getLastEditedUtc = " + document.getLastEditedUtc());
      print(document.getThumbnails());
    }
  }

  private static void print(ViewToken token) {
    clearOutput();
    writeToOutput("getViewId =  " + token.getViewId());
    for (String key : token.getViewOptions().keySet()) {
      writeToOutput("ViewOptions." + key + " = " + token.getViewOptions().get(key));
    }
  }

  private static void print(JsArray<Thumbnail> thumbs) {
    for (int j = 0; j < thumbs.length(); j++) {
      final Thumbnail thumb = thumbs.get(j);
      writeToOutput("Thumbnail." + j + ".getUrl = " + thumb.getUrl());
      writeToOutput("Thumbnail." + j + ".getWidth = " + thumb.getWidth());
      writeToOutput("Thumbnail." + j + ".getHeight = " + thumb.getHeight());
    }
  }

  private static void writeToOutput(String s) {
    final Element output = DOM.getElementById("output");
    output.setInnerHTML(output.getInnerHTML() + "<div>" + s + "</div>");
  }

  private static void clearOutput() {
    DOM.getElementById("output").setInnerHTML("");
  }
}
