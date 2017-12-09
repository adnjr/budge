package net.armandoprojects.budgettracker.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import net.armandoprojects.budgettracker.services.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author The Man */
@Service
public class AddExpenseController implements Initializable {

	@Autowired
	private SceneService scene;

	@FXML
	private Button homeBtn;

	@FXML
	private Button okayBtn;

	@FXML
	private Button cancelBtn;

	@FXML
	private DatePicker dateField;

	@FXML
	private TextField totalField;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	private void goHome() {
		this.scene.load(SceneService.Scenes.DASHBOARD, homeBtn);
	}

	@FXML
	private void addExpense() {
		this.goHome();
	}

	@FXML
	private void cancelExpense() {
		this.goHome();
	}

}
