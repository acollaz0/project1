package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import util.JDBCConnection;

public class AccountDAO implements IAccount {

	@Override
	public Account getAccount(int a_id) {
		String sql = "select * from bankaccount where a_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(a_id));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new Account(
						rs.getInt("A_ID"),
						rs.getInt("AMOUNT"),
						rs.getString("TYPE"),
						rs.getInt("B_ID"));
			}
		} catch (SQLException e) {
			System.out.println("Invalid Account ID");
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		String sql = "call add_account(?, ?, ?)";
		try {
			CallableStatement cs = JDBCConnection.getConnection().prepareCall(sql);
			cs.setString(1, Integer.toString(a.getAmount()));
			cs.setString(2, a.getType());
			cs.setString(3, Integer.toString(a.getB_id()));
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(int a_id) {
		String sql = "delete bankaccount where a_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(a_id));
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			System.out.println("Invalid Account ID");
		}
		return false;
		
	}

	@Override
	public List<Account> allAccounts(int b_id) {
		String sql = "select * from bankaccount where b_id = ?";
		List<Account> accounts = new ArrayList<>();
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(b_id));
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
		
				accounts.add( new Account(
						rs.getInt("A_ID"),
						rs.getInt("AMOUNT"),
						rs.getString("TYPE"),
						rs.getInt("B_ID")));
			}
			return accounts;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean withdraw(int a_id, int amount) {
		String sql = "update bankaccount set amount = amount - ? where a_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(amount));
			ps.setString(2, Integer.toString(a_id));
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			System.out.println("Insufficient Funds");
		}
		return false;
	}

	@Override
	public boolean deposit(int a_id, int amount) {
		String sql = "update bankaccount set amount = amount + ? where a_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(amount));
			ps.setString(2, Integer.toString(a_id));
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean withdrawAll(int a_id) {
		String sql = "update bankaccount set amount = 0 where a_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(a_id));
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
