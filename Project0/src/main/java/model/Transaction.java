package model;

public class Transaction {
	
	private int transaction_id;
	private double balance_before;
	private double balance_after;
	
	/**
	 * Constructor used for getting a transaction from the database
	 * @param transaction_id
	 * @param amount
	 */
	public Transaction(int transaction_id, double balance_before, double balance_after) {
		super();
		this.transaction_id = transaction_id;
		this.balance_before = balance_before;
		this.balance_after = balance_after;
	}
	

	/**
	 * Constructor used for adding a Transaction to the database.
	 * Lacks a transaction_id parameter because a SQL sequence will generate a new transaction_id.
	 * @param balance_before
	 * @param balance_after
	 */
	public Transaction(double balance_before, double balance_after) {
		super();
		this.balance_before = balance_before;
		this.balance_after = balance_after;
	}


	/**
	 * @return the transaction_id
	 */
	public int getTransaction_id() {
		return transaction_id;
	}

	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * @return the balance_before
	 */
	public double getBalance_before() {
		return balance_before;
	}

	/**
	 * @param balance_before the balance_before to set
	 */
	public void setBalance_before(double balance_before) {
		this.balance_before = balance_before;
	}

	/**
	 * @return the balance_after
	 */
	public double getBalance_after() {
		return balance_after;
	}

	/**
	 * @param balance_after the balance_after to set
	 */
	public void setBalance_after(double balance_after) {
		this.balance_after = balance_after;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", balance_before=" + balance_before
				+ ", balance_after=" + balance_after + "]";
	}

	
	
}
