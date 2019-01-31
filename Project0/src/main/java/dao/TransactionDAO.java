package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BankAccount;
import model.Transaction;
import util.JDBCConnection;

public class TransactionDAO implements ITransaction {

	/**
	 * addTransaction
	 * Adds a transaction to a specified bank account
	 * @param bank_account_id The ID of the bank account that will have a new transaction
	 * @param t A transaction
	 * @return true if the transaction was successfully added, else false
	 */
	public boolean addTransaction(int bank_account_id, Transaction t) {
		
		try {
			// prepare an SQL procedure
			String sql = "call add_transaction(?, ?, ?)";
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(bank_account_id));
			cs.setString(2, Double.toString(t.getBalance_before()));
			cs.setString(3, Double.toString(t.getBalance_after()));
			
			// execute the procedure
			cs.executeQuery();
			
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * allTransactions method
	 * @param bank_account_id The ID of the bank account in which you want to get all transactions for
	 * @return A list of all transactions for this bank account
	 */
	public List<Transaction> allTransactions(int bank_account_id) {
		
		List<Transaction> transactions = new ArrayList<Transaction>();
        try {
        	// prepare an SQL statement
        	String sql = "SELECT * FROM transaction WHERE bank_account_id = ? ORDER BY transaction_id";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(bank_account_id));
            
			// get the result set
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				
				// pass in the results of the query into a constructor to make a transaction object
            	// then add the transaction to the transactions list
            	transactions.add(new Transaction(
            		rs.getInt("transaction_id"),
					rs.getDouble("balance_before"),
					rs.getDouble("balance_after")
					));
			}
            
            return transactions;
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return null;
	}

}
