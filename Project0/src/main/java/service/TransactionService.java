package service;

import java.util.List;

import dao.TransactionDAO;
import model.Transaction;

public class TransactionService {

	public static TransactionDAO td = new TransactionDAO();
	
	public static List<Transaction> getTransactions(int a_id){
		return td.getTransactions(a_id);
	}
	
}
