package backend;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import tools.InputTools;

public class ClipBankUser {
	
	private List<ClipTransaction> transactions;
	private List<ClipBox> clipboxes;
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private boolean issuper;
	
	public ClipBankUser(String username, ClipBankDao dao) {
		super();
		this.username = username;
		this.transactions = dao.getTransactions(username);
		this.clipboxes = dao.getClipBoxes(username);
		this.issuper = dao.isSuperUser(this.username);
	}
	
	public List<ClipBox> getClipBoxes() {
		return clipboxes;
	}

	/**
	 * Prompts the logged in user to perform various actions
	 */
	public int performActions() {
		System.out.println("Please select and action to perform:");
		
		Scanner scan = new Scanner(System.in);
		
		String[] options = new String[] {
				"Withdraw",			//1
				"Deposit",			//2
				"Create Clip Box",	//3
				"Delete Clip Box",	//4
				"View Clip Boxes"	//5
				};
		
		for (int i = 1; i <= options.length; i++) {
			System.out.println(String.format("%-20s", options[i-1]) + " : " + i);
		}
		int selection = 0;
		
		try {
			
			
			String s = scan.nextLine();
			System.out.println(s);
			selection = Integer.parseInt(s);

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
		scan.close();
		
		switch (selection) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			for (ClipBox cb : this.clipboxes) {
				System.out.println(cb.getClipboxID() + " : " + cb.getBalance());
			}
			break;

		default:
			break;
		}
		
		//scan.close();
		return 0;
	}

}
