package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static Connection conn = null;
	public static Connection getConnection() {
		try {
			if( conn == null) {
			Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String endpoint = 
					"jdbc:oracle:thin:@brandonsdetdb.cyiztrwjywhy.us-east-2.rds.amazonaws.com:1521:ORCL";
			String username = "brandon";
			String password = "password";
			
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
