package com.floreysoft.gwt.pickerexample.client;

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
						.setCallback(new PickerCallback<JavaScriptObject>() {
							@Override
							public void onPicked(ViewToken viewToken,
									JavaScriptObject javaScriptObject) {
								final ViewId viewId = viewToken.getViewId();
								DOM.getElementById("output")
										.setInnerHTML(
												"Document from "
														+ (viewId != null ? viewId
																: viewToken
																		.getNativeViewId())
														+ " view was picked.");
							}

							@Override
							public void onCanceled() {
								doOnCancel();
							}
						}).build();
				picker.setVisible(true);
			}
		});
	}

	private void onCreatePicker(ViewId viewId) {
		final Picker picker = PickerBuilder.create().addView(viewId)
				.setCallback(buildPickerCallback(viewId)).build();
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
				ResultPrinter.print(viewToken, videoResult);
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
			public void onPicked(ViewToken viewToken,
					DocumentResult documentResult) {
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
			public void onPicked(ViewToken viewToken,
					ImageSearchResult imageSearchResult) {
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
