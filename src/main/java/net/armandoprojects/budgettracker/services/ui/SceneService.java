package net.armandoprojects.budgettracker.services.ui;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.armandoprojects.budgettracker.helpers.SceneMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/** Provides common services involved in the swapping out of scenes.
 * @author The Man */
@Service
@Lazy
public class SceneService {

	public enum Scenes {
		DASHBOARD, ADD_EXPENSE
	}

	private final Map<Scenes, SceneMetadata> scenes = new HashMap<>();

	@Autowired
	private ApplicationContext context;

//	@Autowired
//	private final Stage mainStage;
	public SceneService() {
//		this.mainStage = (Stage) context.getBean("mainStage");

		// map each scene's enum to its fxml/css locations and title
		scenes.put(Scenes.DASHBOARD, new SceneMetadata(
			"/net/armandoprojects/budgettracker/views/Dashboard.fxml",
			"/net/armandoprojects/budgettracker/views/styles/dashboard.css",
			"JavaFX / Maven / Spring"
		));
		scenes.put(Scenes.ADD_EXPENSE, new SceneMetadata(
			"/net/armandoprojects/budgettracker/views/AddExpense.fxml",
			"/net/armandoprojects/budgettracker/views/styles/addexpense.css",
			"Add Expense"
		));
	}

	/** Load the specified scene onto the give node's stage.
	 * @param sceneEnum Enum indicating which scene to load.
	 * @param node The stage this node is on will be used.
	 * @return The stage argument for convenience. e.g. chaining w/.show() */
	public Stage load(Scenes sceneEnum, Node node) {
		Stage stage = (Stage) node.getScene().getWindow();
		return this.load(sceneEnum, stage);
	}

	/** Load the specified scene onto the given stage
	 * @param sceneEnum Enum indicating which scene to load.
	 * @param stage The stage to set the scene onto.
	 * @return The stage argument for convenience. e.g. chaining w/.show() */
	public Stage load(Scenes sceneEnum, Stage stage) {
		SceneMetadata sceneData = scenes.get(sceneEnum);
		Scene scene = this.load(sceneData.getFxmlLocation());
		scene.getStylesheets().add(sceneData.getCssLocation());
//		Stage mainStage = (Stage)context.getBean("mainStage");
		stage.setTitle(sceneData.getTitle());
		stage.setScene(scene);

		return stage;
	}

	/** @return A new scene using the given FXML resource location. */
	private Scene load(String fxmlLocation) {
		Scene scene;

		try (InputStream fxmlStream = getClass().getResourceAsStream(fxmlLocation)) {
			URL dashboardUrl = getClass().getResource(fxmlLocation);

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(dashboardUrl);
			loader.setControllerFactory(context::getBean);
			Parent dashboardRoot = loader.load(fxmlStream);

			scene = new Scene(dashboardRoot);
		}
		catch (Exception e) {
			System.err.println("DEBUG: EXCEPTION CAUGHT");
			System.err.println(e.getMessage());
			scene = new Scene(new Group());
		}

		return scene;
	}

//	/** Loads the fxml and css into a new scene w/title on the given stage.
//	 * @return The given stage for convenience, e.g. to chain call show(). */
//	public Stage load(String fxmlLocation, String cssLocation, String title, Stage stage) {
//		Scene scene = this.load(fxmlLocation);
//		scene.getStylesheets().add(cssLocation);
//		stage.setTitle(title);
//		stage.setScene(scene);
//
//		return stage;
//	}
}
