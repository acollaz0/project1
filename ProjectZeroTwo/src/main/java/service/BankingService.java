package service;

import java.util.ArrayList;
import java.util.List;

import dao.ClipBoxDAO;
import dao.IClipBoxDAO;
import dao.ITransactionDAO;
import dao.IUserDAO;
import dao.TransactionDAO;
import dao.UserDAO;
import models.ClipBox;
import models.Transaction;
import models.User;
import tools.InputTools;
import tools.StringTools;
import tools.UserInputException;

public class BankingService {
	
	private static ITransactionDAO tdao = new TransactionDAO();
	private static IClipBoxDAO cbdao = new ClipBoxDAO();
	private static IUserDAO udao = new UserDAO(); 
	
	public static boolean isExtantUser(String user) {
		
		return udao.isExtantUser(user);
		
	}
	
	
	public static User createUser() throws UserInputException {
		
		//String username = null;
		String password = null;
		
		String username="";
		while (username.length()<5 || udao.isExtantUser(username)) {
			username = InputTools.getSimpleTextString(5,
					"What should this new user's name be?");
			if (udao.isExtantUser(username)) {
				System.out.println("That username is already in use.");
			}
		}
		
		//username = InputTools.getSimpleTextString(5, "Please enter a username. Alphanumeric usernames only.");

		password = InputTools.getAlphanumericString(6, "Please enter a password at least six characters long. Alphanumeric passwords only.");
		User user = new User(username,password,false);

		return udao.addUser(user) ? user : null;
		
	}
	
	public static List<ClipBox> getClipBoxes(User user) {
		List<ClipBox> boxes = new ArrayList<>();
		
		return cbdao.getClipBoxes(user);
		
	}
	
	public static User login() throws UserInputException {
		User user = null;
		String username;
		String password;
		while (user==null) {
			username = null;
			password = null;
			
			username = InputTools.getSimpleTextString(5, "What is your username?");

			password = InputTools.getAlphanumericString(6, "What is your password?");
			user = new User(username, password, udao.isSuperUser(username));

			
			if (!udao.isExtantUser(username)) {
				System.out.println("There is no user by that name.");
				user = null;
			}
			if (!udao.validateUser(username, password)) {
				System.out.println("That is not a valid username and password combination.");
				user = null;
			} 
		}
		return user;
	}
	
	

	public static List<User> getAllUsers() {
		return udao.getAllUsers();
	}
	
	public static boolean isExtantClipBox(String boxID) {
		return cbdao.isExtantClipBox(boxID);
	}
	
	public static ClipBox createClipBox(User user) throws UserInputException {
		
		System.out.println("You've selected to create a new Clip Box.");
		System.out.println("Do you want to add a description to this new Clip Box?\n");
		
		int descriptionselect = InputTools.getNaturalNumberInput(new String[] {"Yes","No"});

		if (descriptionselect==1) {
			String desc = InputTools.getSimpleTextString(1, "Please write a brief description");
			return cbdao.addClipBox(user, desc);
		} else {
			return cbdao.addClipBox(user);
		}
	}


