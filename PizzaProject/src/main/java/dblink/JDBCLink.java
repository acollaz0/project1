package dblink;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCLink {
	
	private static Connection con = null;
	
	public static Connection getConnection() {

		try {

			if (con == null) {
				FileInputStream fis = new FileInputStream("db.properties");
				Properties p = new Properties();
				p.load(fis);
				String endpoint = p.getProperty("endpoint");
				String username = p.getProperty("username");
				String password = p.getProperty("password");
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
