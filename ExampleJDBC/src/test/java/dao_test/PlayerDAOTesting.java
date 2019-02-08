package dao_test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import service.PlayerService;

public class PlayerDAOTesting {

	@Test
	public void addPlayer() {
		Player p = new Player(9,"adam", 9000, 2100, "Muttonchop Mountaineers");
		assertTrue(PlayerService.addPlayer(p));
	}

}
