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
import com.google.gwt.core.client.JavaScriptObject;

/**
 * ImageSearchView is a subclass of View. Finer aspects of image searches can be controlled using this class.
 */
public final class ImageSearchView extends JavaScriptObject {
  protected ImageSearchView() {}

  /**
   * @return The view id
   */
  public ViewId getId() {
    return ViewId.findByValue(getNativeId());
  }

  /**
   * Sets the query
   *
   * @param string The search query
   */
  public native void setQuery(String string) /*-{
    this.setQuery(string);
  }-*/;

  /**
   * Set the License filter for images.
   * This allows clients to filter items returned based on Creative Commons attributes.
   * For more details, read <a href="http://www.google.com/support/websearch/bin/answer.py?&answer=29508">Usage Rights</a>
   *
   * @param license The license
   */
  public native void setLicense(License license) /*-{
    this.setLicense(license.@com.floreysoft.gwt.picker.client.domain.ImageSearchView.License::getValue()());
  }-*/;

  /**
   * Add a site filter for image source. E.g. flickr.com.
   * Only the last site set by setSite is honored (i.e. it is not cumulative.)
   *
   * @param site The site
   */
  public native void setSite(String site) /*-{
    this.setSite(site);
  }-*/;

  /**
   * Set the minimum size of image.
   *
   * @param size The image size
   */
  public native void setSize(Size size) /*-{
    this.setSize(size.@com.floreysoft.gwt.picker.client.domain.ImageSearchView.Size::getValue()());
  }-*/;

  /**
   * Creates and return a new instance of ImageSearchView
   */
  public native static ImageSearchView create() /*-{
    return new $wnd.google.picker.ImageSearchView();
  }-*/;

  private native String getNativeId() /*-{
    return this.getId();
  }-*/;

  public static enum License implements JavaScriptEnum<String> {
    /**
     * No Creative Commons attributes required. All images.
     */
    NONE("NONE"),

    /**
     * Excludes cc_noncommercial.
     */
    COMMERCIAL_REUSE("COMMERCIAL_REUSE"),

    /**
     * Excludes cc_noncommercial and cc_nonderived. Default choice.
     */
    COMMERCIAL_REUSE_WITH_MODIFICATION("​COMMERCIAL_REUSE_WITH_MODIFICATION"),

    /**
     * No exclusions for images with Creative Common attributes.
     */
    REUSE("REUSE"),

    /**
     * Excludes cc_nonderived.
     */
    REUSE_WITH_MODIFICATION("REUSE_WITH_MODIFICATION");

    private final String value;

    License(String value) {
      this.value = value;
    }

    public String getValue() {
      return JavaScriptUtils.enumValue("ImageSearchView", "License", value);
    }
  }

  public enum Size implements JavaScriptEnum<String> {
    /**
     * Images at least 400x300 in either aspect ratio.
     */
    SIZE_QSVGA("SIZE_QSVGA"),

    /**
     * Images at least 640x480.
     */
    SIZE_VGA("SIZE_VGA"),

    /**
     * Images at least 800x600.
     */
    SIZE_SVGA("SIZE_SVGA"),

    /**
     * Images at least 1024x768.
     */
    SIZE_XGA("SIZE_XGA"),

    /**
     * Images at least 1280x800.
     */
    SIZE_WXGA("SIZE_WXGA"),

    /**
     * Images at least 1440x900.
     */
    SIZE_WXGA2("SIZE_WXGA2"),

    /**
     * Images at least 2 megapixels.
     */
    SIZE_2MP("SIZE_2MP"),

    /**
     * Images at least 4 megapixels.
     */
    SIZE_4MP("SIZE_4MP"),

    /**
     * Images at least 6 megapixels.
     */
    SIZE_6MP("SIZE_6MP"),

    /**
     * Images at least 8 megapixels.
     */
    SIZE_8MP("SIZE_8MP"),

    /**
     * Images at least 10 megapixels.
     */
    SIZE_10MP("SIZE_10MP"),

    /**
     * Images at least 12 megapixels.
     */
    SIZE_12MP("SIZE_12MP"),

    /**
     * Images at least 15 megapixels.
     */
    SIZE_15MP("SIZE_15MP"),

    /**
     * Images at least 20 megapixels.
     */
    SIZE_20MP("SIZE_20MP"),

    /**
     * Images at least 40 megapixels.
     */
    SIZE_40MP("SIZE_40MP"),

    /**
     * Images at least 70 megapixels.
     */
    SIZE_70MP("SIZE_70MP"),

    /**
     * Images at least 140 megapixels.
     */
    SIZE_140MP("SIZE_140MP");

    private final String value;

    private  Size(String value) {
      this.value = value;
    }

    public String getValue() {
      return JavaScriptUtils.enumValue("ImageSearchView", "Size", value);
    }
  }
}
