package dao;

import java.util.List;

import model.Transaction;

public interface ITransaction {
	
	public List<Transaction> getTransactions(int a_id);

}
