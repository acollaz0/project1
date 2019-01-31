package model;

import java.util.List;
import java.util.Scanner;

import application.App;
import service.BankAccountService;
import service.UserService;

public class Superuser extends User {
	
	/**
	 * Copy constructor - Copies the fields from a User object
	 * @param u A User object
	 */
	public Superuser(User u) {
		super(u.getUser_id(), u.getUsername(), u.getPassword(), u.getF_name(), u.getL_name(), u.getType());
	}
	
	/**
	 * startUp method
	 * Called from welcome() after a Superuser has been selected.
	 * Displays a list of all registered users and superusers.
	 * Asks a superuser to create a new user, delete a user,
	 * update a user's info, or to sign out.
	 */
	@Override
	public void startUp() {		
		
		int choice;
		
		do {
			// get the list of all users and display them
			List<User> users = UserService.allUsers();
			displayAllUsers(users);
			
			// prompt to create a user, delete a user, update user info,
			// or sign out
			System.out.println("\nWould you like to: ");
			System.out.println("1. Create a user");
			System.out.println("2. Delete a user");
			System.out.println("3. Update user info");
			System.out.println("4. Sign out");
			System.out.print("Your choice: ");
			choice = App.scan.nextInt();
			App.scan.nextLine();
			System.out.println("---------------------------------------------------------\n");
			
			switch (choice) {
				case 1: // create a user
					// Determine if a superuser will be registered or not and
					// then register the appropriate user type.
					boolean superuser = User.registerSuperuser();
					User.register(superuser);
					break;
				case 2: // delete a user as long as at least one user exists
					if (users.size() > 0) {
						System.out.println("Going to the user deletion page");
						deleteUser(users);
					} else {
						System.out.println("There are no users to delete.");
					}
					break;
				case 3: // update a user's info as long as at least one user exists
					if (users.size() > 0) {
						System.out.println("Going to the user update page");
							chooseUserToUpdate(users);
					} else {
						System.out.println("There are no users to update.");
					}
					break;
				case 4: // sign out
					System.out.println("Thank you for banking with us! Now signing you out.");
					break;
				default: // incorrect input
					System.out.println("Incorrect choice. Please select an option from 1-4.");
					break;	
			}
			System.out.println();
			// loop until the user says to sign out
		} while(choice != 4);		
	}
	
	/**
	 * displayAllUsers method
	 * Displays all users in the database. All user fields
	 * are shown.
	 * @param users The list of all users in the database
	 */
	public void displayAllUsers(List<User> users) {
		System.out.println("---------------------------------------------------------");
		System.out.println("All Registered Users");
		System.out.println("--------------------");
		
		// only display users as long as at least one exists
		if (users.size() > 0) {
		
			// format column names
			System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "User ID", "Username", 
					"Pasword", "First Name", "Last Name", "Type");
			System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "----------", "----------", 
					"----------", "----------", "----------", "----------");
			
