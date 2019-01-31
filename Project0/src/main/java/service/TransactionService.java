package service;

import java.util.List;

import dao.TransactionDAO;
import model.Transaction;

public class TransactionService {
	
	private static TransactionDAO ta = new TransactionDAO();
	
	/**
	 * addTransaction
	 * Adds a transaction to a specified bank account
	 * @param bank_account_id The ID of the bank account that will have a new transaction
	 * @param t A transaction
	 * @return true if the transaction was successfully added, else false
	 */
	public static boolean addTransaction(int bank_account_id, Transaction t) {
		
		return ta.addTransaction(bank_account_id, t);
	}
	
	/**
	 * allTransactions method
	 * @param bank_account_id The ID of the bank account in which you want to get all transactions for
	 * @return A list of all transactions for this bank account
	 */
	public static List<Transaction> allTransactions(int bank_account_id) {
		
		return ta.allTransactions(bank_account_id);
	}
}
