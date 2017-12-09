package net.armandoprojects.budgettracker.models;

import net.armandoprojects.budgettracker.interfaces.Person;
import net.armandoprojects.budgettracker.interfaces.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** @author The Man */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SingularTransaction implements Transaction {

	private TransactionType type;
	private Person initiator;
	private Person target;
	private Long total;

	@Autowired
	public SingularTransaction(
		TransactionType type,
		@Qualifier("famous") Person initiator,
		@Qualifier("nobody") Person target,
		@Value("#{20L}") Long total
	) {
		this.type = type;
		this.initiator = initiator;
		this.target = target;
		this.total = total;
	}

	@Override
	public Long getTotal() {
		return total;
	}

	@Override
	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public Person getInitiator() {
		return initiator;
	}

	@Override
	public void setInitiator(Person initiator) {
		this.initiator = initiator;
	}

	@Override
	public Person getTarget() {
		return target;
	}

	@Override
	public void setTarget(Person target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "SingularTransaction{" + "initiator=" + initiator.toString() + ", target=" + target.toString() + ", total=" + total.toString() + '}';
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

}
