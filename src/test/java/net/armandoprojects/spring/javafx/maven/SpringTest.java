package net.armandoprojects.spring.javafx.maven;

import net.armandoprojects.budgettracker.interfaces.Transaction;
import net.armandoprojects.budgettracker.interfaces.Person;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.BudgetConfig;

/** @author The Man */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BudgetConfig.class)
public class SpringTest {

//	@Autowired
//	@Qualifier("famous")
//	private Person initiator;
//
//	@Autowired
//	@Qualifier("nobody")
//	private Person target;
	@Autowired
	private Transaction income;

	public SpringTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void notNull() {
//		assertNotNull(initiator);
//		assertNotNull(target);
		assertNotNull(income);
	}

	@Test
	public void toStringTest() {
		System.out.println(income.toString());
	}

	@Test
	public void verifyInitiator() {
		Person in = income.getInitiator();
		assertEquals("Jerry", in.getFirstName());
		assertEquals("Seinfeld", in.getLastName());
	}

	@Test
	public void verifyTarget() {
		assertEquals("Armando", income.getTarget().getFirstName());
		assertEquals("Navarro", income.getTarget().getLastName());
	}

	@Test
	public void verifyTotal() {
		assertEquals(new Long(20L), income.getTotal());
	}
}
