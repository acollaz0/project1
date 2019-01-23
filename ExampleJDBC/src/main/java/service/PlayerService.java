package service;

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
}
