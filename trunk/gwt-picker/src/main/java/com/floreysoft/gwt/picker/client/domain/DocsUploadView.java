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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * DocsUploadView is a subclass of View.
 */
public final class DocsUploadView extends JavaScriptObject {
	protected DocsUploadView() {
	}

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
	 * @param include
	 *            Show folders in the view items.
	 */
	public native void setIncludeFolders(boolean include) /*-{
		this.setIncludeFolders(include);
	}-*/;

	/**
	 * @param parentId
	 *            Sets the initial parent folder to display.
	 */
	public native void setParent(String parentId) /*-{
		this.setParent(parentId);
	}-*/;

	/**
	 * @return A new instance of DocsUploadView
	 */
	public native static DocsUploadView create() /*-{
		return new $wnd.google.picker.DocsUploadView();
	}-*/;
}
