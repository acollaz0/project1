package application;

import model.Player;
import service.PlayerService;

public class App {
	
	public static void main(String[] args) {
		System.out.println("Welcome to tbe basketball game");
		int choice = 124;
		System.out.println();
		
		Player p = new Player (666, "Dave", 125, 126 ,"A team");
		Player p2 = new Player(666, "Stan", 125, 126 ,"A team");
		Player p3 = new Player(666, "Dan", 125, 126 ,"A team");
		Player p4 = new Player(666, "Steve", 125, 126 ,"A team");
		
		System.out.println("New "+ p);

		if(PlayerService.addPlayer(p))
			System.out.println("New Player "+ p.getName()+" added.");
		if(PlayerService.addPlayer(p2))
			System.out.println("New Player "+ p2.getName()+" added.");
		if(PlayerService.addPlayer(p3))
			System.out.println("New Player "+ p3.getName()+" added.");
		if(PlayerService.addPlayer(p4))
			System.out.println("New Player "+ p4.getName()+" added.");
		System.out.println(PlayerService.allPlayers());

	}
}
