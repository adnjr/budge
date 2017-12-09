package net.armandoprojects.budgettracker.helpers;

/** @author The Man */
public class SceneMetadata {

	private final String fxmlLocation;
	private final String cssLocation;
	private final String title;

	public SceneMetadata(String fxmlLocation, String cssLocation, String title) {
		this.fxmlLocation = fxmlLocation;
		this.cssLocation = cssLocation;
		this.title = title;
	}

	public String getFxmlLocation() {
		return fxmlLocation;
	}

	public String getCssLocation() {
		return cssLocation;
	}

	public String getTitle() {
		return title;
	}

}
