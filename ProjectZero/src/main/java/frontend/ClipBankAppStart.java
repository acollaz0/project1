package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

import backend.ClipBankDao;
import backend.ClipBankUser;
import backend.RDSClipBankDB;
import tools.InputTools;
import tools.IntTools;
import tools.StringTools;
import tools.UserInputException;


public class ClipBankAppStart {

	public static void main(String[] args) throws UserInputException { //this throws breaks the program, but I'm too lazy to put in the try catch blocks
		
		
		ClipBankDao bank = null;
		try {
			bank = RDSClipBankDB.getRDSClipBankDB();
			//System.out.println("Connected to Database");
		} catch (Exception e1) {
			System.out.println("Failed to connect to Database");
			System.exit(0);
		}
		
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
				"************************************************************"
				+ "\n|" + StringTools.spaces(58) + "|"
				+ "\n|" + StringTools.center("Welcome to the Clip Bank!", 58) + "|"
				+ "\n|" + StringTools.center("(Please Press ENTER)", 58) + "|"
				+ "\n|" + StringTools.spaces(58) + "|"
				+ "\n************************************************************\n"
				);
		
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		while (scan.hasNextLine()) {
			scan.nextLine();
			System.out.println("What would you like to do?");
			String[] options = new String[] {"Login", "Create Account", "Exit Application"};
			
			int selection = InputTools.getNaturalNumberInput(options);
			
			ClipBankUser user = null;
			
			mainswitch:
			switch (selection) {
			case 1:
				//Login option. 
				System.out.println("Please put your username:");
				//scan.nextLine();
				String username = scan.nextLine();
				System.out.println("Please put your password:");
				String password = scan.nextLine();
				//System.out.println(username.trim() + " " + password.trim());
				//System.out.println(bank.validate(username, password));
				
				if (bank.validate(username, password)) {
					user = new ClipBankUser(username, bank);
					System.out.println("Welcome back " + user.getUsername());
				} else {
					System.out.println("Your username and password aren't valid. Try again.");
				}
				
				break;
				
			case 2:
				
				
				String newuser = "";
				
				boolean isValidUser = false;
				
				while (!isValidUser) {
					newuser = InputTools.getAlphanumericString(6);
					if (newuser.length()<0) {
						System.out.println("Cancelling user account creation");
						break mainswitch;
					}
					if (!bank.userExists(newuser)) {
						isValidUser = true;
					}
				}
				
				//newuser is now a valid new username.
				
				String newpass = InputTools.getAlphanumericString(6);
				
				
				if (newpass.length()>0) {
					if (bank.createUser(newuser, newpass)) {
						System.out.println("Welcome to the Clip Bank, " + newuser + "!\n"
								+ "You may now log in.");
					} else {
						System.out.println("Something went wrong.");
					}
				} else {
					System.out.println("Cancelling user account creation");
				}
				break;
			case 3:
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				break;
			}
			
			int returnstate = 0; //0 means quit, 1 means restart the loop
			if (user != null) {
				user.performActions();
			}
			
			//scan.close();
			
		}
		
		

	}
	
	

}
