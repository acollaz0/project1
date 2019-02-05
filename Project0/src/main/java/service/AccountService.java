package service;

import dao.AccountDao;
import model.User;

public class AccountService {

	public static AccountDao ad = new AccountDao();
	
	public static void getAccount(int u_id) {
		
		ad.getAccounts(u_id);
	}
	public static boolean withdraw(int accnum, double amount) {
		ad.withdraw(accnum, amount);
		return true;
	}
	public static boolean  deposit(int accnum, double amount) {
		ad.deposit(accnum, amount);
		return true;
	}
	public static boolean deleteAccount(int accnum) {
		ad.deleteAccount(accnum);
		return true;
	}
	public static boolean createAccount(User u) {
		ad.createAccount(u);
		return true;
	}
	public static double getAmount(int accnum) {
		return ad.getAmount(accnum);
	}
}
