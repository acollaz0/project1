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
			String sql = "CALL add_user(?, ?, ?, ?, ?)";
			Connection conn = JDBCConnection.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getF_name());
			cs.setString(4, u.getL_name());
			cs.setString(5, u.getUser_type());
			
			// execute the query
			cs.executeQuery();
			
			return true;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * updateLoyaltyPoints method
	 * Updates a User's loyalty points in the database
	 * @param The User to update
	 * @return true if a User was actually updated, else false
	 */
	public boolean updateLoyaltyPoints(User u) {
		
		try {
			// prepare an SQL statement
			String sql = "UPDATE proj1_user SET loyalty_points = ? WHERE user_id = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, Integer.toString(u.getLoyalty_points()));
            ps.setString(2, Integer.toString(u.getUser_id()));
            
            // get the result set from the query
            ResultSet rs = ps.executeQuery();
            
            // return true if at least one row was updated, else false
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
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
            String sql = "DELETE FROM proj1_user WHERE user_id = ?";
            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, Integer.toString(user_id));
            
            // get the result set
            ResultSet rs = ps.executeQuery();
            
            // return true if the user was deleted, else false
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
	}

}
