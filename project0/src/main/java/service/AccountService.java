package service;

import java.util.List;

import dao.AccountDAO;
import model.Account;

public class AccountService {
	
	public static AccountDAO ad = new AccountDAO();
	
	public static boolean addAccount(Account a) {
		return ad.addAccount(a);
	}
	
	public static List<Account> allAccounts(int b_id){
		return ad.allAccounts(b_id);
	}
	
	public static boolean deleteAccount(int a_id) {
		return ad.deleteAccount(a_id);
	}
	
	public static boolean withdraw(int a_id, double amount) {
		return ad.withdraw(a_id, amount);
	}
	
	public static Account getAccount(int a_id) {
		return ad.getAccount(a_id);
	}
	public static boolean deposit(int a_id, double amount) {
		return ad.deposit(a_id, amount);
	}
	
	public static boolean withdrawAll(int a_id) {
		return ad.withdrawAll(a_id);
	}

}
