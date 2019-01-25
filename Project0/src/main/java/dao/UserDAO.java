package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.User;
import util.JDBCConnection;

public class UserDAO implements IUser {

	@Override
	public User getUser(int u_id) {
		String sql = "select * from bankuser where u_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(u_id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new User(
						rs.getInt("U_ID"),
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getBoolean("ADMIN"));
			}
			
		}catch(SQLException e){
			
			
		}
		return null;
	}

	@Override
	public boolean addUser(User u) {
		String sql = "insert into bankuser values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(u.getU_id()));
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, Boolean.toString(u.isSuper()));
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int u_id) {
		String sql = "delete bankuser where u_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(u_id));
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> allUsers() {
		String sql = "select * from player";
		List<User> users = new ArrayList<>();
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
		
				users.add( new User(
						rs.getInt("U_ID"),
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getBoolean("ADMIN")));
			}
			return users;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
