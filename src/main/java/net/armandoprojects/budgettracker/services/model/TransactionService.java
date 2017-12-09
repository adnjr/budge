package net.armandoprojects.budgettracker.services.model;

import java.time.LocalDate;
import net.armandoprojects.budgettracker.interfaces.Person;
import net.armandoprojects.budgettracker.interfaces.Transaction;
import net.armandoprojects.budgettracker.models.SingularTransaction;
import net.armandoprojects.budgettracker.models.TransactionType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/** @author The Man */
@Service
@Lazy
public class TransactionService {

	public void addExpense(LocalDate timestamp, String total, Person initiator, Person target) {
		Transaction expense = new SingularTransaction(TransactionType.EXPENSE, timestamp, initiator, target, total);
		System.out.println("Expense added:");
		System.out.println(expense.toString());
		System.out.println();
	}

}
