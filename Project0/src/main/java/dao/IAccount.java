package dao;

import java.util.List;

import model.Account;

public interface IAccount {
	
	public Account getAccount(int a_id);
	public boolean addAccount(Account a);
	public boolean deleteAccount(int a_id);
	public List<Account> allAccounts();

}
