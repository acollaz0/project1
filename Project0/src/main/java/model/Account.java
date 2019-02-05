package model;

import java.util.ArrayList;
import java.util.List;



public class Account {
	
	public int accountnumber;//
	public String type;//which type of account this is ie. checking or savings
	private double amount;//how much is in the account
	List<Integer> transactions = new ArrayList<Integer>();
	
	public Account() {
		super();
	}
	public Account(int acc_num,Double amount) {
		this.accountnumber = acc_num;
		this.amount = amount;
	}
	public void amount() {
		this.amount = 0.00;
	}

	public void amount(double n) {
		this.amount = n;
	}
	public double getAmount() {
		return this.amount;	
	}
	public void withdraw(double n) {
		this.amount = this.amount - n;
		
	}
	public void deposit(double n) {
		this.amount = this.amount +n;
		
	}

}
