package dao;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.User;
import util.JDBCConnection;

public class UserDAO implements IUser {

	public User getUser(String username) {
		String sql = "select * from bankuser where username = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new User(
						rs.getInt("B_ID"),
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getInt("SUPER"));
			}
			
		}catch(SQLException e){
			System.out.println("User does not exist");
			
		}
		return null;
	}

	public boolean addUser(User u) {
		String sql = "call add_user(?, ?, ?)";
		try {
			CallableStatement cs = JDBCConnection.getConnection().prepareCall(sql);
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, Integer.toString(u.isSuper()));
			
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			if(e.getMessage().contains("unique constraint")) {
				System.out.println("Username is unavailable");
			}
			else
				e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int b_id) {
		String sql = "delete bankuser where b_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(b_id));
			ResultSet rs = ps.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			System.out.println("Invalid Username");
		}
		return false;
	}

	public boolean updateUserPass(int b_id, String password) {
		
		String sql = "update bankuser set password = ? where b_id = ?";
		try {
			
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, Integer.toString(b_id));
			ResultSet rs = ps.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			System.out.println("Invalid password");
		}
		
		
		return false;
	}
	
	public boolean updateUserName(int b_id, String username) {
		String sql = "update bankuser set username = ? where b_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, Integer.toString(b_id));
			ResultSet rs = ps.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			System.out.println("Username is unavailable");
		}
		
		
		return false;
	}
	public List<User> allUsers() {
		String sql = "select * from bankuser";
		List<User> users = new ArrayList<>();
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
		
				users.add( new User(
						rs.getInt("B_ID"),
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getInt("SUPER")));
			}
			return users;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
