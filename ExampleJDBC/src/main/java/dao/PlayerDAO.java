package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Player;
import util.JDBCConnection;

//Want to create 1 dao class for each table in your database
public class PlayerDAO implements IPlayer {

	private static Connection con = JDBCConnection.getConnection();
	
	public Player getPlayer(int p_id) {
		
		
		
		String sql = "select * from player "
				+ "where p_id=?";//Use question mark to protect us from sql injection
		
		try {
			PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
			ps.setString(1, Integer.toString(p_id)); //1 is the index of the first question mark
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				return new Player(
						rs.getInt("P_ID"),
						rs.getString("P_NAME"),
						rs.getInt("points"),
						rs.getInt("salary"),
						rs.getString("team")
						);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean addPlayer(Player p) {
		
		//if (hasKey(p)) {return false;}
		
		String sql = "call add_player(?,?,?)";
		
		try {
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setString(1, p.getName());
			cs.setString(2, Integer.toString(p.getSalary()));
			cs.setString(3, p.getTeam());
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean deletePlayer(int p_id) {
		return false;
	}

	public List<Player> allPlayers() {
		return null;
	}

}
