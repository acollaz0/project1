package service;

import db.FakeDB;
import model.Player;

public class PlayerService {
	public static Player getPlayer(int id) {
		Player p = FakeDB.league.get(id);
		System.out.println(FakeDB.league);
		return p;
	}
	public static void addPlayer(Player p) {
		FakeDB.league.put(p.getId(),p);
	}
}
