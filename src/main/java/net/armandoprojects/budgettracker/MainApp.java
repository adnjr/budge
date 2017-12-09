package net.armandoprojects.budgettracker;

import net.armandoprojects.budgettracker.models.SingularTransaction;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import net.armandoprojects.budgettracker.services.ui.SceneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.BudgetConfig;

public class MainApp extends Application {

//	private static final String DASHBOARD_TITLE = "JavaFX / Maven / Spring";
//	private static final String DASHBOARD_FXML = "/net/armandoprojects/spring/javafx/maven/gui/Dashboard.fxml";
//	private static final String DASHBOARD_CSS = "/net/armandoprojects/spring/javafx/maven/gui/styles/dashboard.css";
	@Override
	public void start(Stage stage) throws Exception {
//		DefaultListableBeanFactory parentBeanFactory;
		AnnotationConfigApplicationContext context;
//		GenericApplicationContext parentContext;

		// create spring application context and register stage
//		parentBeanFactory = new DefaultListableBeanFactory();
//		parentBeanFactory.registerResolvableDependency(Stage.class, stage);
//		parentContext = new GenericApplicationContext(parentBeanFactory);
//		parentContext.refresh();
		context = new AnnotationConfigApplicationContext(BudgetConfig.class);
//		context.register(BudgetConfig.class);
//		context.getBeanFactory().registerSingleton("mainStage", stage);
//		context.getBeanFactory().registerResolvableDependency(Stage.class, stage);
//		context.refresh();

		this.showGUI(stage, context);
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void showGUI(Stage stage, AnnotationConfigApplicationContext context) throws Exception {
		SceneService scene = context.getBean(SceneService.class);

		// create a scene from dasbhoard fxml and show the stage
		scene.load(SceneService.Scenes.DASHBOARD, stage).show();
	}

	private void testSpring(SingularTransaction expense) {
		System.out.println(expense.toString());
	}

}