			// display each user's info
			for (User user : users) {
				displayUser(user);
			}
		} else {
			System.out.println("NO USERS FOUND");
		}
	}
	
	/**
	 * displayUser method
	 * Displays the fields for one User
	 * @param user One User
	 */
	public void displayUser(User user) {
		
		System.out.printf("%-15d%-15s%-15s%-15s%-15s%-15s\n", user.getUser_id(), user.getUsername(), user.getPassword(),
				user.getF_name(), user.getL_name(), user.getType());
	}
	
	/**
	 * deleteUser method
	 * Prompts the superuser for an user ID to delete. Deletes that user
	 * as long as that user exists and does not have money in any of their accounts.
	 * @param users A list of all users in the database
	 */
	public void deleteUser(List<User> users) {
		
		// ask the superuser to enter the user id of the user they want to delete
		System.out.println("\n---------------------------------------------------------");
		System.out.println("Enter the user ID of the user you want to delete");
		System.out.print("User ID: ");
		int enteredid = App.scan.nextInt();
		System.out.println("---------------------------------------------------------\n");
		
		// the superuser can not delete themself
		if (enteredid != super.getUser_id()) {
			boolean valid = false;
			int index = 0;
			
			// the user must exist in the database to be eligible for deletion
			while ((!valid) && (index < users.size())) {
				
				// get a user ID from the list of users
				int validid = users.get(index).getUser_id();
				
				// check if the entered ID matches an ID from the list of Users
				if (validid == enteredid) {
					valid = true;
					
					// Get all bank accounts for this user and check to see if any of their
					// accounts have money in them. If so, this user cannot be deleted. 
					List<BankAccount> accounts = BankAccountService.allBankAccounts(validid);
					boolean delete = true;
					for (BankAccount account : accounts) {
						if (account.getBalance() > 0.0) {
							System.out.println("Error! You cannot delete a user with money in their accounts.");
							delete = false;
							break;
						}
					}
					
					// Delete the user if no money was found in any of their accounts
					if (delete) {
						// delete the user
						UserService.deleteUser(validid);
						System.out.println("Successfully deleted user number " + validid);
					}
					
				}
				index++;
			}
			
			if (!valid) {
				System.out.println("Account does not exist");
			}
		} else {
			System.out.println("You cannot delete your own superuser account while it is in use.");
		}
	}
	
	/**
	 * chooseUserToUpdate method
	 * Prompts a superuser to entered the user ID for a user they want to update.
	 * The user can be updated as long as they exist in the database.
	 * @param users A list of all Users in the database
	 */
	public void chooseUserToUpdate(List<User> users) {
		
		// prompt the superuser for a user to update
		System.out.println("\n---------------------------------------------------------");
		System.out.println("Enter the user ID of the user you want to update");
		System.out.print("User ID: ");
		int enteredid = App.scan.nextInt();
		System.out.println("---------------------------------------------------------\n");
	
		boolean valid = false;
		int index = 0;
		
		// the user is eligible to be updated as long as they exist
		while ((!valid) && (index < users.size())) {
			
			// get the user id of a user in the list
			int validid = users.get(index).getUser_id();
			
			// if the entered id matches a user id, the user can be updated
			if (validid == enteredid) {
				valid = true;
				
				// call the updateUserInfo method for this user
				updateUserInfo(users.get(index).getUsername());
			}
			index++;
		}
		
		if (!valid) {
			System.out.println("Account does not exist");
		}
	}
	
	/**
	 * updateUserInfo method
	 * Prompts the superuser to update a user's information
	 * The username, password, first name, and last name fields can be updated.
	 * @param username The name of a User to update
	 */
	public void updateUserInfo(String username) {
		
		int choice;
		String update;
		
		do {
			System.out.println("---------------------------------------------------------\n");
			// get the User from the database which has the given username
			User u = UserService.getUser(username);
			
			// display the column headings for this user's fields
			System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "User ID", "Username", "Pasword", 
					"First Name", "Last Name", "Type");
			System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "----------", "----------", "----------",
					"----------", "----------", "----------");
			
			// display the fields for this user
			displayUser(u);
			
			// Ask which field to update: username, password, first name, or last name
			// Can also return to the list of all users
			System.out.println("\nWould you like to update: ");
			System.out.println("1. Username");
			System.out.println("2. Password");
			System.out.println("3. First name");
			System.out.println("4. Last name");
			System.out.println("5. Return to list of users");
			System.out.print("Your choice: ");
			choice = App.scan.nextInt();
			App.scan.nextLine();
			System.out.println("---------------------------------------------------------\n");
			
			switch (choice) {
				case 1: // username
					// prompt for a new username
					System.out.print("Enter new username: ");
					update = App.scan.nextLine();
					
					// can't update to this username if it is already in use
					if (UserService.getUser(update) != null) {
						System.out.println("Username already exists. Please pick a different username.");
					} else {
						// update this user's username in the database
						u.setUsername(update);
						UserService.updateUser(u);
						
						// updating the username variable here is necessary to get 
						// the correct user on the next iteration of the loop
						username = update;
						System.out.println("Successfully updated username");
					}
					break;
				case 2: // password
					// prompt for a new password
					System.out.print("Enter new password: ");
					update = App.scan.nextLine();
					
					// update this user's password in the database
					u.setPassword(update);
					UserService.updateUser(u);
					System.out.println("Successfully updated password");
					break;
				case 3: // first name
					// prompt for a new first name
					System.out.print("Enter new first name: ");
					update = App.scan.nextLine();
					
					// update this user's first name in the database
					u.setF_name(update);
					UserService.updateUser(u);
					System.out.println("Successfully updated first name");
					break;
				case 4: // last name
					System.out.print("Enter new last name: ");
					update = App.scan.nextLine();
					
					// update this user's last name in the database
					u.setL_name(update);
					UserService.updateUser(u);
					System.out.println("Successfully updated last name");
					break;
				case 5: // return to list of all users
					System.out.println("Returning to list of users");
					break;
				default: // incorrect input
					System.out.println("Incorrect choice. Please select an option from 1-5.");
					break;
			}
			System.out.println();
			// loop until the superuser decides to return to the list of all users
		} while(choice != 5);
	}
}
