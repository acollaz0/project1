package messing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connect.JDBCLink;
import dao.IUserDAO;
import dao.UserDAO;
import models.ClipBox;
import models.User;
import service.BankingService;
import tools.UserInputException;

public class SQLPlayground {

	public static void main(String[] args) {
		/*
		 * Connection con = JDBCLink.getConnection(); String sql =
		 * "SELECT * FROM BANKUSER"; PreparedStatement ps; try { ps =
		 * con.prepareStatement(sql); ResultSet rs = ps.executeQuery();
		 * 
		 * while (rs.next()) { for (int i = 0; i < rs.getMetaData().getColumnCount();
		 * i++) { System.out.println(rs.getObject(i+1)); } }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }
		 */
		
//		System.out.println(BankingService.getAllUsers());
		
		//System.out.println(BankingService.login());
//		User user=null;
//		try {
//			user = BankingService.login();
//		} catch (UserInputException e1) {
//			e1.displayExitMessage();
//			user = null;
//		}
//		
//		if (user!=null) {
//			List<ClipBox> boxes = BankingService.getClipBoxes(user);
//			
//			System.out.println(String.format("| %10s | %20s | %10s | %40s |", "Box ID", "Clip Box Owner", "Balance",
//					"Description"));
//			
//			for (ClipBox cb : boxes) {
//				System.out.println(cb);
//			}
//			
//			System.out.println("Adding a clip box:");
//			try {
//				BankingService.createClipBox(user);
//			} catch (UserInputException e) {
//				e.displayExitMessage();
//			}
//		}
		
		for (int i = 0; i < 50; i++) {
			System.out.println((i*105943)%104743);
		}
		
		
		
	}

}
