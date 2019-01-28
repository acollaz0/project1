package models;

import dao.ClipBoxDAO;

public class ClipBox {
	
	private User user;
	private int balance;
	private String boxID;
	private static ClipBoxDAO cbdao = new ClipBoxDAO();
	private String description;
	
	public ClipBox(User user, int balance, String cb_id) {
		super();
		this.user = user;
		this.balance = balance;
		this.boxID = cb_id;
		this.description = "-";
	}
	
	public ClipBox(User user, int balance, String cb_id, String description) {
		super();
		this.user = user;
		this.balance = balance;
		this.boxID = cb_id;
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	public int getBalance() {
		
		this.balance = cbdao.getBalance(this.boxID);
		
		return balance;
	}
	public String getCb_id() {
		return boxID;
	}

	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return String.format("| %10s | %20s | %10d | %40s |", this.boxID, this.user.getUsername(), this.getBalance(), this.description);
	}

	public Transaction withdraw(int withdrawl) {
		Transaction t = cbdao.makeTransaction(this.boxID, -1*withdrawl);
		if (t!=null) {
			this.balance-=withdrawl;
			return t;
		}
		return null;
	}

	public Transaction deposit(int deposit) {
		
		Transaction t = cbdao.makeTransaction(this.boxID, deposit);
		if (t!=null) {
			this.balance+=deposit;
			return t;
		}
		return null;
	}
	
	

}
