package db;

import java.util.HashMap;
import java.util.Map;

import model.Player;

public class FakeDB {
	
	public static Map<Integer,Player> league = new HashMap<Integer,Player>();
	
	//Static block is code that executes the very first time a class is loaded
	// aka: The first time a class is called/referenced
	static {
		Player p1 = new Player(101,"Mean Mike","The Gators");
		Player p2 = new Player(67,"Jump Jackson","Da Bears");
		Player p3 = new Player(102,"Shady Sam","The Patriots");
		league.put(101, p1);
		league.put(67, p2);
		league.put(102,p3);
	}
	
}
