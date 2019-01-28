package application;

import model.Player;
import service.PlayerService;

public class App {
	
	//Heirarchy of packages:
	//Highest level \/
	//Application
	//Service layer
	//Model layer
	//Dao layer
	//Connection object
	//Lowest level /\
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the basketball league");
		
		Player p = new Player(77, "Jerry!",88,99,"lynxes");
		
		System.out.println(PlayerService.addPlayer(p));
		
		
		
	}
	
}
