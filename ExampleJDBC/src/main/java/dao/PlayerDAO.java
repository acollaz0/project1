package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Player;
import util.JDBCConnection;

public class PlayerDAO implements IPlayer{

	public Player getPlayer(int p_id) {
		String sql = "SELECT * FROM player WHERE p_id = ?";

		try {
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
		String sql = "INSERT INTO player VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			//INSERT INTO player VALUES (776, 'Meng Hao', 999999, 959, 'Mutton Chop Mountaineers');
			
			ps.setInt(1, p.getP_id());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getSalary());
			ps.setInt(4, p.getPoints());
			ps.setString(5, p.getTeam());
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deletePlayer(int p_id) {

		return false;
	}

	public List<Player> getPlayers() {

		return null;
	}
	
}
