package com.floreysoft.gwt.pickerexample.client;

import com.floreysoft.gwt.picker.client.callback.AbstractPickerCallback;
import com.floreysoft.gwt.picker.client.domain.*;
import com.floreysoft.gwt.picker.client.domain.result.*;
import com.floreysoft.gwt.picker.client.utils.PickerLoader;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PickerExample implements EntryPoint {
  private String API_KEY = "ABQIAAAAEkVppYdTSEm7bRYWk3asKhRi_j0U6kJrkFvY4-OX2XYmEAa76BQQdp3lDrRrX26Mir42hNxas7NyuQ";

  public void onModuleLoad() {
    PickerLoader.loadApi(API_KEY, new Runnable() {
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
                .addViewGroup(group).addView(ViewId.VIDEO_SEARCH)
                .setLocale("de").setTitle("my big fat picker example")
                .setUploadToAlbumId("albumId")
                .enableFeature(Feature.MULTISELECT_ENABLED)
                .disableFeature(Feature.NAV_HIDDEN)
                .addCallback(new AbstractPickerCallback() {
                  @Override
                  public void onPicked(ViewToken viewToken, BaseResult baseResult) {
                    final ViewId viewId = viewToken.getViewId();
                    DOM.getElementById("output")
                            .setInnerHTML("Document from " + (viewId != null ? viewId : viewToken.getNativeViewId()) + " view was picked.");
                  }

                  @Override
                  public void onCanceled() {
                    doOnCancel();
                  }
                })
                .addCallback(new AbstractPickerCallback() {
                  @Override
                  public void onPicked(ViewToken viewToken, BaseResult baseResult) {
                    GWT.log("This must be a map:" + (baseResult.getViewToken().getViewId().equals(ViewId.MAPS)));
                  }

                  @Override
                  public void onCanceled() {
                  }

                  @Override
                  public boolean isApplicable(ViewToken token) {
                    return token.getViewId().equals(ViewId.MAPS);
                  }
                })
                .build();
        picker.setVisible(true);
      }
    }

    );
  }

  private void onCreatePicker(ViewId viewId) {
    final Picker picker = PickerBuilder.create().addView(viewId)
            .addCallback(buildPickerCallback(viewId)).build();
    picker.setVisible(true);
  }

  private AbstractPickerCallback buildPickerCallback(final ViewId viewId) {
    return new AbstractPickerCallback() {
      @Override
      public void onPicked(ViewToken viewToken, BaseResult result) {
        switch (viewId) {
          case DOCS:
          case DOCUMENTS:
          case SPREADSHEETS:
          case FORMS:
          case PRESENTATIONS:
          case FOLDERS:
          case PDFS:
          case RECENTLY_PICKED:
            ResultPrinter.print(viewToken, result.<DocumentResult>cast());
            break;
          case IMAGE_SEARCH:
            ResultPrinter.print(viewToken, result.<ImageSearchResult>cast());
            break;
          case MAPS:
            ResultPrinter.print(viewToken, result.<MapResult>cast());
            break;
          case PHOTOS:
          case PHOTO_UPLOAD:
            ResultPrinter.print(viewToken, result.<PhotoResult>cast());
            break;
          case VIDEO_SEARCH:
          case YOUTUBE:
            ResultPrinter.print(viewToken, result.<VideoResult>cast());
            break;
          default:
            GWT.log("Unknown view id " + viewId);
        }
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
