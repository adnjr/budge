package net.armandoprojects.budgettracker.interfaces;

import java.time.LocalDate;
import net.armandoprojects.budgettracker.models.TransactionType;

/** @author The Man */
public interface Transaction {

	/*public Person getInitiator();

	public void setInitiator(Person person);

	public Person getTarget();

	public void setTarget(Person person);*/
	public Long getTotal();

	public void setTotal(Long total);

	public TransactionType getType();

	public void setType(TransactionType type);

	public LocalDate getTransactionDate();

	public void setTransactionDate(LocalDate transactionDate);

}
