package dao;

import java.util.List;

import models.Transaction;
import models.User;

public interface ITransactionDAO {
	
	public Transaction getTransaction(String t_id);
	public List<Transaction> getTransactions();
	public List<Transaction> getTransactions(User user);
	//public boolean addTransaction(Transaction t);

}
