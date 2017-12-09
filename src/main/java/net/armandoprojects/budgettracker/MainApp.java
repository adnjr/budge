package net.armandoprojects.budgettracker;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import net.armandoprojects.budgettracker.services.ui.SceneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.BudgetConfig;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		AnnotationConfigApplicationContext context;
//		DefaultListableBeanFactory parentBeanFactory;
//		GenericApplicationContext parentContext;

		// create Spring application context
		context = new AnnotationConfigApplicationContext(BudgetConfig.class);

//		// create spring application context and register stage
//		parentBeanFactory = new DefaultListableBeanFactory();
//		parentBeanFactory.registerResolvableDependency(Stage.class, stage);
//		parentContext = new GenericApplicationContext(parentBeanFactory);
//		parentContext.refresh();
//		// register the main stage as a singleton w/Spring's application context
//		context.register(BudgetConfig.class);
//		context.getBeanFactory().registerSingleton("mainStage", stage);
//		context.getBeanFactory().registerResolvableDependency(Stage.class, stage);
//		context.refresh();
		this.showGUI(stage, context);
	}

	public static void main(String[] args) {
		launch(args);
	}

	/** Use services obtained from the given context to set and show the stage. */
	private void showGUI(Stage stage, AnnotationConfigApplicationContext context) throws Exception {
		// retrieve SceneService bean from Spring's application context
		SceneService scene = context.getBean(SceneService.class);

		// create and load the dashboard scene onto the stage
		scene.load(SceneService.Scenes.DASHBOARD, stage).show();
	}

}
