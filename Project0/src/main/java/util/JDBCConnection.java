package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {
	
	public static Connection con = null;

	
	
	public static Connection getConnection() {
		
		try {
			if (con == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Properties props = new Properties();
				FileInputStream input = new FileInputStream("src/main/resources/connection.properties");
				props.load(input);
				
				String endpoint = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				
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