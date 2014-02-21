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

import com.floreysoft.gwt.picker.client.callback.AbstractPickerCallback;
import com.floreysoft.gwt.picker.client.callback.PickerCallback;
import com.floreysoft.gwt.picker.client.domain.result.BaseResult;
import com.floreysoft.gwt.picker.client.domain.result.ViewToken;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * PickerBuilder is used to create Picker objects. Except where noted otherwise,
 * the return type of methods below are of type PickerBuilder, allowing you to
 * chain one call after another. See the <a href=
 * "http://code.google.com/intl/de-DE/apis/picker/docs/index.html#hiworld">Hello
 * World</a> example for typical use.
 */
public final class PickerBuilder extends JavaScriptObject {
  protected PickerBuilder() {
  }

  /**
   * Add a view to the navigation pane.
   * 
   * @param view
   *          The view add
   * @return The picker builder instance
   */
  public native PickerBuilder addView(JavaScriptObject view) /*-{
		return this.addView(view);
  }-*/;

  /**
   * Add a view to the navigation pane.
   * 
   * @param viewId
   *          The view id to add
   * @return The picker builder instance
   */
  public native PickerBuilder addView(ViewId viewId) /*-{
		return this
				.addView(viewId.@com.floreysoft.gwt.picker.client.domain.ViewId::getValue()());
  }-*/;

  /**
   * Disable a picker feature.
   * 
   * @param feature
   *          The feature to disable
   * @return The builder instance
   */
  public native PickerBuilder disableFeature(Feature feature) /*-{
		return this
				.disableFeature(feature.@com.floreysoft.gwt.picker.client.domain.Feature::getValue()());
  }-*/;

  /**
   * Enable a picker feature.
   * 
   * @param feature
   *          The feature to enable
   * @return The builder instance
   */
  public native PickerBuilder enableFeature(Feature feature) /*-{
		return this
				.enableFeature(feature.@com.floreysoft.gwt.picker.client.domain.Feature::getValue()());
  }-*/;

  /**
   * Check if a picker feature is enabled.
   * 
   * @param feature
   *          The feature to check
   * @return True if enabled. Otherwise false
   */
  public native boolean isFeatureEnabled(Feature feature) /*-{
		return this
				.isFeatureEnabled(feature.@com.floreysoft.gwt.picker.client.domain.Feature::getValue()());
  }-*/;

  /**
   * Add a ViewGroup to the top-level navigation pane.
   * 
   * @param viewGroup
   *          The view group to add
   * @return The picker builder instance
   */
  public native PickerBuilder addViewGroup(ViewGroup viewGroup) /*-{
		return this.addViewGroup(viewGroup);
  }-*/;

  /**
   * Construct the Picker object.
   * 
   * @return The Picker object is returned.
   */
  public native Picker build() /*-{
		// Create picker
		return this.build();

  }-*/;

  /**
   * @return the relay URL, used for gadgets.rpc.
   */
  public native String getRelayUrl() /*-{
		return this.getRelayUrl();
  }-*/;

  /**
   * Set the relay URL, used for gadgets.rpc.
   * 
   * @param url
   *          The relay url
   * @return The picker builder
   */
  public native PickerBuilder setRelayUrl(String url) /*-{
		return this.setRelayUrl(url);
  }-*/;

  public native PickerBuilder setOAuthToken(String oauthToken) /*-{
  	return this.setOAuthToken(oauthToken);
  }-*/;

  public native String getOAuthToken() /*-{
  	return this.getOAuthToken();
  }-*/;
  
  /**
   * Set the preferred dialog size. The dialog will be auto-centered. It has a
   * minimum size of (566,350) and a maximum size of (1051,650).
   * 
   * @return The picker builder instance
   */
  public native PickerBuilder setSize() /*-{
		return this.setSize();
  }-*/;

  /**
   * Specify an album ID for photo uploads. <a href=
   * "http://code.google.com/apis/picasaweb/docs/2.0/developers_guide_protocol.html#Albums"
   * >See Picasa Web Albums Data API documentation</a> for more information
   * about albums.
   * 
   * @param albumId
   *          The album ID
   * @return The picker builder instance
   */
  public native PickerBuilder setUploadToAlbumId(String albumId) /*-{
		return this.setUploadToAlbumId(albumId);
  }-*/;

  /**
   * @return The dialog title.
   */
  public native String getTitle() /*-{
		return this.getTitle();
  }-*/;

  /**
   * Set the dialog title.
   * 
   * @param title
   *          The title
   * @return The picker builder instance
   */
  public native PickerBuilder setTitle(String title) /*-{
		return this.setTitle(title);
  }-*/;

