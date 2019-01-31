package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BankAccount;
import model.User;
import util.JDBCConnection;

public class UserDAO implements IUser {

	/**
	 * getUser method
	 * Returns a User from the database if the given username is found
	 * @param username The username of the user you want to retrieve from the database
	 * @return A User if the given username is found, else null
	 */
	public User getUser(String username) {
		
		try {
			// prepare an SQL statement
			String sql = "SELECT * FROM a_user WHERE username = ?";
			
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
						rs.getString("user_type")
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
	public boolean addUser(User u) {

		try {
			// prepare an SQL procedure call
			String sql = "CALL add_user(?, ?, ?, ?, ?)";
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getF_name());
			cs.setString(4, u.getL_name());
			cs.setString(5, u.getType());
			
			// execute the query
			cs.executeQuery();
			
			return true;
			
		} 
		catch (SQLException e) {
//			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * updateUser method
	 * Updates a User in the database
	 * @param The User to update
	 * @return true if a User was actually updated, else false
	 */
	public boolean updateUser(User u) {
		
		try {
			// prepare an SQL statement
			String sql = "UPDATE a_user SET username = ?, password = ?,"
					+ "f_name = ?, l_name = ? WHERE user_id = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getF_name());
            ps.setString(4, u.getL_name());
            ps.setString(5, Integer.toString(u.getUser_id()));
            
            // get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            // return true if at least one row was updated, else false
            return rs.next();
            
        } catch (SQLException e) {
//            e.printStackTrace();
        }
		
		return false;
	}
	
	/**
	 * deleteUser method
	 * Deletes a user from the database
	 * @param The user id for the User you want to delete
	 * @return true if a User was actually deleted, else false
	 */
	public boolean deleteUser(int user_id) {
		
		try {
			// prepare an SQL statement
            String sql = "DELETE FROM a_user WHERE user_id = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, Integer.toString(user_id));
            
            // get the result set
            ResultSet rs = ps.executeQuery();
            
            // return true if the user was deleted, else false
            return rs.next();
            
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        
        return false;
	}

	/**
	 * allUsers method
	 * @return The list of all users in the database
	 */
	public List<User> allUsers() {
		
        List<User> users = new ArrayList<User>();
        try {
        	// prepare an SQL statement
        	String sql = "SELECT * FROM a_user ORDER BY user_id";
			Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
            
			// get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				
				// pass in the results of the query into a constructor to make a user object
            	// then add the user to the users list
            	users.add(new User(
					rs.getInt("user_id"), 
					rs.getString("username"), 
					rs.getString("password"),
					rs.getString("f_name"),
					rs.getString("l_name"),
					rs.getString("user_type")
					));
			}
            
            return users;
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}

}
