package db;

import java.util.HashMap;
import java.util.Map;
import model.Player;

public class FakeDB {
	
	public static Map<Integer,Player> league = new HashMap<Integer,Player>();
	
	// static block is code that executes the very first time a class is loaded
	// the first time a class is called/referenced
	static {
		Player p1 = new Player(101,"Mean Mike","The Gators");
		Player p2 = new Player(102,"Jump Jackson","Da Bears");
		Player p3 = new Player(103,"Shady Sam","The Cheatriots");
		league.put(101, p1);
		league.put(102, p2);
		league.put(103, p3);
	}

}