  /**
   * Disable the title bar from being shown. To re-enable, call setTitle with a
   * non-empty title or undefined.
   * 
   * @return The picker builder instance
   */
  public native PickerBuilder hideTitleBar() /*-{
		return this.hideTitleBar();
  }-*/;

  /**
   * For services where individual items are protected by access control (i.e.
   * Google Docs), time-limited access to items constrained by the argument is
   * granted. By default, access from any domain is granted. Once the user has
   * selected an item, applications in the granted domain can access the items
   * using the Google Documents List API. The token is valid for 24 hours.
   * 
   * @param domain
   *          The domain
   * @return The picker builder instance
   */
  public native PickerBuilder grantDocsTokenToDomain(String domain) /*-{
		return this.grantDocsTokenToDomain(domain);
  }-*/;

  /**
   * Adds a callback to the picker
   * 
   * @param callback
   *          The callback to add
   * @return The picker builder instance
   */
  public native PickerBuilder addCallback(AbstractPickerCallback callback) /*-{
		var oldCallbackQueue = this['callbackQueue'];
		this.callbackQueue = function(object) {
			if (oldCallbackQueue) {
				oldCallbackQueue(object);
			}
			@com.floreysoft.gwt.picker.client.callback.PickerCallbackDispatcher::dispatch(Lcom/floreysoft/gwt/picker/client/callback/AbstractPickerCallback;Lcom/floreysoft/gwt/picker/client/domain/result/BaseResult;)(callback, object);
		};
		this.setCallback(this.callbackQueue);
		return this;
  }-*/;

  /**
   * Set the callback method called when the user picks and item (or items), or
   * cancels. The callback method receives a single callback object. The
   * structure of the callback object is described in the <a
   * href="http://code.google.com/intl/de-DE/apis/picker/docs/results.html">JSON
   * Guide</a>
   * 
   * @param callback
   *          The callback to add
   * @return The picker builder instance
   * @deprecated Use
   *             {@link PickerBuilder#addCallback(com.floreysoft.gwt.picker.client.callback.AbstractPickerCallback)}
   *             instead
   */
  public PickerBuilder setCallback(final PickerCallback callback) {
    addCallback(new AbstractPickerCallback() {
      @Override
      public void onPicked(ViewToken viewToken, BaseResult baseResult) {
        callback.onPicked(viewToken, baseResult);
      }

      @Override
      public void onCanceled() {
        callback.onCanceled();
      }
    });
    return this;
  }

  /**
   * ToDo: What kind of document could be set here? Set the document.
   * 
   * @param document
   *          The document to set
   * @return The picker builder instance
   */
  public native PickerBuilder setDocument(JavaScriptObject document) /*-{
		return this.setDocument(document);
  }-*/;

  /**
   * ISO 639 language code. If the language is not supported, en-US is used.
   * This method provides an alternative to setting the locale at google.load()
   * time. See the <a
   * href="http://code.google.com/intl/de-DE/apis/picker/docs/index.html#i18n"
   * >Developer's Guide</a> for a list of supported locales.
   * 
   * @param locale
   *          The locale to set
   * @return The picker builder instance
   */
  public native PickerBuilder setLocale(String locale) /*-{
		return this.setLocale(locale);
  }-*/;

  /**
   * Specify an email address, domain name, or a Google profile ID to use as the
   * authenticated user. The user must already be logged into this account.
   * 
   * @param user
   *          Specify an email address, domain name, or a Google profile ID to
   *          use as the authenticated user. The user must already be logged
   *          into this account.
   * @return The picker builder
   */
  public native PickerBuilder setAuthUser(String user) /*-{
		return this.setAuthUser(user);
  }-*/;

  /**
   * Sets the Google Drive App ID needed to allow application to access the
   * user's files via the Google Drive API.
   * 
   * @param driveAppId
   *          Sets the Google Drive App ID needed to allow application to access
   *          the user's files via the Google Drive API.
   * @return The picker builder
   */
  public native PickerBuilder setAppId(String driveAppId) /*-{
		return this.setAppId(driveAppId);
  }-*/;

  /**
   * Set the list of MIME types which will be selectable. Use commas to separate
   * MIME types if more than one is required.
   * 
   * @param mimetypes
   *          the list of MIME types which will be selectable. Use commas to
   *          separate MIME types if more than one is required
   * @return The picker builder
   */
  public native PickerBuilder setSelectableMimeTypes(String mimeTypes) /*-{
		return this.setSelectableMimeTypes(mimeTypes);
  }-*/;

  /**
   * @return A new instance of the picker builder
   */
  public native static PickerBuilder create() /*-{
		var builder = new $wnd.google.picker.PickerBuilder();
		builder.callbacks = new Array();
		return builder;
  }-*/;
}
