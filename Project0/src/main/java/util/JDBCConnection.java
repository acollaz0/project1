package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	
	public static Connection con = null;

	
	
	public static Connection getConnection() {
		
		try {
			if (con == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String endpoint = "jdbc:oracle:thin:@aaronsdetdb.cxptu5dst9d5.us-east-2.rds.amazonaws.com:1521:ORCL";
				String username = "aaron";
				String password = "password";
				
				con = DriverManager.getConnection(endpoint, username, password);
				
				return con;
				
			}
			else
				return con;
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}