package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.JDBCLink;
import models.User;

public class UserDAO implements IUserDAO {
	
	private static Connection con = JDBCLink.getConnection();
	
	@Override
	public boolean addUser(User user) {
		
		if (isExtantUser(user.getUsername())) {
			System.out.println("* Tried to add a user who already exists *");
			return false;
		}
		
		String sql = "INSERT INTO BANKUSER (USRNAME, PASS) "
				+ "VALUES (?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			//System.out.println(rs);
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean validateUser(User user) {
		
		return validateUser(user.getUsername(),user.getPassword());
	}
	@Override
	public boolean validateUser(String username, String password) {
		
		if (!isExtantUser(username)) {
			return false;
		}
		
		String sql = "select count(*) from bankuser where usrname=? and pass=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1)==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

//	public boolean validateSuperUser(User user) {
//		return false;
//	}
//
	@Override
	public boolean isSuperUser(String username) {
		if (!isExtantUser(username)) {
			return false;
		}
		
		String sql = "select issuper from bankuser where usrname=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int issuper = rs.getInt(1);
			System.out.println(issuper);
			return issuper==1;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isExtantUser(String user) {
		
		String sql = "select count(*) from bankuser where usrname=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1)==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User getUser(String user) {
		
		if (!isExtantUser(user)) {
			return null;
		}
		
		String sql = "select pass, issuper from bankuser where usrname=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new User(user, rs.getString("PASS"), rs.getInt("ISSUPER")==1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> users = new ArrayList<>();
		
		String sql = "select * from bankuser order by lower(usrname) asc";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				users.add(new User(
						rs.getString("USRNAME"),
						rs.getString("PASS"),
						rs.getInt("ISSUPER")==1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return users;
	}
	@Override
	public boolean deleteUser(User user) {
		
		String sql = "delete from bankuser where usrname=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean editUserInfo(User user, String n_username, String n_password) {
		
		String sql = "update bankuser set usrname=?,pass=? where usrname=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, n_username);
			ps.setString(2, n_password);
			ps.setString(3, user.getUsername());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
