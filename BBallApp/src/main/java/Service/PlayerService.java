package Service;

import db.FakeDB;
import model.Player;

public class PlayerService {
	public static Player getPlayer(int id) {
		return FakeDB.league.get(id);
	}
	public static void addPlayer(Player p) {
		FakeDB.league.put(p.getId(), p);
	}
}
