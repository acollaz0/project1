package model;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import application.App;
import service.BankAccountService;

public class RegularUser extends User {
	
	/**
	 * Copy constructor - Copies the fields from a User object
	 * @param u A User object
	 */
	public RegularUser(User u) {
		super(u.getUser_id(), u.getUsername(), u.getPassword(), u.getF_name(), u.getL_name(), u.getType());
	}
	
	/**
	 * startUp method
	 * Called from welcome() after a RegularUser has been selected.
	 * Displays this user's list of bank accounts. Prompts user to 
	 * create a new savings/checking account, to delete an account,
	 * or to view an account in more detail. Loops until the user
	 * says they want to sign out.
	 */
	@Override
	public void startUp() {
		
		int choice;
		
		do {			
			// get a list of bank accounts for this user and pass them to a method to display them
			List<BankAccount> bankaccounts = BankAccountService.allBankAccounts(super.getUser_id());
			displayAllAccounts(bankaccounts);
			
			// prompt the user for input
			System.out.println("\nWould you like to: ");
			System.out.println("1. Create a savings account");
			System.out.println("2. Create a checking account");
			System.out.println("3. Delete an account");
			System.out.println("4. View an account in detail");
			System.out.println("5. Sign out");
			System.out.print("Your choice: ");
			choice = App.scan.nextInt();
			App.scan.nextLine();
			System.out.println("---------------------------------------------------------\n");
			
			switch (choice) {
				case 1: // create a savings account
					createAccount("savings");
					break;
				case 2: // create a checking account
					createAccount("checking");
					break;
				case 3: // delete an account as long as there is at least one to delete
					if (bankaccounts.size() > 0) {
						System.out.println("Going to the account deletion page");
						deleteAccount(bankaccounts);
					} else {
						System.out.println("You have no accounts to delete.");
					}
					break;
				case 4: // view an account in detail as long as there is at least one to view
					if (bankaccounts.size() > 0) {
						System.out.println("Going to the detailed account view page");
						detailedAccountView(bankaccounts);
					} else {
						System.out.println("You have no accounts to view.");
					}
					break;
				case 5: // sign out
					System.out.println("Thank you for banking with us! Now signing you out.");
					break;
				default: // incorrect input
					System.out.println("Incorrect choice. Please select an option from 1-5.");
					break;	
			}
			System.out.println();
			
		} while(choice != 5);
		
	}
	
	/**
	 * displayAllAccounts method
	 * Displays the account ID, balance, and type for each bank account
	 * @param bankaccounts A list of bank accounts to display
	 */
	public void displayAllAccounts(List<BankAccount> bankaccounts) {
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Your bank accounts");
		System.out.println("------------------");
		
		// only display the accounts if at least one exists
		if (bankaccounts.size() > 0) {
			// format column headings
			DecimalFormat dollar = new DecimalFormat("#,##0.00");
			System.out.printf("%-15s%-15s%-15s\n", "Account ID", "Balance", "Type");
			System.out.printf("%-15s%-15s%-15s\n", "---------", "---------", "---------");
			
			// loop through each bank account and display its fields
			for (BankAccount account : bankaccounts) {
				System.out.printf("%-15d$%-15s%-15s\n", 
						account.getBank_account_id(), dollar.format(account.getBalance()), account.getType());
			}
		} else {
			System.out.println("NO ACCOUNTS FOUND");
		}
	}
	
	/**
	 * createAccount method
	 * Creates a new bank account of the specified type for this user
	 * @param type The type of account to open (i.e. savings or checking)
	 */
	public void createAccount(String type) {
		
		// Create a new bank account using this user's user_id. Initialize the account
		// balance to $0 and give it the specified type.
		if (BankAccountService.addBankAccount(super.getUser_id(), new BankAccount(0, type))) {
			System.out.println("Successfully created a new " + type + " account.");
			
		} else {
			System.out.println("Error creating a new bank account. Please try again.");
		}	
	}
	
	/**
	 * deleteAccount method
	 * Prompts for an account ID to delete. Deletes it if that account ID exists
	 * and belongs to THIS user and has no money in it.
	 * @param bankaccounts The list of bank accounts associated with this user
	 */
	public void deleteAccount(List<BankAccount> bankaccounts) {
		
		// prompt for an account id to delete
		System.out.println("\n---------------------------------------------------------");
		System.out.println("Enter the account ID of the account you want to delete");
		System.out.print("Account ID: ");
		int enteredid = App.scan.nextInt();
		System.out.println("---------------------------------------------------------\n");
	
		boolean valid = false;
		int index = 0;
		
		// the entered account ID must exist and must belong to THIS user to be eligible for deletion
		while ((!valid) && (index < bankaccounts.size())) {
			// get the next account id from the list of bank accounts for this user
			int validid = bankaccounts.get(index).getBank_account_id();
			
			// check if the entered id matches an id from the list of accounts
			if (validid == enteredid) {
				valid = true;
				
				// delete the account as long as there is no money in it
				if (bankaccounts.get(index).getBalance() > 0.0) {
					System.out.println("Error! You cannot delete an account with money in it.");
				} else {
					// delete the account
					BankAccountService.deleteBankAccount(validid);
					System.out.println("Successfully deleted account number " + validid);
				}		
			}
			index++;
		}
		
		// Display a message saying the account does not exist if the entered id
		// does not match one of this user's bank account
		if (!valid) {
			System.out.println("Account does not exist");
		}
	}
	
	/**
	 * detailedAccountView method
	 * Prompts for an account ID to view in more detail. Calls a method to view transactions
	 * for that account if that account ID exists and belongs to THIS user.
	 * @param bankaccounts The list of bank accounts associated with this user
	 */
	public void detailedAccountView(List<BankAccount> bankaccounts) {
		
		// prompt for an account id to view in more detail
		System.out.println("\n---------------------------------------------------------");
		System.out.println("Enter the account ID of the account you want to view in detail");
		System.out.print("Account ID: ");
		int enteredid = App.scan.nextInt();
		System.out.println("---------------------------------------------------------\n");
	
		boolean valid = false;
		int index = 0;
		
		// the entered account ID must exist and must belong to THIS user to be eligible for detailed viewing
		while ((!valid) && (index < bankaccounts.size())) {
			// get the next account id from the list of bank accounts for this user
			int validid = bankaccounts.get(index).getBank_account_id();
			
			// check if the entered id matches an id from the list of accounts
			if (validid == enteredid) {
				valid = true;
				
				// call a method to view transactions for this bank account
				bankaccounts.get(index).viewTransactions();
			}
			index++;
		}
		
		// Display a message saying the account does not exist if the entered id
		// does not match one of this user's bank account
		if (!valid) {
			System.out.println("Account does not exist");
		}
		
	}
}
