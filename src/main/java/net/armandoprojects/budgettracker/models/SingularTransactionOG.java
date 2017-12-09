package net.armandoprojects.budgettracker.models;

import java.time.LocalDate;
import net.armandoprojects.budgettracker.interfaces.Person;
import net.armandoprojects.budgettracker.interfaces.Transaction;

/** @author The Man */
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SingularTransaction implements Transaction {

	private TransactionType type;
	private LocalDate timestamp;
	private Person initiator;
	private Person target;
	private Long total;

	public SingularTransaction(
		TransactionType type,
		LocalDate timestamp,
		/* @Qualifier("famous") */ Person initiator,
		/* @Qualifier("nobody") */ Person target,
		/* @Value("#{20L}") */ String total
	) {
		this.type = type;
		this.timestamp = timestamp;
		this.initiator = initiator;
		this.target = target;
		this.total = Long.parseLong(total);
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
	public TransactionType getType() {
		return type;
	}

	@Override
	public void setType(TransactionType type) {
		this.type = type;
	}

	@Override
	public LocalDate getTimestamp() {
		return timestamp;
	}

	@Override
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "SingularTransaction{" + "type=" + type + ", timestamp=" + timestamp + ", initiator=" + initiator + ", target=" + target + ", total=" + total + '}';
	}

}
