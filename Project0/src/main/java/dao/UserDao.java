package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import util.JDBCConnection;

public class UserDao implements IUser {
	
	public User getUser(String username,String password) {
		String sql = "select * from users where username = ?AND password = ?";//
		try {
			
			//Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
			while(rs.next()) {
				//passing the results of the query into a constructor to make a user object
			return new User(rs.getInt("U_ID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getString("FIRST"),
					rs.getString("LAST")
					);		
			}
			}

		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}

	public User addUser(User u) {
		String sql = "call add_user( ? , ? , ? , ? )";//
		try {
			
			//Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1,u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3,u.getFirst());
			ps.setString(4, u.getLast());
			
			ps.executeQuery();
			//System.out.println(rs.getInt("u_id"));
			sql = "select * from users where username = ? AND password = ?";//
			ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//passing the results of the query into a constructor to make a user object
				
			return new User(rs.getInt("U_ID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getString("FIRST"),
					rs.getString("LAST")
					);	
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	public User addSuperUser(User u) {
		String sql = "call add_super( ? , ? , ? , ? )";//
		try {
			
			//Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1,u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3,u.getFirst());
			ps.setString(4, u.getLast());
			
			ps.executeQuery();
			//System.out.println(rs.getInt("u_id"));
			sql = "select * from users where username = ? AND password = ?";//
			ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//passing the results of the query into a constructor to make a user object
				
			return new User(rs.getInt("U_ID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getString("FIRST"),
					rs.getString("LAST")
					);	
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}

	public boolean deleteUser(int uid) {
		String sql = "delete from users where u_id = ?";//
		try {
			
			//Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(uid));
			ps.executeQuery();
			
			sql = "delete from accounts where u_id = ?";
			ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(uid));
			ps.executeQuery();

		}catch(SQLException e) {
			e.printStackTrace();
			
		}		
		return false;
	}
	public boolean getAll() {
		String sql = "select * from users";//
		try {
			
			//Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				System.out.println("User ID\t\tUsername\tPassword\tFirst name\tLast name");
			while(rs.next()) {
				//passing the results of the query into a constructor to make a user object
			System.out.println(rs.getInt("U_ID")+"\t\t"+rs.getString("USERNAME")+"\t\t"+
				rs.getString("PASSWORD")+"\t\t"+rs.getString("FIRST")+"\t\t"+rs.getString("LAST"));		
			}
			return true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
			
		}		
		return false;
	}
	public boolean updateUser(User u) {
		String sql = "update users set username = ? , password = ? , first = ? , last = ? where u_id = ?";//
		try {
			
			//Connection conn = JDBCConnection.getConnection();
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1,u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3,u.getFirst());
			ps.setString(4, u.getLast());
			ps.setString(5, Integer.toString(u.getU_id()));
			
			ps.executeQuery();
			sql = "select * from users where username = ? AND password = ?";
			ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				System.out.println("User ID\t\tUsername\tPassword\tFirst name\tLast name");
			while(rs.next()) {
				//passing the results of the query into a constructor to make a user object
			System.out.println(rs.getInt("U_ID")+"\t\t"+rs.getString("USERNAME")+"\t\t"+
				rs.getString("PASSWORD")+"\t\t"+rs.getString("FIRST")+"\t\t"+rs.getString("LAST"));		
			}
			}
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
		}	
		
		return false;
	}

}
