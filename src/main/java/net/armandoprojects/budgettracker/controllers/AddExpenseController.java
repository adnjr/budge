package net.armandoprojects.budgettracker.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import net.armandoprojects.budgettracker.interfaces.Transaction;
import net.armandoprojects.budgettracker.services.model.TransactionService;
import net.armandoprojects.budgettracker.services.ui.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/** @author The Man */
@Service
@Lazy
public class AddExpenseController implements Initializable {

	@Autowired
	private SceneService sceneService;

	@Autowired
	private TransactionService transactionService;

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
		sceneService.load(SceneService.Scenes.DASHBOARD, homeBtn);
	}

	@FXML
	private void addExpense() {
		if (dateField.getValue() == null || totalField.getText().trim().isEmpty())
			return;

		transactionService.addExpense(dateField.getValue(), totalField.getText()/*, new Jerry(), new Armando()*/);
	}

	@FXML
	private void cancelExpense() {
		Transaction expense = transactionService.getExpense();

		System.out.println("AddExpenseController checking result...");
		System.out.println("transaction 0:");
		System.out.println("\ttype: " + expense.getType());
		System.out.println("\tdate: " + expense.getTransactionDate());
		System.out.println("\ttotal: " + expense.getTotal());
		System.out.println();

		goHome();
	}

}
