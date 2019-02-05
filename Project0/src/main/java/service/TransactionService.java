package service;


import dao.TransactionDao;
import model.Transaction;

public class TransactionService {

	public static TransactionDao td = new TransactionDao();
	
	public static Transaction getTransaction(int accnum) {
		return td.getTransaction(accnum);
	}
}
