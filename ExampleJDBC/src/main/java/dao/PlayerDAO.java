package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import util.JDBCConnection;

public class PlayerDAO implements IPlayer{

	public Player getPlayer(int p_id) {

		try {
			String sql = "SELECT * FROM player WHERE p_id = ?";
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(p_id));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//passing in query results to make
				//a new player object
				
				return new Player(rs.getInt("P_ID"), 
						rs.getString("name"), 
						rs.getInt("salary"), 
						rs.getInt("points"), 
						rs.getString("TEAM"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addPlayer(Player p) {
		try {
			Connection conn = JDBCConnection.getConnection();
			String sql = "call add_player(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, p.getName());
			cs.setInt(2, p.getSalary());
			cs.setString(3, p.getTeam());
			
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deletePlayer(int p_id) {
		try {
			String sql = "DELETE FROM player WHERE p_id = ?";
			Connection conn = JDBCConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(p_id));
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Player> getPlayers() {
		String sql = "SELECT * FROM player";
		List<Player> players = new ArrayList<Player>();
		try {
			
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				players.add( new Player(
						rs.getInt("p_id"),
						rs.getString("name"),
						rs.getInt("salary"),
						0,
						rs.getString("team")
						));
			}
			return players;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
