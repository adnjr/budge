package net.armandoprojects.budgettracker.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import net.armandoprojects.budgettracker.services.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardController implements Initializable {

	@FXML
	private Button addBtn;

	@FXML
	private ContextMenu addMenu;

	@FXML
	private Label label;

	@Autowired
	private SceneService scene;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		label.setText("Hello World!");

		// "show" context menu invisibly to determine menu dimensions
		addMenu.setOpacity(0.0);
		addMenu.show(addBtn, Side.BOTTOM, 0, 0);
		double xOffset = addMenu.getWidth() - addBtn.getWidth() * 2;
		double yOffset = addMenu.getHeight() - addBtn.getHeight() * 2;

		// show menu for real this time w/correct offsets
		addMenu.hide();
		addMenu.show(addBtn, Side.BOTTOM, -xOffset, yOffset);
		addMenu.setOpacity(1.0);
	}

	@FXML
	private void addExpense(ActionEvent event) {
		scene.load(SceneService.Scenes.ADD_EXPENSE, addBtn);
	}

	@FXML
	private void addIncome(ActionEvent event) {
		System.out.println("add income clicked");
	}
}
