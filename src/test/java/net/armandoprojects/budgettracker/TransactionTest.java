package net.armandoprojects.budgettracker;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.armandoprojects.budgettracker.interfaces.Transaction;
import net.armandoprojects.budgettracker.models.SingularTransaction;
import net.armandoprojects.budgettracker.models.TransactionType;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spring.BudgetConfig;

/** @author The Man */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BudgetConfig.class)
public class TransactionTest {

	private Transaction transaction;

	@PersistenceContext
	private EntityManager entityManager;

	public TransactionTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		transaction = new SingularTransaction(TransactionType.EXPENSE, LocalDate.now(), "120");
	}

	@After
	public void tearDown() {
	}

	@Test
	@Transactional
	public void saveAndLoadTransaction() {
		List<Transaction> transactions;
		Transaction singleTransaction;

		// save a valid transaction to the database
		entityManager.persist(transaction);

		// query database for list of all transactions
		transactions = entityManager.createQuery("select t from SingularTransaction t").getResultList();
		assertEquals(1, transactions.size());

		// retrieve and verify the transaction that was just saved
		singleTransaction = transactions.get(0);
		assertNotNull(singleTransaction);
		assertEquals(TransactionType.EXPENSE, singleTransaction.getType());
		assertEquals(LocalDate.now(), singleTransaction.getTransactionDate());
		assertEquals(new Long(120), singleTransaction.getTotal());
	}
}
