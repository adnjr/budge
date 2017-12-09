package net.armandoprojects.budgettracker.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import net.armandoprojects.budgettracker.interfaces.Transaction;

/** @author The Man */
@Entity
public class SingularTransaction implements Serializable, Transaction {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private TransactionType type;
	private LocalDate transactionDate;
//	private Person initiator;
//	private Person target;
	private Long total;

	public SingularTransaction() {
	}

	public SingularTransaction(
		TransactionType type,
		LocalDate transactionDate,
		//		Person initiator,
		//		Person target,
		String total
	) {
		this.type = type;
		this.transactionDate = transactionDate;
//		this.initiator = initiator;
//		this.target = target;
		this.total = Long.parseLong(total);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getTotal() {
		return total;
	}

	@Override
	public void setTotal(Long total) {
		this.total = total;
	}

	/*@Override
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
	}*/
	@Override
	public TransactionType getType() {
		return type;
	}

	@Override
	public void setType(TransactionType type) {
		this.type = type;
	}

	@Override
	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	@Override
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "SingularTransaction{" + "id=" + id + ", type=" + type + ", transactionDate=" + transactionDate + /*", initiator=" + initiator + ", target=" + target + */ ", total=" + total + '}';
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof SingularTransaction))
			return false;

		SingularTransaction other = (SingularTransaction) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
			return false;
		return true;
	}

}
