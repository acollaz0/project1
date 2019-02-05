package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import util.JDBCConnection;

public class AccountDao {
	
	public void getAccounts(int u_id) {
		try {
			String sql = "select acc_num , amount FROM accounts WHERE u_id = ?";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(u_id));
			
			ResultSet rs = ps.executeQuery();
			System.out.println("Account Number \t|\tAmount");
			System.out.println("--------------------------------------------------");
			while(rs.next()) {
				
				//passing the results of the query into a constructor to make a account object
				System.out.println(rs.getInt("acc_num")+"\t\t\t|\t"+rs.getDouble("amount")+"J");	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean withdraw(int accnum, double amount) {
		try {
		String sql = "select amount from accounts where acc_num = ?";
		PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
		
		ps.setString(1, Integer.toString(accnum));
		double amt=0;
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			amt = rs.getDouble("amount");
		}
		amt=amt-amount;
		
		sql = "call withdraw(?,?,?)";
			//Connection conn = JDBCConnection.getConnection();
			ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, Integer.toString(accnum));
			ps.setString(2, Double.toString(amount));
			ps.setString(3, Double.toString(amt));
			
			ps.executeQuery();
			//while(rs.next()) {
				
				//passing the results of the query into a constructor to make a account object
				System.out.println("You have successfully withdrawn");
				return true;
			//}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
	public boolean deposit(int accnum, double amount) {
		try {
			String sql = "select amount from accounts where acc_num = ?";
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, Integer.toString(accnum));
			
			double amt=0;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				amt = rs.getDouble("amount");
			}
			amt=amt+amount;
			
			sql = "call deposit(?,?,?)";
				//Connection conn = JDBCConnection.getConnection();
				ps = JDBCConnection.getConnection().prepareStatement(sql);
				
				ps.setString(1, Integer.toString(accnum));
				ps.setString(2, Double.toString(amount));
				ps.setString(3, Double.toString(amt));
				
				ps.executeQuery();
				//while(rs.next()) {
					
					//passing the results of the query into a constructor to make a account object
					System.out.println("You have successfully desposited");
					return true;
				//}
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		return false;
	}
	public boolean deleteAccount(int accnum) {
		try {
			String sql = "call delete_account( ? )";
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, Integer.toString(accnum));
			ps.executeQuery();
			//passing the results of the query into a constructor to make a account object
				System.out.println("Account has been closed");
				return true;
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		return false;
	}
	public boolean createAccount(User u) {
		try {
			String sql = "call new_account( ? )";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(u.getU_id()));
			
			ps.executeQuery();
			return true;			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public double getAmount(int accnum) {
		try {
			String sql = "select amount FROM accounts WHERE acc_num = ?";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(accnum));
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				//passing the results of the query into a constructor to make a account object
				return rs.getDouble("amount");	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
