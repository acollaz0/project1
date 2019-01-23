package service;

import java.util.List;

import dao.PlayerDAO;
import model.Player;

public class PlayerService {
	
	public static PlayerDAO pd = new PlayerDAO();
	
	public static Player getPlayer(int p_id) {
		
		Player p = pd.getPlayer(p_id);
		return p;	
		
	}
	
	public static boolean addPlayer(Player p) {
		
		return pd.addPlayer(p);
		
	}
	
	public static List<Player> allPlayers(){
		
		return pd.allPlayers();
		
	}
	public static boolean deletePlayer(int p_id) {
		
		return pd.deletePlayer(p_id);
	}
	

}
