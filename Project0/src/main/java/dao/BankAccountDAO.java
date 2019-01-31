package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BankAccount;
import model.User;
import util.JDBCConnection;

public class BankAccountDAO implements IBankAccount {
	
	/**
	 * addBankAccount method
	 * Adds a bank account for a given user
	 * @param user_id The ID of the User which will get a new account
	 * @param ba The BankAccount to add for this user
	 * @return true if the bank account was successfully added, else false
	 */
	public boolean addBankAccount(int user_id, BankAccount ba) {
		
		try {
			// prepare an SQL procedure
			String sql = "call add_bank_account(?, ?, ?)";
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(user_id));
			cs.setString(2, Double.toString(ba.getBalance()));
			cs.setString(3, ba.getType());
			
			// execute the procedure
			cs.executeQuery();
			
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * updateBankAccount method
	 * Updates a given bank account
	 * @param ba The BankAccount to update, with its updated fields
	 * @return true if the BankAccount was actually updated, else false
	 */
	public boolean updateBankAccount(BankAccount ba) {
		
		try {
			// prepare an SQL statement
            String sql = "UPDATE bank_account SET balance = ? WHERE bank_account_id = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, Double.toString(ba.getBalance()));
            ps.setString(2, Integer.toString(ba.getBank_account_id()));
            
            // get the result set
            ResultSet rs = ps.executeQuery();
            
            // return true if at least one row was updated, else false
            return rs.next();
            
        } catch (SQLException e) {
//            e.printStackTrace();
        }
		
		return false;
	}
	
	/**
	 * deleteBankAccount method
	 * Deletes a BankAccount from the database
	 * @param bank_account_id The ID of the BankAccount to delete
	 * @return true if the account was actually deleted, else false
	 */
	public boolean deleteBankAccount(int bank_account_id) {
		
		try {
			// prepare an SQL statement
            String sql = "DELETE FROM bank_account WHERE bank_account_id = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, Integer.toString(bank_account_id));
            
            // get the result set
            ResultSet rs = ps.executeQuery();
            
            // return true if the bank account was deleted, else false
            return rs.next();
            
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        
        return false;
	}

	/**
	 * allBankAccounts method
	 * Returns a list of all bank accounts associated with a user
	 * @param user_id The ID of the User for which the bank accounts will be returned
	 */
	public List<BankAccount> allBankAccounts(int user_id) {
		
		List<BankAccount> accounts = new ArrayList<BankAccount>();
        try {
        	// prepare an SQL statement
        	String sql = "SELECT * FROM bank_account WHERE user_id = ? ORDER BY bank_account_id";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(user_id));
            
			// get the result set
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				
				// pass in the results of the query into a constructor to make a bank account object
            	// then add the bank account to the bank account list
            	accounts.add(new BankAccount(
            		rs.getInt("bank_account_id"),
					rs.getDouble("balance"),
					rs.getString("account_type")
					));
			}
            
            return accounts;
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}

	

}
