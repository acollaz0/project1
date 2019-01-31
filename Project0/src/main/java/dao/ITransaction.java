package dao;

import java.util.List;

import model.Transaction;

// interface for TransactionDAO methods
public interface ITransaction {
	
	public boolean addTransaction(int bank_account_id, Transaction t);
	public List<Transaction> allTransactions(int bank_account_id);
}
