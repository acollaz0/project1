package PlayerDAOTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import service.PlayerService;

public class PlayerDAOTesting {

	@Test
	public void add_Player() {
		Player p = new Player(10,"brandon",0,0,"asdf");
		PlayerService.addPlayer(p);
		assert(true);
	}

}