	public static void performUserActions(User user) {
		
		System.out.println(
				"************************************************************"
				+ "\n|" + StringTools.spaces(58) + "|"
						+ "\n|" + StringTools.center("***USER ACTIONS***", 58) + "|"
				+ "\n|" + StringTools.center("You Have Logged In Successfully, " + user.getUsername() +"!", 58) + "|"
				+ "\n|" + StringTools.center("Select an option from the numbered list below,", 58) + "|"
						+ "\n|" + StringTools.center("or type \"exit\" to log out.", 58) + "|"
				+ "\n|" + StringTools.spaces(58) + "|"
				+ "\n************************************************************"
				);
		
		boolean useractive = true;
		userloop:
		while (useractive) {
			int selection=0;
			System.out.println("\n\n");
			if (!user.isSuperUser()) {
				String[] options = new String[] { "View Clip Boxes", "Withdraw Paperclips", "Deposit Paperclips",
						"Add Clip Box", "Delete Clip Box", "View Transactions" };
				selection = 0;
				try {
					selection = InputTools.getNaturalNumberInput(options);
				} catch (UserInputException e) {
					System.out.println("You have chosen to log out.");
					break userloop;
				} 
			} else {
				//put the superuser selection options here
				//A superuser can view, create, update, and delete all users.
				
				String[] options = new String[] { "View Clip Boxes", 
						"Withdraw Paperclips", 
						"Deposit Paperclips",
						"Add Clip Box", 
						"Delete Clip Box", 
						"View Transactions",
						"View All Users",
						"Create New User",
						"Update user",
						"Delete User"
						};
				selection = 0;
				try {
					selection = InputTools.getNaturalNumberInput(options);
				} catch (UserInputException e) {
					System.out.println("You have chosen to log out.");
					break userloop;
				} 
				
				
			}
			switch (selection) {
			case 1:
				//View clipboxes
				displayClipBoxes(user);
				break;
			case 2:
				//Withdraw
				System.out.println("Please select a Clip Box to withdraw from: \n");
				

				try {
					ClipBox wbox = askForClipBox(user);
					if (wbox.getBalance()>0) {
						System.out.println("Please enter how much you would like to withdraw from this Clip Box.");
						int withdrawl = InputTools.getNaturalNumberInput(wbox.getBalance());
						Transaction t_withdraw = wbox.withdraw(withdrawl);
						System.out.println("Your transaction:\n"
								+ t_withdraw);
					} else {
						System.out.println("That Clip Box is empty, and cannot be withdrawn from.");
					}
				} catch (UserInputException e) {
					System.out.println("Going back to User Actions.");
				}

				break;
			case 3:
				//Deposit
				System.out.println("Please select a Clip Box to deposit into: \n");
				
				
				int deposit;
				try {
					ClipBox dbox = askForClipBox(user);
					deposit = InputTools.getNaturalNumberInput(10000);
					Transaction t_deposit = dbox.deposit(deposit);
					System.out.println("Your transaction:\n"
							+ t_deposit);
				} catch (UserInputException e) {
					System.out.println("Going back to User Actions.");
				}
				break;
			case 4:
				//create clip box
				try {
					System.out.println(createClipBox(user));
				} catch (UserInputException e) {
					System.out.println("Going back to User Actions");
				}
				
				break;
			case 5:
				//Delete empty clip box
				try {
					selectClipBoxToDelete(user);
				} catch (UserInputException e) {
					System.out.println("Going back to User Actions");
				}
				break;
			case 6:
				//View transations
				displayTransactions(user);
				
				
				break;
			case 7:
				//View All Users
				//done
				displayAllUsers();
				
				break;
			case 8:
				//create new user
				//done
				System.out.println("You want to create a new user. Please input the new user information.");
				try {
					createUser();
				} catch (UserInputException e1) {
					System.out.println("Going back to User Actions");
				}
				break;
			case 9:
				// Edit user info
				//done
				try {
					editUserInfo();
				} catch (UserInputException e1) {
					System.out.println("Going back to User Actions");
				}
				
				break;
			case 10:
				//delete user
				//done
				try {
					selectUserToDelete();
				} catch (UserInputException e) {
					System.out.println("Going back to User Actions");
				}
				break;
			}


		}


	}


	private static void editUserInfo() throws UserInputException {
		
		List<User> users = udao.getAllUsers();
		
		int selection = 0;
		
		System.out.println("Please select the label of the user you want to edit.\n");
//		System.out.println("You can only delete a user if they have no Clip Boxes.");
		System.out.println(String.format("| %-5s | %-20s | %-20s | %-12s |", "Label", "Username:", "Password:", "Super User:"));

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			System.out.println(String.format("| %5d |   %-18s |   %-18s | %-12s |", 
					i+1,
					user.getUsername(),
					user.getPassword(),
					user.isSuperUser()
					));

		}
		
		selection = InputTools.getNaturalNumberInput(users.size());
		User user = users.get(selection-1);
		
		System.out.println("You have chosen to edit " + user.getUsername() + "'s user information.");
		
		//This loop checks to make sure the user inputs a valid and unique username, but still allows them to input the old username.
		String n_username="";
		while (n_username.length()<5 || udao.isExtantUser(n_username)) {
			n_username = InputTools.getSimpleTextString(5,
					"What should their new username be? (The old one was " + user.getUsername() + ")");
			if (n_username.equals(user.getUsername())) {break;}
		}
		
		String n_password = InputTools.getAlphanumericString(6, "What should their new password be? (The old one was " + user.getPassword() + ")");
		
		System.out.println("The new username is : " + n_username);
		System.out.println("The new password is : " + n_password);
//		System.out.println("Are you certain you want to make these changes to " + user.getUsername() + "?");
		InputTools.getYesNo("Are you certain you want to make these changes to " + user.getUsername() + "?");
		
