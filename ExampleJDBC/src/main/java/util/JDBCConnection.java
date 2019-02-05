package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {
	public static Connection conn = null;
	public static Connection getConnection() {
		try {
			if( conn == null) {
			Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties props = new Properties();
			FileInputStream input = new FileInputStream("src/main/resources/connection.properties");
			props.load(input);
			String endpoint = props.getProperty("url");
			String username = props.getProperty("name");
			String password = props.getProperty("password");
			
			conn = DriverManager.getConnection(endpoint, username, password);
			
			return conn;
			}
			else { 
				return conn;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
