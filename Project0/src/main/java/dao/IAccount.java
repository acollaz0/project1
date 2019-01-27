package dao;

import java.util.List;
import model.Account;

public interface IAccount {
	
	public Account getAccount(int a_id);
	public boolean addAccount(Account a);
	public boolean deleteAccount(int a_id);
	public boolean withdraw(int a_id, int amount);
	public boolean deposit(int a_id, int amount);
	public boolean withdrawAll(int a_id);
	public List<Account> allAccounts(int b_id);

}