		udao.editUserInfo(user,n_username,n_password);
		user = udao.getUser(n_username);
//		System.out.println(user + " " + user.getPassword());
		
	}


	private static void selectUserToDelete() throws UserInputException {
		
		List<User> users = udao.getAllUsers();
		
		
		
		int selection = 0;
		

		System.out.println("Please select the label of the user you want to delete.");
		System.out.println("You can only delete a user if they have no Clip Boxes.");
		System.out.println(String.format("| %-5s | %-20s | %-20s | %-12s | %-20s |", "Label", "Username:", "Password:", "Super User:", "Clip Boxes:"));
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			System.out.println(String.format("| %5d |   %-18s |   %-18s | %12s | %12s |", 
					i+1,
					user.getUsername(),
					user.getPassword(),
					user.isSuperUser(),
					cbdao.getClipBoxes(user).size()
					));

		}
		boolean keepasking = true;
		while (keepasking) {
			
			selection = InputTools.getNaturalNumberInput(users.size());
			User user = users.get(selection - 1);
			System.out.println("You selected " + user.getUsername() + " for deletion. This cannot be undone.");
			
			if (cbdao.getClipBoxes(user).size()>0) {
				System.out.println("That user still has active Clip Boxes, and cannot be deleted.");
			} else {
				keepasking=false;
			}
		}
		
		int confirmation = InputTools.getYesNo();
		if (confirmation == 1) {
			boolean b = udao.deleteUser(users.get(selection-1));
			System.out.println(users.get(selection-1).getUsername() + " has been deleted from the records.");
		}
		
	}


	private static void displayAllUsers() {
		
		List<User> users = udao.getAllUsers();
		
		System.out.println(String.format("| %-20s | %-20s | %-12s |", "Username:", "Password:", "Super User:"));
		
		for (User user : users) {
			System.out.println(String.format("| %-20s | %-20s | %12s |", 
					user.getUsername(),
					user.getPassword(),
					user.isSuperUser()));
		}
		
		
	}


	private static void displayTransactions(User user) {
		
		List<Transaction> transactions = tdao.getTransactions(user);
		if (transactions.size()>0) {

			String header = String.format("| %14s | %20s | %20s | %12s | %30s |",
					"T_ID",
					"Transaction Value",
					"Final Balance",
					"Clip Box",
					"Timestamp"
					);
			System.out.println(header);


			for (Transaction t : transactions) {
				System.out.println(t);
			}
		} else {
			System.out.println("You have no recorded transactions.");
		}
		
	}


	private static void selectClipBoxToDelete(User user) throws UserInputException {
		System.out.println("You've chosen to delete a Clip Box.");
		System.out.println("You can only delete empty Clip Boxes");
		
		boolean keepasking = true;
		
		ClipBox box=null;
		while (keepasking) {
			box = askForClipBox(user);
			if (box.getBalance()==0) {
				keepasking=false;
			} else {
				System.out.println(box.getCb_id() + " is not an empty clip box. Please select a different box, \n"
						+ "or withdraw all paperclips from " + box.getCb_id());
			}
		}
		
		boolean result = cbdao.deleteClipBox(box);
		
		
	}


	private static void displayClipBoxes(User user) {

		List<ClipBox> boxes = cbdao.getClipBoxes(user);

		if (boxes.size()>0) {

			System.out.println(String.format("| %10s | %20s | %10s | %40s |", "Box ID", "Clip Box Owner", "Balance",
					"Description"));

			for (ClipBox clipBox : boxes) {
				System.out.println(clipBox);
			}
		} else {
			System.out.println("You have no Clip Boxes in our records.");
		}

	}

	private static ClipBox askForClipBox(User user) throws UserInputException {
		List<ClipBox> boxes = getClipBoxes(user);
		
		if (boxes.size()>0) {
			System.out.println(String.format("%s | %-20s | %-20s |", "label", "Clip Box ID", "Balance"));
			for (int i = 0; i < boxes.size(); i++) {

				System.out.println(String.format("%5d | %20s | %20d | %30s |", i + 1, boxes.get(i).getCb_id(),
						boxes.get(i).getBalance(), boxes.get(i).getDescription()));
			}
			int boxlabel;
			boxlabel = InputTools.getNaturalNumberInput(boxes.size());
			return boxes.get(boxlabel - 1);
		} else {
			System.out.println("You have no open Clip Boxes.");
			throw new UserInputException();
		}
	}
	
	public static void loadService() {
		System.out.println("Service loaded");
	}

}
