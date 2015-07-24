# Getting Started with the GWT Google Picker API #
## Assumptions ##
  * You are familiar with Google Web Toolkit.
  * You know how to create a new GWT project using the Google Plugin for Eclipse.
  * You are familiar with Google Picker API.
  * You are using GWT 2.0 or later.

## Downloading the gwt-google-picker API Library for GWT ##
You can download the latest production releases of the libraries from the [project download page](http://code.google.com/p/gwt-google-picker/downloads/list).

## Setting up a GWT Project to use the GWT Goole Picker API ##
There are two steps needed to use the Google Picker API in a GWT project:

  1. Include the library JAR file in the classpath
  1. Inherit `com.google.gwt.picker.Picker` in the module XML definition file.

## Example how to use the Google Picker API in your project ##
```
package com.google.gwt.pickerexample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.picker.client.callback.*;
import com.google.gwt.picker.client.domain.*;
import com.google.gwt.picker.client.domain.result.*;
import com.google.gwt.picker.client.utils.PickerLoader;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PickerExample implements EntryPoint {
  public void onModuleLoad() {
    PickerLoader.loadApi(new Runnable() {
      public void run() {
        onPickerLoaded();
      }
    });
  }

  private void onPickerLoaded() {
    for (final ViewId viewId : ViewId.values()) {
      final Button button = new Button(viewId.name().toLowerCase());
      button.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent clickEvent) {
          onCreatePicker(viewId);
        }
      });

      RootPanel.get("buttons").add(button);
    }

    final Button button = new Button("View Group");
    RootPanel.get("buttons").add(button);

    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent clickEvent) {
        final ViewGroup group = ViewGroup.create(MapsView.create());
        group.addView(ImageSearchView.create());
        group.addView(PhotosView.create());
        group.addView(VideoSearchView.create());
        group.addView(ViewId.DOCUMENTS);

        final Picker picker = PickerBuilder.create()
                .addViewGroup(group)
                .addView(ViewId.VIDEO_SEARCH)
                .setLocale("de")
                .setTitle("my big fat picker example")
                .setUploadToAlbumId("albumId")
                .enableFeature(Feature.MULTISELECT_ENABLED)
                .disableFeature(Feature.NAV_HIDDEN)
                .setCallback(new PickerCallback<JavaScriptObject>() {
                  @Override
                  public void onPicked(ViewToken viewToken, JavaScriptObject javaScriptObject) {
                    final ViewId viewId = viewToken.getViewId();
                    DOM.getElementById("output").setInnerHTML("Document from " + 
                    (viewId != null ? viewId : viewToken.getNativeViewId()) + " view was picked.");
                  }

                  @Override
                  public void onCanceled() {
                    doOnCancel();
                  }
                })
                .build();
        picker.setVisible(true);
      }
    });
  }

  private void onCreatePicker(ViewId viewId) {
    final Picker picker = PickerBuilder.create()
            .addView(viewId)
            .setCallback(buildPickerCallback(viewId))
            .build();
    picker.setVisible(true);
  }

  private PickerCallback buildPickerCallback(ViewId viewId) {
    switch (viewId) {
      case DOCS:
      case DOCUMENTS:
      case SPREADSHEETS:
      case FORMS:
      case PRESENTATIONS:
      case FOLDERS:
      case PDFS:
      case RECENTLY_PICKED:
        return createDocumentCallback();
      case IMAGE_SEARCH:
        return createImageSearchCallback();
      case MAPS:
        return createMapsCallback();
      case PHOTOS:
      case PHOTO_UPLOAD:
        return createPhotoCallback();
      case VIDEO_SEARCH:
      case YOUTUBE:
        return createVideoCallback();
    }

    return null;
  }

  private PickedVideoCallback createVideoCallback() {
    return new PickedVideoCallback() {
      @Override
      public void onPicked(ViewToken viewToken, VideoResult videoResult) {
        ResultPrinter.print(viewToken,  videoResult);
      }

      @Override
      public void onCanceled() {
        doOnCancel();
      }
    };
  }

  private PickedPhotoCallback createPhotoCallback() {
    return new PickedPhotoCallback() {
      @Override
      public void onPicked(ViewToken viewToken, PhotoResult photoResult) {
        ResultPrinter.print(viewToken, photoResult);
      }

      @Override
      public void onCanceled() {
        doOnCancel();
      }
    };
  }

  private PickedMapCallback createMapsCallback() {
    return new PickedMapCallback() {
      @Override
      public void onPicked(ViewToken viewToken, MapResult mapResult) {
        ResultPrinter.print(viewToken, mapResult);
      }

      @Override
      public void onCanceled() {
        doOnCancel();
      }
    };
  }

  private PickedDocumentCallback createDocumentCallback() {
    return new PickedDocumentCallback() {
      @Override
      public void onPicked(ViewToken viewToken, DocumentResult documentResult) {
        ResultPrinter.print(viewToken, documentResult);
      }

      @Override
      public void onCanceled() {
        doOnCancel();
      }
    };
  }

  private PickedImageSearchCallback createImageSearchCallback() {
    return new PickedImageSearchCallback() {
      @Override
      public void onPicked(ViewToken viewToken, ImageSearchResult imageSearchResult) {
        ResultPrinter.print(viewToken, imageSearchResult);
      }

      @Override
      public void onCanceled() {
        doOnCancel();
      }
    };
  }

  private void doOnCancel() {
    DOM.getElementById("output").setInnerHTML("canceled");
  }
}
```