package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	
	public static Connection con = null;
	
	public static void main(String[] args) {
		
		Connection con1 = getConnection();
		Connection con2 = getConnection();
		Connection con3 = getConnection();
		Connection con4 = getConnection();
		
		while (true) {
			
		}
	}
	
	public static Connection getConnection() {
		
		try {
			
			if (con == null) {
				String endpoint = "jdbc:oracle:thin:@tomsdetdb.cjroyz7uh9et.us-east-1.rds.amazonaws.com:1521:ORCL";
				String username = "tbnilson";
				String password = "password";
				con = DriverManager.getConnection(endpoint, username, password); //This does not prevent you from making more than one connection to the database
			}
			return con;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

}
