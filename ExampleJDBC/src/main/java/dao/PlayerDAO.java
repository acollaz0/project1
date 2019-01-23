package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import util.JDBCConnection;

public class PlayerDAO implements IPlayer{

	public Player getPlayer(int p_id) {
			
		try {
			
			String sql = "select * from player where p_id = ?";	
			Connection conn = JDBCConnection.getConnection();		
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setString(1, Integer.toString(p_id));		
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				
				// passing in the results of the query into a constructor to make a
				// player object
				return new Player(
						rs.getInt("P_ID"), 
						rs.getString("NAME"), 
						rs.getInt("Salary"), 
						rs.getInt("Points"),
						rs.getString("team")
						);			
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addPlayer(Player p) {
		
	 try
    {
        String sql = "INSERT INTO player VALUES (?,?,?,?,?)";
        PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
        ps.setString(1, Integer.toString(p.getP_id()));
        ps.setString(2, p.getName());
        ps.setString(3, Integer.toString(p.getSalary()));
        ps.setString(4, Integer.toString(p.getPoints()));
        ps.setString(5, p.getTeam());
        
        ps.executeQuery();
        return true;
    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    return false;
	}

	public boolean deletePlayer(int p_id) {
		 try {
	            String sql = "delete from player where p_id = ?";
	            Connection conn = JDBCConnection.getConnection();
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, Integer.toString(p_id));
	            
	            
	            ResultSet rs = ps.executeQuery();
	            return true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return false;
	}

	public List<Player> allPlayers() {
		String sql = "select * from player";
        List<Player> players = new ArrayList<Player>();
        try {
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                //passing in the results of the query into a constructor to make
                //a player object
                players.add( new Player(
                        rs.getInt("P_ID"),
                        rs.getString("NAME"),
                        rs.getInt("SALARY"),
                        rs.getInt("POINTS"),
                        rs.getString("TEAM")
                        ));
            }
            return players;
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
	}

}
