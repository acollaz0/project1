package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.JDBCConnection;

public class UserDAO implements IUser {
	
	/**
	 * getUser method
	 * Returns a User from the database if the given username is found
	 * @param username The username of the user you want to retrieve from the database
	 * @return A User if the given username is found, else null
	 */
	@Override
	public User getUser(String username) {
		try {
			// prepare an SQL statement
			String sql = "SELECT * FROM proj1_user WHERE username = ?";
			
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			// Get the results of the SQL statement
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				// pass in the results of the query into a constructor to make a user object
				// and return it
				return new User(
						rs.getInt("user_id"), 
						rs.getString("username"), 
						rs.getString("password"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("user_type"),
						rs.getInt("loyalty_points")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * addUser method
	 * Adds a User to the database
	 * @param The User to add to the database
	 * @return true if the User was successfully added, else false
	 */
	@Override
	public boolean addUser(User u) {
		try {
			// prepare an SQL procedure call
			String sql = "CALL add_user(?, ?, ?, ?, ?, ?)";
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getF_name());
			cs.setString(4, u.getL_name());
			cs.setString(5, u.getUser_type());
			cs.setString(6, Integer.toString(u.getLoyalty_points()));
			
			// execute the query
			cs.executeQuery();
			
			return true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
