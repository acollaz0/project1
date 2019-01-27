package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Account;
import model.Transaction;
import model.User;
import service.AccountService;
import service.TransactionService;
import service.UserService;
import util.JDBCConnection;

public class App {
	
	static Scanner scan = new Scanner(System.in);
	static User u = new User();
	static String input;

	public static void main(String[] args) {
		System.out.println("Welcome to this.bank are you a registered user?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		input = scan.nextLine();
		
		switch(input) {
		case "1":{logon();}break;
		case "2":{createAccount();}break;
		default:{System.out.println("Invalid input try again.");
				main(args);}
		}
	}
	
	static void logon() {
		String username;
		String password;
		
		System.out.println("Please enter your username: ");
		username = scan.nextLine();
		if(UserService.getUser(username) != null) {
			System.out.println("Please enter your password: ");
			password = scan.nextLine();
			if(UserService.getUser(username).getPassword().equals(password)) {
				u = UserService.getUser(username);
				menu();
			}
			else {
				System.out.println("Invalid Password");
				System.out.println("Would you like to: ");
				System.out.println("1. Try again");
				System.out.println("2. Create account");
				System.out.println("3. Exit");
				input = scan.nextLine();
				
				switch(input) {
				case "1":{logon();}break;
				case "2":{createAccount();}break;
				case "3":{logout();}break;
				default:{System.out.println("Invalid input try again");
						logon();}
				}
			}
		}
		else {
			System.out.println("Invalid Username");
			System.out.println("Would you like to: ");
			System.out.println("1. Try again");
			System.out.println("2. Create account");
			System.out.println("3. Exit");
			input = scan.nextLine();
			
			switch(input) {
			case "1":{logon();}break;
			case "2":{createAccount();}break;
			case "3":{logout();}break;
			default:{System.out.println("Invalid input try again");
					logon();}
			}
		}
	}
	
	static void createAccount() {
		String username;
		String password;
		
		System.out.println("Please enter new Username");
		username = scan.nextLine();
		System.out.println("Please enter new Password");
		password = scan.nextLine();
		if(u.isSuper()==1) {
			System.out.println("Would you like this user to be an admin?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			input = scan.nextLine();
			
			switch(input) {
			case "1":{UserService.addUser(new User(0, username, password, 1));
					System.out.println("Account created successfully");
					System.out.println("Press Enter to continue");
					scan.nextLine();
					menu();}break;
			case "2":{UserService.addUser(new User(0, username, password, 0));
					System.out.println("Account created successfully");
					System.out.println("Press Enter to continue");
					scan.nextLine();
					menu();}break;
			default:{System.out.println("Invalid input try again");
					createAccount();}
			}
		}
		
		if(UserService.addUser(new User(0, username, password, 0))) {
			System.out.println("Account created successfully");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			u = UserService.getUser(username);
			menu();
		}
		else {
			System.out.println("Would you like to: ");
			System.out.println("1. Try again");
			System.out.println("2. Log on");
			System.out.println("3. Log out");
			input = scan.nextLine();
			
			switch(input) {
			case "1":{createAccount();}break;
			case "2":{logon();}break;
			case "3":{logout();}break;
			default:{System.out.println("Invalid input try again");
					createAccount();}
			}
		}
	}
	
	static void menu() {
		System.out.println("Welcome "+u.getUsername());
		displayBankAccounts();
		System.out.println("Would you like to: ");
		System.out.println("1. View account");
		System.out.println("2. Create new account");
		System.out.println("3. Delete existing account");
		System.out.println("4. Withdraw from an account");
		System.out.println("5. Deposit into an account");
		System.out.println("6. Log out");
		if(u.isSuper() == 1) {
			System.out.println("7. View all users");
			System.out.println("8. Create new user");
			System.out.println("9. Update user");
			System.out.println("10. Delete user");
		}
		input = scan.nextLine();
		
		switch(input) {
		case "1":{viewAccount();}break;
		case "2":{createBankAccount();}break;
		case "3":{deleteBankAccount();}break;
		case "4":{withdraw();}break;
		case "5":{deposit();}break;
		case "6":{logout();}break;
		case "7":{displayUsers();
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();}break;
		case "8":{createAccount();}break;
		case "9":{updateUser();}break;
		case "10":{deleteUser();}break;
		case "11":{viewUser();}break;
		default:{System.out.println("Invalid input try again");
				menu();}
		}
	}
	
	static void viewUser() {
		System.out.println("Enter Username of user you would like to view");
		User u = UserService.getUser(scan.nextLine());
		System.out.println("----------------------------------------------");
		System.out.printf("%15s %15s %10s", "User ID", "Username", "Password");
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.format("%15s %15s %10s", u.getB_id(), u.getUsername(), u.getPassword());
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("Press Enter to continue");
		scan.nextLine();
		menu();
	}

	static void deleteUser() {
		System.out.println("Which user would you like to delete?");
		System.out.println("Please enter user ID");
		displayUsers();
		int id = Integer.parseInt(scan.nextLine());
		UserService.deleteUser(id);
		System.out.println("User successfully deleted");
		System.out.println("Press Enter to continue");
		scan.nextLine();
		menu();
	}

	static void updateUser() {
		System.out.println("Which user would you like to update?");
		displayUsers();
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Username or Password?");
		System.out.println("1. Username");
		System.out.println("2. Password");
		System.out.println("3. Super");
		input = scan.nextLine();
		
		switch(input) {
		case "1":{System.out.println("What will the new username be?");
				UserService.updateUserName(id, scan.nextLine());
				System.out.println("Username updated successfully");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();}break;
		case "2":{System.out.println("What will the new password be?");
				UserService.updateUserPass(id, scan.nextLine());
				System.out.println("Password updated successfully");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();}break;
		case "3":{System.out.println("Would you like this user to be a super user?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				input = scan.nextLine();
				switch(input) {
				case "1":{UserService.updateUserSuper(id, 1);}break;
				case "2":{UserService.updateUserSuper(id, 0);}break;
				}
				System.out.println("Super updated sucessfully");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();}break;
		default:{System.out.println("Invalid input try again");
				updateUser();}
		}
	}

	static void displayUsers() {
		List<User> users = UserService.allUsers();
		System.out.println("----------------------------------------------");
		System.out.printf("%15s %15s %10s", "User ID", "Username", "Password");
		System.out.println();
		System.out.println("----------------------------------------------");
		for(User u:users) {
			System.out.format("%15s %15s %10s", u.getB_id(), u.getUsername(), u.getPassword());
			System.out.println();
		}
		System.out.println("----------------------------------------------");
	}

	static void displayBankAccounts() {
		List<Account> accounts = AccountService.allAccounts(u.getB_id());
		if(accounts.size() > 0) {
			System.out.println("----------------------------------------------");
			System.out.printf("%15s %15s %10s", "Account ID", "Account Type", "Total");
			System.out.println();
			System.out.println("----------------------------------------------");
			for(Account acc: accounts) {
				System.out.format("%15s %15s %10s", acc.getA_id(), acc.getType(), "$"+acc.getAmount());
				System.out.println();
			}
			System.out.println("----------------------------------------------");
		}
		else {
			System.out.println("No active bank accounts");
		}
	}

	static void withdraw() {
		System.out.println("Which account would you like to withdraw from?");
		displayBankAccounts();
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("How much would you like to withdraw?");
		input = scan.nextLine();
		if(AccountService.withdraw(id, Integer.parseInt(input))) {
		System.out.println("Withdraw successful");
		System.out.println("Press Enter to continue");
		scan.nextLine();
		menu();
		}
		else {
			System.out.println("Press Enter to continue");
			scan.nextLine();
			menu();
		}
	}

	static void deposit() {
		System.out.println("Which account would you like to deposit into?");
		displayBankAccounts();
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("How much would you like to deposit?");
		input = scan.nextLine();
		AccountService.deposit(id, Integer.parseInt(input));
		System.out.println("Deposit successful");
		System.out.println("Press Enter to continue");
		scan.nextLine();
		menu();
	}

	static void deleteBankAccount() {
		displayBankAccounts();
		System.out.println("Please enter account id to be deleted");
		input = scan.nextLine();
		if(AccountService.getAccount(Integer.parseInt(input)).getAmount() == 0) {
			AccountService.deleteAccount(Integer.parseInt(input));
			System.out.println("Account successfully deleted");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			menu();
		}
		else if(AccountService.getAccount(Integer.parseInt(input)).getAmount() > 0) {
			System.out.println("Account has funds would you like to:");
			System.out.println("1. Withdraw all funds and delete");
			System.out.println("2. Go back to menu");
			int id = Integer.parseInt(input);
			input = scan.nextLine();
			
			switch(input) {
			case "1":{
				AccountService.withdrawAll(id);
				AccountService.deleteAccount(id);
				System.out.println("Account successfully deleted");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();}break;
			case "2":{menu();}break;
			}
		}
		else {
			System.out.println("Invalid account id");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			menu();
		}
	}

	static void createBankAccount() {
		String type;
		System.out.println("What type of account would you like to create?");
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		input = scan.nextLine();
		
		switch(input) {
		case "1":{
			type = "Checking";
			AccountService.addAccount(new Account(0, 0, type, u.getB_id()));}break;
		case "2":{
			type = "Savings";
			AccountService.addAccount(new Account(0, 0, type, u.getB_id()));}break;
			
		}
		System.out.println("Account successfully created");
		System.out.println("Press Enter to continue");
		scan.nextLine();
		menu();
	}
	
	static void viewAccount() {
		if(AccountService.allAccounts(u.getB_id()).size() > 0) {
			System.out.println("Which account would you like to view?");
			displayBankAccounts();
			input = scan.nextLine();
			List<Transaction> transactions = TransactionService.getTransactions(Integer.parseInt(input));
			if(transactions.size() > 0) {
			
				System.out.printf("%45s", "Transactions for account "+input);
				System.out.println();
				System.out.println("------------------------------------------------------------------");
				System.out.printf("%10s %20s %30s", "Difference", "Balance", "Date");
				System.out.println();
				System.out.println("------------------------------------------------------------------");
				for(Transaction tra: transactions) {
					System.out.format("%10s %20s %30s", tra.getChange(), tra.getTotal(), tra.getDatetime());
					System.out.println();
				}
				System.out.println("------------------------------------------------------------------");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();
			}
			else {
				System.out.println("No account activity");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();
			}
		}
		else {
			System.out.println("No active accounts");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			menu();
		}
	}
	
	static void logout() {
		System.out.println("Goodbye");
		scan.close();
		try {
			JDBCConnection.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
