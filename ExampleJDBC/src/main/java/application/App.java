package application;

import model.Player;
import service.PlayerService;

public class App {
	
	public static void main(String[] args) {
		System.out.println("Welcome to tbe basketball game");
		int choice = 124;
		System.out.println();
		Player p = new Player(666, "Dave", 125, 126 ,"A team");
		System.out.println("New "+ p);

		if(PlayerService.addPlayer(p))
			System.out.println("New Player "+ p.getName()+" added.");

	}
}
