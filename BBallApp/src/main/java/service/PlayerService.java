package service;

import db.FakeDB;
import model.Player;

public class PlayerService {
	
	
	public static Player getPlayer(int id) {
		
		Player p = FakeDB.league.get(id);
		return p;
		
	}
	
	public static void addPlayer(Player p) {
		FakeDB.league.put(p.getId(), p);
	}

}
