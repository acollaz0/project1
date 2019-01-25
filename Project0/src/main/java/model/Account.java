package model;

public class Account {

	private int a_id;
	private int amount;
	private String type;
	
	public Account() {
		super();
	}
	
	public Account(int a_id, int amount, String type) {
		super();
		this.a_id = a_id;
		this.amount = amount;
		this.type = type;
	}
	
	public int getA_id() {
		return a_id;
	}
	
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
