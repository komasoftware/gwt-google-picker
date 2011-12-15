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

package com.floreysoft.gwt.picker.client;

import com.floreysoft.gwt.picker.client.utils.PickerLoader;
import com.google.gwt.junit.client.GWTTestCase;

public abstract class PickerTestCase extends GWTTestCase {
	private String API_KEY = "ABQIAAAAEkVppYdTSEm7bRYWk3asKhRi_j0U6kJrkFvY4-OX2XYmEAa76BQQdp3lDrRrX26Mir42hNxas7NyuQ";
	private boolean apiAlreadyLoaded = false;

	@Override
	public String getModuleName() {
		return "com.google.gwt.picker.PickerTest";
	}

	public void withApi(Runnable runnable) {
		withApi(runnable, true);
	}

	public void withApi(final Runnable runnable, final boolean callFinishTest) {
		if (apiAlreadyLoaded) {
			runnable.run();
			return;
		}

		PickerLoader.loadApi(API_KEY, new Runnable() {
      public void run() {
        apiAlreadyLoaded = true;
        runnable.run();
        if (callFinishTest) {
          finishTest();
        }
      }
    });
	}
}
