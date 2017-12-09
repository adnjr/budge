package net.armandoprojects.budgettracker.services.model;

import java.time.LocalDate;
import net.armandoprojects.budgettracker.interfaces.Transaction;
import net.armandoprojects.budgettracker.models.SingularTransaction;
import net.armandoprojects.budgettracker.models.TransactionType;
import net.armandoprojects.budgettracker.services.persistence.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** @author The Man */
@Service
@Lazy
public class TransactionService {

	@Autowired
	TransactionRepository repository;

	@Transactional
	public void addExpense(LocalDate transactionDate, String total/*, Person initiator, Person target*/) {
		Transaction expense = new SingularTransaction(TransactionType.EXPENSE, transactionDate/*, initiator, target*/, total);
		repository.save(expense);

		System.out.println("Expense added:");
		System.out.println(expense.toString());
		System.out.println();
	}

	@Transactional
	public Transaction getExpense() {
		return repository.load();
	}

}
