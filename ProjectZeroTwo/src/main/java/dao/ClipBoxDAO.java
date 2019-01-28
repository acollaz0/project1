package dao;

import java.sql.CallableStatement;
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

public class ClipBoxDAO implements IClipBoxDAO {
	
	private static Connection con = JDBCLink.getConnection();
	private static UserDAO udao = new UserDAO();
	private static ITransactionDAO tdao = new TransactionDAO();

	public ClipBox getClipBox(int boxID) {
		
		
		
		return null;
	}

	public ClipBox addClipBox(User user) {
		return addClipBox(user,"-");
	}
	
	public ClipBox addClipBox(User user, String description) {
		
		String sql = "call add_box(?,?,?)";
		
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, user.getUsername());
			cs.setString(2, description);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.execute();
			return getClipBox(cs.getString(3));
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteClipBox(ClipBox box) {
		
		String sql = "delete from clipbox where boxid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, box.getCb_id());
			
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
	}

	public List<ClipBox> getClipBoxes() {
		List<ClipBox> boxes = new ArrayList<>();
		
		String sql = "select boxid from clipbox order by lower(username) asc";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				boxes.add(getClipBox(rs.getString(1)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return boxes;
	}

	public List<ClipBox> getClipBoxes(User user) {
		
		List<ClipBox> boxes = new ArrayList<>();
		
		String sql = "select boxid from clipbox where username=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				boxes.add(getClipBox(rs.getString(1)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return boxes;
	}

	public boolean isExtantClipBox(String boxID) {
		
		String sql = "select count(*) from clipbox where boxid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, boxID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1)>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getBalance(String boxID) {
		
		if (!isExtantClipBox(boxID)) {
			return -1;
		}
		
		String sql = "select balance from clipbox where boxid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, boxID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public ClipBox getClipBox(String boxID) {
		
		String sql = "select * from clipbox where boxid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, boxID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new ClipBox(
					udao.getUser(rs.getString("USERNAME")),
					rs.getInt("BALANCE"),
					boxID,
					rs.getString("DESCRIPTION")
					);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Transaction makeTransaction(String boxID, int value) {
		
		String sql = "call add_trans(?,?,?)";
		
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, boxID);
			cs.setInt(2, value);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			
			cs.executeUpdate();
			
			String t_id = cs.getString(3);
			return tdao.getTransaction(t_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
