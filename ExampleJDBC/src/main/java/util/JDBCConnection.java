package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;

public class JDBCConnection {
	
	public static Connection con = null;
	
	public static Connection getConnection() {

		try {
			
			if(con ==null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String endpoint = "jdbc:oracle:thin:@adamsdetdb.cwrqnnecy1to.us-east-2.rds.amazonaws.com:1521:ORCL";			
				String username = "adam";
				String password = "password";// do not connect to my database plzzzzz			
				
				con= DriverManager.getConnection(endpoint, username, password);
				return con;
			}
			else {
				return con;
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	

}
