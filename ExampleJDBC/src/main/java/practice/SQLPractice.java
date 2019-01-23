package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.PlayerDAO;
import model.Player;
import util.JDBCConnection;

public class SQLPractice {
	public static Connection conn = JDBCConnection.getConnection();
	public static void main(String[] args) {
		String playersSQL = "SELECT * FROM player";
		PlayerDAO pd = new PlayerDAO();
		Player p = pd.getPlayer(121);
		System.out.println(p);
		//do not use semicolons in the sql statement;;;;;;;;;;;;;
		
//		try {
//			
//			//we used Statement
//			//do not use Statement
//			//PreparedStatement
//			//PreparedStatement sanitizes input
//			
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(playersSQL);
//			while(rs.next()) {
//				String name = rs.getString("name");
//				System.out.println(name);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

}
