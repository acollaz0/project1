package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Transaction;
import util.JDBCConnection;

public class TransactionDAO implements ITransaction {

	@Override
	public List<Transaction> getTransactions(int a_id) {
		String sql = "select * from transaction where a_id = ? order by datetime desc";
		List<Transaction> transactions = new ArrayList<>();
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(a_id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
		
				transactions.add( new Transaction(
						rs.getInt("T_ID"),
						rs.getString("CHANGE"),
						rs.getInt("TOTAL"),
						rs.getString("DATETIME"),
						rs.getInt("A_ID")));
			}
			return transactions;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}

}
