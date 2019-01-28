package practicesql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.PlayerDAO;
import model.Player;
import util.JDBCConnection;

public class SqlPractice {
	
	public static Connection con = JDBCConnection.getConnection();

	public static void main(String[] args) {
		
		//CallableStatement cs = con.prepareCall(sql)
		
	}

}
