package backend;

import java.util.ArrayList;
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
	/**
	 * @return
	 */
	public int performActions() {
		System.out.println("Please select and action to perform:");
		
		Scanner scan = new Scanner(System.in);
		
		String[] options = new String[] { 
				"Withdraw", 		//1
				"Deposit", 			//2
				"Create Clip Box",  //3
				"Delete Clip Box",  //4
				"View Clip Boxes",  //5
				"Log Out"			//6
		};
		for (int i = 1; i <= options.length; i++) {
			System.out.println(String.format("%-20s", options[i - 1]) + " : " + i);
		}
		int boxlabel=0;
		ClipBox clipbox=null;
		while (scan.hasNextLine()) {
			
			int selection = 0;
			try {

				String s = scan.nextLine();
				//System.out.println(s);
				selection = Integer.parseInt(s);

				//System.out.println("*-" + selection + "-*");

				if (selection >= 1 && selection <= options.length) {
					System.out.println("Made valid selection");
				} else {
					selection = 0;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
				selection = 0;
			}
			
			switchblock:
			switch (selection) {
			case 1:
				System.out.println("Withdrawing from clip box\n"
						+ "Which Clip Box would you like to withdraw from?");
				
				/**
				 * 
				 * for (int i = 0; i < this.clipboxes.size(); i++) {
				 * 
				 * System.out.println( String.format("%s |%-20s | %-20s|", "label",
				 * "Clip Box ID", "Balance") ); System.out.println(
				 * String.format("%5d |%20s | %20d|",i+1,this.clipboxes.get(i).getClipboxID(),
				 * this.clipboxes.get(i).getBalance()) ); }
				 * 
				 * //boolean isValidLabel = true; boxlabel = 0;
				 * 
				 * while ( //Checks if boxlabel is within acceptable range !(boxlabel>=1 &&
				 * boxlabel<=this.clipboxes.size()) ) { while (!scan.hasNextInt()) { if
				 * (scan.nextLine().contains("exit")) {
				 * System.out.println("Cancelling operation");
				 * System.out.println("Press ENTER To Continue"); scan.nextLine(); break
				 * switchblock; } else { System.out.println("That's not a valid input."); } }
				 * boxlabel = scan.nextInt(); if (!(boxlabel>=1 &&
				 * boxlabel<=this.clipboxes.size())) {
				 * System.out.println("That is not a valid Clip Box Label"); scan.nextLine(); }
				 * }
				 * 
				 * //if we reach this point, boxlabel should be a valid int. clipbox =
				 * this.clipboxes.get(boxlabel-1); String boxID = clipbox.getClipboxID(); int
				 * balance = clipbox.getBalance();
				 * 
				 * int withdrawl = 0;
				 * 
				 * System.out.println("How much would you like to withdraw from Clip Box *" +
				 * boxID + "* with balance *" + balance + "?");
				 * 
				 * while ( //Checks if boxlabel is within acceptable range !(withdrawl>=1 &&
				 * withdrawl<=balance) ) { while (!scan.hasNextInt()) { if
				 * (scan.nextLine().contains("exit")) {
				 * System.out.println("Cancelling operation");
				 * System.out.println("Press ENTER To Continue"); scan.nextLine(); break
				 * switchblock; } else { System.out.println("That's not a valid input."); } }
				 * withdrawl = scan.nextInt(); if (!(withdrawl>=1 && withdrawl<=balance)) {
				 * System.out.
				 * println("You cannot withdraw a number less than one, or greater than the Clip Box balance."
				 * ); } }
				 */
				
				clipbox = askForClipBox();
				if (clipbox == null) {break switchblock;}
				
				int withdrawl = InputTools.getNaturalNumberInput(clipbox.getBalance());
				
				if (withdrawl == 0) {break switchblock;}
				
				//If we reach this point, both boxlabel and withdrawl should be valid integers
				System.out.println("You have withdrawn *" + withdrawl + "* paperclips from Clip Box *" + clipbox.getClipboxID() + "*.");
				clipbox.withdraw(withdrawl);
				System.out.println("The new balance is : " + clipbox.getBalance());
				
				
				System.out.println("Press ENTER To Continue");
				scan.nextLine();
				break;
			case 2:
				System.out.println("Depositing to clip box");
				
				System.out.println("Which Clip Box would you like to deposit into?");
				
				clipbox = askForClipBox();
				if (clipbox == null) {break switchblock;}
				
				int deposit = InputTools.getNaturalNumberInput(RDSClipBankDB.MAX_DEPOSIT);
				
				if (deposit == 0) {break switchblock;}
				
				System.out.println("You have deposited *" + deposit + "* paperclips into Clip Box *" + clipbox.getClipboxID() + "*.");
				clipbox.deposit(deposit);
				System.out.println("The new balance is : " + clipbox.getBalance());
				
				System.out.println("Press ENTER To Continue");
				scan.nextLine();
				break;
			case 3:
				System.out.println("You're creating a clip box");
				
				ClipBox newbox = ClipBox.createNewClipBox(this.username);
				if (newbox == null) {
					System.out.println("Something went wrong.");
					break switchblock;
				}
				this.clipboxes.add(newbox);
				
				System.out.println(
						String.format("|%-20s | %-20s|", "Clip Box ID", "Balance")
						);
				System.out.println(
						String.format("|%20s | %20d|",newbox.getClipboxID(),newbox.getBalance())
						);
				
				System.out.println("Press ENTER To Continue");
				scan.nextLine();
				break;
			case 4:
				System.out.println("You're deleting a clip box");
				System.out.println("Warning, you can only delete Clip Boxes that have a balance of zero");
				
				ClipBox c = askForEmptyClipBox();
				if (c!=null) {
					System.out.println("Now deleting Clip Box *" + c.getClipboxID() + "*");
					c.delete();
				}
				
				System.out.println("Press ENTER To Continue");
				scan.nextLine();
				break;
			case 5:
				
				System.out.println(
						String.format("|%-20s | %-20s|", "Clip Box ID", "Balance")
						);
				if (this.clipboxes.size() > 0) {

					for (ClipBox cb : this.clipboxes) {

						System.out.println(
								String.format("|%20s | %20d|",cb.getClipboxID(),cb.getBalance())
								);
					}
				} else {
					System.out.println("You have no Clip Boxes");
				}
				
				System.out.println("Press ENTER To Continue");
				scan.nextLine();
				
				break;
			case 6:
				System.out.println("Logging out");
				System.out.println("Press ENTER To Continue");
				return 1;
			default:
				break;
			}
			
			for (int i = 1; i <= options.length; i++) {
				System.out.println(String.format("%-20s", options[i - 1]) + " : " + i);
			}
			
		}
		//scan.close();
		return 0;
	}
	
	private ClipBox askForClipBox() {
		
		System.out.println(
				String.format("%s |%-20s | %-20s|", "label", "Clip Box ID", "Balance")
				);
		
		for (int i = 0; i < this.clipboxes.size(); i++) {
			
			System.out.println(
					String.format("%5d |%20s | %20d|",i+1,this.clipboxes.get(i).getClipboxID(),this.clipboxes.get(i).getBalance())
					);
		}
		
		int boxlabel = InputTools.getNaturalNumberInput(this.clipboxes.size());
		
		return (boxlabel==0 ? null : this.clipboxes.get(boxlabel-1));
	}
	
	private ClipBox askForEmptyClipBox() {
		List<ClipBox> cbs = new ArrayList<>();
		for (ClipBox cb : this.clipboxes) {
			if (cb.getBalance()==0) {
				cbs.add(cb);
			}
		}
		
		if (cbs.size()>0) {
			
			System.out.println(
					String.format("%s |%-20s | %-20s|", "label", "Clip Box ID", "Balance")
					);
			
			for (int i = 0; i < cbs.size(); i++) {
				
				System.out.println(
						String.format("%5d |%20s | %20d|",i+1,cbs.get(i).getClipboxID(),cbs.get(i).getBalance())
						);
			}
			
			int boxlabel = InputTools.getNaturalNumberInput(cbs.size());
			
			return (boxlabel==0 ? null : cbs.get(boxlabel-1));
			
		} else {
			System.out.println("You have no empty Clip Boxes. Please empty a box before deleting it.");
			return null;
		}
		
	}

}
