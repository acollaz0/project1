package app;

import java.sql.Connection;
import java.sql.SQLException;

import connect.JDBCLink;
import models.User;
import service.BankingService;
import tools.InputTools;
import tools.StringTools;
import tools.UserInputException;

public class ClipBankApp {

	public static void main(String[] args) {
		
		System.out.println(
				"************************************************************\n"
				+ "                                         .,clol:,.          \r\n" + 
				"                                      .:xKNMWWWWN0d;.       \r\n" + 
				"                                    .:kNMXko:;:oONWNk,      \r\n" + 
				"                                  .:kNWXx,      .;kWM0;     \r\n" + 
				"                                .:kNMXx,          .xWMO.    \r\n" + 
				"                             ..:kNWXx,             lNMK,    \r\n" + 
				"                           .:kKNMXx,              :KMWd.    \r\n" + 
				"                         .:kNWWXx,.             'dXMNx.     \r\n" + 
				"                       .:kNWXxl,.,oxc.        'dXWWOc.      \r\n" + 
				"                     .:kNWXx,..,dXWNk'      'dXWW0c.        \r\n" + 
				"                   .:kNMXx,.,d0XMNO:.     'dXWWOc.          \r\n" + 
				"                 .:kNWXx,.,dXMMNO:.     'dXWW0c.            \r\n" + 
				"               .:kNWXx,.,dXMNOd:.     'dXWWOc.              \r\n" + 
				"             .:kNWNx,.,dXWNO:.      'dXWWOc;coc.            \r\n" + 
				"           .:kNMXx,.,dXWWO:.      'dXWWOc;l0WW0,            \r\n" + 
				"         .:kNMXx,.,dXWNO:.      'dXWW0c;l0WWKo'             \r\n" + 
				"        ;ONWXx,..oXWWO:.     ':dXWWOc;l0WWKo'               \r\n" + 
				"      .oXMNk,  .kWWKc.     'dXWWWOc;l0WWKo'                 \r\n" + 
				"     .xWMXl.   cNMXc     'dXWWNOc;l0WWKo'                   \r\n" + 
				"    .oNMK:     ;KMNx,..:xXWWOl;;l0WWKo'                     \r\n" + 
				"    '0MWd.      ;ONWNXXWWXOc;lx0WWKo'                       \r\n" + 
				"    ;KMNc        .;oxkkd:',l0WMWKo'                         \r\n" + 
				"    .kMMO'              .l0WWKOo'                           \r\n" + 
				"     ,0WW0:.          .c0WWKo'.                             \r\n" + 
				"      'xXMNOc'.   .'cxKWWXo'                                \r\n" + 
				"        ,xXWWNKOkOKNWWNOl'                                  \r\n" + 
				"          .:dk0XXK0kd:'                                     \r\n" + 
				"              ....                                          \r\n" + 
				"                                                            \r\n" + 
				"************************************************************");
		Connection con = JDBCLink.getConnection();
		BankingService.loadService();
		
		System.out.println("\n************************************************************\n|" + StringTools.spaces(58) + "|"
				+ "\n|" + StringTools.center("Welcome to the Clip Bank!", 58) + "|"
				+ "\n|" + StringTools.center("The World's Premiere Paperclip Banking Service", 58) + "|"
				+ "\n|" + StringTools.spaces(58) + "|"
				+ "\n************************************************************\n");

		
		boolean running = true;
		mainloop:
		while(running) {
			int selection=0;
			try {
				
				System.out.println(
						"************************************************************"
						+ "\n|" + StringTools.spaces(58) + "|"
						+ "\n|" + StringTools.center("This is the login screen.", 58) + "|"
						+ "\n|" + StringTools.center("Select an option, or type \"exit\" to quit the application", 58) + "|"
						+ "\n|" + StringTools.spaces(58) + "|"
						+ "\n************************************************************\n"
						);
				
				selection = InputTools.getNaturalNumberInput(new String[] {
						"Log In",
						"Register New Account"});
				System.out.println();

			} catch (UserInputException e) {
				System.out.println("Goodbye!");
				
				break mainloop;
			}
			switch (selection) {
			case 1:
				User user = null;
				try {
					user = BankingService.login();
					BankingService.performUserActions(user);
					
				} catch (UserInputException e) {
					e.displayExitMessage();
				}
				break;
			case 2:
				User newuser;
				try {
					newuser = BankingService.createUser();


					if (newuser!= null) {
						System.out.println("You've successfully created your new account.");
					} else {
						System.out.println("Something unexpected went wrong when creating your new account.");
					}
				} catch (UserInputException e) {
					System.out.println("Returning to Log In screen.");
				}
				
				break;
			}
			
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
