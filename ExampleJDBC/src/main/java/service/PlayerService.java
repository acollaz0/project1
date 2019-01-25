package service;

import dao.PlayerDAO;
import model.Player;

public class PlayerService {
	
	public static Player getPlayer(int p_id) {
		Player p = new PlayerDAO().getPlayer(p_id);
		
		
		return p;
	}
	public static boolean addPlayer(Player p) {
		return new PlayerDAO().addPlayer(p);

	}

}
