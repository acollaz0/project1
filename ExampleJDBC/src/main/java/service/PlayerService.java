package service;

import dao.IPlayer;
import dao.PlayerDAO;
import model.Player;

public class PlayerService {
	
	private static IPlayer dao = new PlayerDAO();
	
	public static Player getPlayer(int p_id) {
		
		Player player = dao.getPlayer(p_id);
		return player;
	}
	
	public static boolean addPlayer(Player p) {
		return dao.addPlayer(p);
	}
	
	public static boolean removePlayer(Player p) {
		return dao.deletePlayer(p.getP_id());
	}

}
