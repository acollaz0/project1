package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.PlayerDAO;
import model.Player;
import util.JDBCConnection;

public class SQLpractice {

	public static Connection conn = JDBCConnection.getConnection();
	
	public static void main(String[] args) {
		
		
//		String playersSQL = "select * from player";// do not use semicolons in the sql statement
		
		
		PlayerDAO pd = new PlayerDAO();
		Player p = pd.getPlayer(121);
		System.out.println(p);
		
//		try {
////			// Never use statement
////			Statement statement = conn.createStatement();
////			ResultSet rs = statement.executeQuery(playersSQL);
////			
////			while(rs.next()) {
////				
////				String name = rs.getString("NAME");
////				System.out.println(name);
//			}
//			
//		}catch(Exception e) {		
//			e.printStackTrace();
//		}
//		
	}

}
