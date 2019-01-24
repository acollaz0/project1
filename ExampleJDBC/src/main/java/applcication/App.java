package applcication;

import java.sql.SQLException;

import model.Player;
import service.PlayerService;
import util.JDBCConnection;

public class App {

	public static void main(String[] args) {
		
//		System.out.println("Welcome to the basketball league");
//		
		Player p = new Player(12,"Adam",300000,1,"The Gators");
			
		System.out.println(PlayerService.addPlayer(p));		
//		System.out.println(PlayerService.allPlayers());
//		System.out.println(PlayerService.deletePlayer(48));
		
		// Should close connection before application ends
		try {
			JDBCConnection.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
