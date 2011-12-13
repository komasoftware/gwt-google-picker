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
 * ViewGroup is a visual grouping of views. The ViewGroup itself must be a View.
 */
public final class ViewGroup extends JavaScriptObject {
  protected ViewGroup() {}

  /**
   * Add a label to this ViewGroup.
   *
   * @param label The view group label
   */
  public native void addLabel(String label) /*-{
    this.addLabel(label);
  }-*/;

  /**
   * Add a view to the ViewGroup.
   * The view can be represented by a View-derived object, or simply by ViewId.
   *
   * @param view The view
   */
  public native void addView(JavaScriptObject view) /*-{
    this.addView(view);
  }-*/;

  /**
   * Add a view to the ViewGroup.
   * The view can be represented by a View-derived object, or simply by ViewId.
   *
   * @param viewId The id of the view to add
   */
  public native void addView(ViewId viewId) /*-{
    this.addView(viewId.@com.floreysoft.gwt.picker.client.domain.ViewId::getValue()());
  }-*/;

  /**
   * Nest a ViewGroup within the current ViewGroup.
   *
   * @param viewGroup The view group to add
   */
  public native void addViewGroup(ViewGroup viewGroup) /*-{
    this.addViewGroup(viewGroup);
  }-*/;

  /**
   * A ViewGroup is a visual grouping of Views in the navigation pane. The ViewGroup itself must be a View.
   *
   * @param view The view
   * @return A new view group
   */
  public native static ViewGroup create(JavaScriptObject view) /*-{
    return new $wnd.google.picker.ViewGroup(view);
  }-*/;

  /**
   * A ViewGroup is a visual grouping of Views in the navigation pane. The ViewGroup itself must be a View.
   * 
   * @param viewId The view
   * @return A new view group
   */
  public native static ViewGroup create(ViewId viewId) /*-{
    return new $wnd.google.picker.ViewGroup(viewId.@com.floreysoft.gwt.picker.client.domain.ViewId::getValue()());
  }-*/;
}
