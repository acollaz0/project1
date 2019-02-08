package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PlayerDAO;
import model.Player;
import util.JDBCConnection;

public class SQLpractice {

	public static Connection conn = JDBCConnection.getConnection();
	
	public static void main(String[] args) {
		
		//String playersSQL = "Select * from player";//do not use semicolons in sql statement
		
//		try {
//			//never use statement
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(playersSQL);
//			
//			while(rs.next()) {
//				String name = rs.getString("NAME");
//				System.out.println(name);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		PlayerDAO pd = new PlayerDAO();
		Player p = pd.getPlayer(100);
		System.out.println(p.toString());
		PlayerDAO all = new PlayerDAO();
		List<Player> players = new ArrayList<>();
		players = all.allPlayers();
		System.out.println(players);
		
		//should close connection before application ends
		try {
			JDBCConnection.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
