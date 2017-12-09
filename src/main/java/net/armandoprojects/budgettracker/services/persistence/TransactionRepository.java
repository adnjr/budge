package net.armandoprojects.budgettracker.services.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.armandoprojects.budgettracker.interfaces.Transaction;
import org.springframework.stereotype.Repository;

/** @author The Man */
@Repository
public class TransactionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Transaction save(Transaction expense) {
//		EntityTransaction transaction = entityManager.getTransaction();

//		transaction.begin();
		entityManager.persist(expense);
//		transaction.commit();

		return expense;
	}

	public Transaction load() {
		List<Transaction> transactions;
		Transaction singleTransaction;

		transactions = entityManager.createQuery("select t from SingularTransaction t").getResultList();
		singleTransaction = transactions.get(0);

		return singleTransaction;
	}

}
