package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.JDBCConnection;

public class UserDao implements IUser{

	public User getUser(String username, String password) {
		String sql = "select * from users where username = ?AND password = ?";//
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
			while(rs.next()) {
				//passing the results of the query into a constructor to make a user object
			return new User(rs.getInt("UID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getInt("rewards")
					);		
			}
			}

		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	public User addUser(String username, String password) {
		String sql = "call add_user( ? , ? )";//
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1,username);
			ps.setString(2, password);
			ps.executeQuery();
			sql = "select * from users where username = ? AND password = ?";//
			ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//passing the results of the query into a constructor to make a user object
				
			return new User(rs.getInt("U_ID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getInt("rewards")
					);	
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
