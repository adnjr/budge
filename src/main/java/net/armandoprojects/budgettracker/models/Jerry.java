package net.armandoprojects.budgettracker.models;

import net.armandoprojects.budgettracker.interfaces.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/** @author The Man */
@Component
@Qualifier("famous")
public class Jerry implements Person {

	private String firstName = "Jerry";
	private String lastName = "Seinfeld";

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public void setFirstName(String name) {
		this.firstName = name;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public void setLastName(String name) {
		this.lastName = name;
	}

	@Override
	public String toString() {
		return "Jerry{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
	}
}
