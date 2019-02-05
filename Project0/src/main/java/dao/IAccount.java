package dao;

import model.User;
import model.Account;

public interface IAccount {
	
	public Account getAccount(int accnum);
	public double getAmount(int accnum);
	public boolean withdraw(int accnum, double amount);
	public boolean deposit(int accnum, double amount);
	public boolean closeAccount(int accnum);
	public boolean createAccount(User u);
	//public List<Integer> getTransactions(int acc);

}
