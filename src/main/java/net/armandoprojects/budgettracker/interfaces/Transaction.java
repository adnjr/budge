package net.armandoprojects.budgettracker.interfaces;

/** @author The Man */
public interface Transaction {

	public Person getInitiator();

	public void setInitiator(Person person);

	public Person getTarget();

	public void setTarget(Person person);

	public Long getTotal();

	public void setTotal(Long total);

}
