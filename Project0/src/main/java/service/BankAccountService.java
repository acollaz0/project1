package service;

import java.util.List;

import dao.BankAccountDAO;
import model.BankAccount;

public class BankAccountService {
	
	private static BankAccountDAO bad = new BankAccountDAO();
	
	/**
	 * addBankAccount method
	 * Adds a bank account for a given user
	 * @param user_id The ID of the User which will get a new account
	 * @param ba The BankAccount to add for this user
	 * @return true if the bank account was successfully added, else false
	 */
	public static boolean addBankAccount(int user_id, BankAccount ba) {
		
		return bad.addBankAccount(user_id, ba);
	}
	
	/**
	 * updateBankAccount method
	 * Updates a given bank account
	 * @param ba The BankAccount to update, with its updated fields
	 * @return true if the BankAccount was actually updated, else false
	 */
	public static boolean updateBankAccount(BankAccount ba) {
		
		return bad.updateBankAccount(ba);
	}
	
	/**
	 * deleteBankAccount method
	 * Deletes a BankAccount from the database
	 * @param bank_account_id The ID of the BankAccount to delete
	 * @return true if the account was actually deleted, else false
	 */
	public static boolean deleteBankAccount(int bank_account_id) {
		
		return bad.deleteBankAccount(bank_account_id);
	}
	
	/**
	 * allBankAccounts method
	 * Returns a list of all bank accounts associated with a user
	 * @param user_id The ID of the User for which the bank accounts will be returned
	 */
	public static List<BankAccount> allBankAccounts(int user_id) {
		
		return bad.allBankAccounts(user_id);
	}
}
