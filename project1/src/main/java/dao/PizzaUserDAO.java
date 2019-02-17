package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PizzaUser;
import util.JDBCConnection;

public class PizzaUserDAO implements IPizzaUser{

	@Override
	public PizzaUser getPizzaUser(String username) {
		String sql = "select * from pizza_user where username = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			PizzaUser p = null;
			while(rs.next()) {
						p = new PizzaUser(
						rs.getInt("U_ID"),
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getInt("REWARDS"),
						rs.getInt("EMPLOYEE"));
			}
			ps.close();
			rs.close();
			return p;
			
		}catch(SQLException e){
			System.out.println("User does not exist");
			
		}
		return null;
	}

	@Override
	public boolean addPizzaUser(PizzaUser u) {
		String sql = "call add_pizzauser(?, ?, ?, ?)";
		try {
			CallableStatement cs = JDBCConnection.getConnection().prepareCall(sql);
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, Integer.toString(u.getRewards()));
			cs.setString(4, Integer.toString(u.getEmployee()));
			
			cs.execute();
			cs.close();
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

	@Override
	public boolean updateRewards(int u_id, int rewards) {
		String sql = "update pizza_user set rewards = rewards + ? where u_id = ?";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(rewards));
			ps.setString(2, Integer.toString(u_id));
			ps.executeQuery();
			ps.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insufficient Funds");
		}
		return false;
	}

}
