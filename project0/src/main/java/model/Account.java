package model;

public class Account {

	private int a_id;
	private double amount;
	private String type;
	private int b_id;
	
	public Account() {
		super();
	}
	
	public Account(int a_id, double amount, String type, int b_id) {
		super();
		this.a_id = a_id;
		this.amount = amount;
		this.type = type;
		this.b_id = b_id;
	}
	
	@Override
	public String toString() {
		return "Account [a_id=" + a_id + ", amount=" + amount + ", type=" + type + ", b_id=" + b_id + "]";
	}

	public int getA_id() {
		return a_id;
	}
	
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public int getB_id() {
		return b_id;
	}

	
}
