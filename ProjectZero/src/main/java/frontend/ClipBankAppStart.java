package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

import backend.ClipBankDao;
import backend.ClipBankUser;
import backend.RDSClipBankDB;
import tools.InputTools;
import tools.IntTools;
import tools.StringTools;


public class ClipBankAppStart {

	public static void main(String[] args) {
		
		
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
				+ "\n|" + StringTools.center("(Please Press Enter)", 58) + "|"
				+ "\n|" + StringTools.spaces(58) + "|"
				+ "\n************************************************************\n"
				);
		
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		while (scan.hasNextLine()) {
			scan.nextLine();
			System.out.println("What would you like to do?");
			String[] options = new String[] {"Login", "Create Account", "Exit Application"};
			//int selection = InputTools.getNumberInput(options);
			
			for (int i = 1; i <= options.length; i++) {
				System.out.println(String.format("%-20s", options[i-1]) + " : " + i);
			}
			int selection = 0;
			
			try {
				
				
				String s = scan.nextLine();
				
				selection = Integer.parseInt(s);
				System.out.println("*" + s + "*");

				System.out.println("*-" + selection + "-*");
				
				if (selection >= 1 && selection <= options.length) {
					System.out.println("Made valid selection");
				} else {
					selection = 0;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
				selection = 0;
			}
			
			
			
			
			if (selection!=0) {
				
				System.out.println("You selected : " + selection);
				
			} else {
				System.out.println("Please input one of the options shown above.");
				continue;
			}
			
			ClipBankUser user = null;
			
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
