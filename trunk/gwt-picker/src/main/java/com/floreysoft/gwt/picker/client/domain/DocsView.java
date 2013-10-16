/*
 * Copyright 2011 floreysoft GmbH (www.floreysoft.net)
 *
 * Written by Daniel Florey (daniel.florey@floreysoft.net)
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
 * DocsView is a subclass of View.
 */
public final class DocsView extends JavaScriptObject {
  protected DocsView() {
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
   * @param mimetypes
   *          For views listing documents, set the MIME types which will be
   *          included in the view. Use commas to separate MIME types if more
   *          than one is required.
   */
  public native void setMimeTypes(String mimetypes) /*-{
		this.setMimeTypes(mimetypes);
  }-*/;

  /**
   * @param include
   *          Show folders in the view items.
   */
  public native void setIncludeFolders(boolean include) /*-{
		this.setIncludeFolders(include);
  }-*/;

  /**
   * @param selectFolder
   *          Enables folder selection
   */
  public native void setSelectFolderEnabled(boolean selectFolder) /*-{
		this.setSelectFolderEnabled(selectFolder);
  }-*/;

  /**
   * @param mine
   *          Filters the documents based on whether they are owned by the user,
   *          or shared with the user.
   */
  public native void setOwnedByMe(boolean mine) /*-{
		this.setOwnedByMe(mine);
  }-*/;

  /**
   * @param starred
   *          Filters the documents based on whether they are starred by the
   *          user.
   */
  public native void setStarred(boolean starred) /*-{
		this.setStarred(starred);
  }-*/;

  /**
   * @param parentId
   *          Sets the initial parent folder to display.
   */
  public native void setParent(String parentId) /*-{
		this.setParent(parentId);
  }-*/;

  /**
   * @return A new instance of DocsView
   */
  public native static DocsView create() /*-{
		return new $wnd.google.picker.DocsView();
  }-*/;

  /**
   * @return A new instance of DocsView
   */
  public native static DocsView create(ViewId viewId) /*-{
		return new $wnd.google.picker.DocsView(viewId);
  }-*/;
}