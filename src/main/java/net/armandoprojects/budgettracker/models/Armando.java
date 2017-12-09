package net.armandoprojects.budgettracker.models;

import net.armandoprojects.budgettracker.interfaces.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/** @author The Man */
@Component
@Qualifier("nobody")
public class Armando implements Person {

	private String firstName = "Armando";
	private String lastName = "Navarro";

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
		return "Armando{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
	}

}
