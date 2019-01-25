package application;

import service.PlayerService;

public class App {

	
	public static void main(String[] args) {
		System.out.println("Welcome to the basketball league");
		int choice = 124;
		System.out.println(PlayerService.getPlayer(choice));
	}
}
