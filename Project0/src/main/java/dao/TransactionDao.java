package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Transaction;
import util.JDBCConnection;

public class TransactionDao implements ITransaction {
	
	public Transaction getTransaction(int accnum) {
		try {
			String sql = "select mag , t_amount FROM transactions WHERE acc_num = ?";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(accnum));
			
			ResultSet rs = ps.executeQuery();
			System.out.println("Amount");
			System.out.println("--------------------------------------------------");
			while(rs.next()) {
				
				//passing the results of the query into a constructor to make a account object
				System.out.println(rs.getString("mag")+rs.getDouble("t_amount"));	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
