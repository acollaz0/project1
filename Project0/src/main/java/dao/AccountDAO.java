package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
						rs.getString("TYPE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		String sql = "insert into bankaccount values(?, ?, ?)";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(a.getA_id()));
			ps.setString(2, Integer.toString(a.getAmount()));
			ps.setString(3, a.getType());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(int a_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account> allAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}
