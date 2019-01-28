package dao;

import static org.junit.Assert.assertArrayEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.JDBCLink;
import models.ClipBox;
import models.Transaction;
import models.User;

public class TransactionDAO implements ITransactionDAO {
	
	private static Connection con = JDBCLink.getConnection();

	public List<Transaction> getTransactions() {
		return null;
	}

	public List<Transaction> getTransactions(User user) {
		ClipBoxDAO cbdao = new ClipBoxDAO();
		
		List<ClipBox> boxes = cbdao.getClipBoxes(user);
		List<Transaction> transactions = new ArrayList<Transaction>();
		for (ClipBox b : boxes) {
			
			String sql = "select t_id from trans where boxid=? order by t_date";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, b.getCb_id());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					transactions.add(getTransaction(rs.getString("T_ID")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		return transactions;
	}

//	public boolean addTransaction(Transaction t) {
//		return false;
//	}

	public Transaction getTransaction(String t_id) {
		
		String sql = "select * from trans where t_id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t_id);
			ResultSet rs = ps.executeQuery();
//			System.out.println(t_id);
			rs.next();
			IClipBoxDAO cbdao = new ClipBoxDAO();
			ClipBox box = cbdao.getClipBox(rs.getString("BOXID"));
			return new Transaction(box,t_id, rs.getInt("T_VALUE"), rs.getInt("FINALBALANCE"), rs.getDate("T_DATE"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
