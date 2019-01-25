package bank;

import java.util.ArrayList;

public class Account {
	
	private String name;
	private double value;
	private ArrayList<String> transactions;
	private int accountid;
	
	public Account(String name, double value, ArrayList<String> transactions, int accountid) {
		
		this.name = name;
		this.value = value;
		this.transactions = transactions;
		this.accountid = accountid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public ArrayList<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<String> transactions) {
		this.transactions = transactions;
	}
	
	

}
