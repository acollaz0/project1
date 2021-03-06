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
import util.MyLogger;

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
		if(UserService.getUser(username) != null && !username.equals("")) {
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
			if(UserService.getUser(username) != null) {
				System.out.println("Username is unavailable");
				createAccount();
			}
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
		
		if(!username.equals("") && UserService.addUser(new User(0, username, password, 0))) {
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
			System.out.println("11. View user");
		}
		input = scan.nextLine();
		
		switch(input) {
		case "1":{viewAccount();}break;
		case "2":{createBankAccount();}break;
		case "3":{deleteBankAccount();}break;
		case "4":{withdraw();}break;
		case "5":{deposit();}break;
		case "6":{logout();}break;
		case "7":{if (u.isSuper() == 1) {
					displayUsers();
					System.out.println("Press Enter to continue");
					scan.nextLine();
					menu();}}
		case "8":{if (u.isSuper() == 1)
					createAccount();}
		case "9":{if (u.isSuper() == 1)
					updateUser();}
		case "10":{if (u.isSuper() == 1)
					deleteUser();}
		case "11":{if (u.isSuper() == 1)
					viewUser();}
		default:{System.out.println("Invalid input try again");
				menu();}
		}
	}
	
	static void viewUser() {
		System.out.println("Enter Username of user you would like to view");
		input = scan.nextLine();
		User us = UserService.getUser(input);
		boolean contains = false;
		for(User user:UserService.allUsers()) {
			if(user.getUsername().equals(input)) {
				contains = true;
			}
		}
		if(contains == false) {
			System.out.println("Invalid input");
			System.out.println("1. Try again");
			System.out.println("2. Back to menu");
			input = scan.nextLine();
			switch(input) {
			case "1":{viewUser();}break;
			case "2":{menu();}break;
			default:{menu();}
			}
		}
		System.out.println("----------------------------------------------");
		System.out.printf("%15s %15s %10s", "User ID", "Username", "Password");
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.format("%15s %15s %10s", us.getB_id(), us.getUsername(), us.getPassword());
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
		input = scan.nextLine();
		boolean contains = false;
		if(input.matches("[0-9]+")) {
			for(User user:UserService.allUsers()) {
				if(user.getB_id() == Integer.parseInt(input)) {
					contains = true;
				}
			}
		}
		if(contains == false) {
			System.out.println("Invalid input");
			System.out.println("1. Try again");
			System.out.println("2. Back to menu");
			input = scan.nextLine();
			switch(input) {
			case "1":{deleteUser();}break;
			case "2":{menu();}break;
			default:{menu();}
			}
		}
		int id = Integer.parseInt(input);
		UserService.deleteUser(id);
		System.out.println("User successfully deleted");
		System.out.println("Press Enter to continue");
		scan.nextLine();
		menu();
	}

	static void updateUser() {
		System.out.println("Which user would you like to update?");
		System.out.println("Please enter user ID");
		displayUsers();
		input = scan.nextLine();
		boolean contains = false;
		if(input.matches("[0-9]+")) {
			for(User user:UserService.allUsers()) {
				if(user.getB_id() == Integer.parseInt(input)) {
					contains = true;
				}
			}
		}
		if(contains == false) {
			System.out.println("Invalid input try again");
			updateUser();
		}
		
		int id = Integer.parseInt(input);
		System.out.println("Username or Password?");
		System.out.println("1. Username");
		System.out.println("2. Password");
		System.out.println("3. Super");
		System.out.println("4. Back to menu");
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
		case "4":{menu();}break;
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
				System.out.format("%15s %15s %6s%.2f", acc.getA_id(), acc.getType(), "$", acc.getAmount());
				System.out.println();
			}
			System.out.println("----------------------------------------------");
		}
		else {
			System.out.println("No active bank accounts");
		}
	}

	static void withdraw() {
		if(AccountService.allAccounts(u.getB_id()).size() == 0) {
			System.out.println("No active bank accounts");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			menu();
		}
		System.out.println("Which account would you like to withdraw from?");
		System.out.println("Please enter account ID");
		displayBankAccounts();
		input = scan.nextLine();
		boolean contains = false;
		if(input.matches("[0-9]+")) {
			for(Account acc:AccountService.allAccounts(u.getB_id())) {
				if(acc.getA_id() == Integer.parseInt(input)) {
					contains = true;
				}
			}
		}
		if(contains == false) {
			System.out.println("Invalid input try again");
			withdraw();
		}
		if(input.matches("[0-9]+")) {
			int id = Integer.parseInt(input);
			System.out.println("How much would you like to withdraw?");
			input = scan.nextLine();
			if(input.matches("[0-9]+.[0-9]{2}") || input.matches("[0-9]+")) {
				AccountService.withdraw(id, Double.parseDouble(input));
				System.out.println("Withdraw successful");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();
			}
			else if(!input.matches("[0-9]+")){
				System.out.println("Invalid input try again");
				withdraw();
			}
			else {
				//sql exception catches insufficient funds and prints
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();
			}
		}
		else {
			System.out.println("Invalid input try again");
			withdraw();
		}
	}

	static void deposit() {
		if(AccountService.allAccounts(u.getB_id()).size() == 0) {
			System.out.println("No active bank accounts");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			menu();
		}
		System.out.println("Which account would you like to deposit into?");
		System.out.println("Please enter account ID");
		displayBankAccounts();
		input = scan.nextLine();
		boolean contains = false;
		if(input.matches("[0-9]+")) {
			for(Account acc:AccountService.allAccounts(u.getB_id())) {
				if(acc.getA_id() == Integer.parseInt(input)) {
					contains = true;
				}
			}
		}
		if(contains == false) {
			System.out.println("Invalid input try again");
			deposit();
		}
		if(input.matches("[0-9]+")) {
			int id = Integer.parseInt(input);
			System.out.println("How much would you like to deposit?");
			input = scan.nextLine();
			if(input.matches("[0-9]+.[0-9]{2}") || input.matches("[0-9]+")) {
				AccountService.deposit(id, Double.parseDouble(input));
				System.out.println("Deposit successful");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				menu();
			}
			else {
				System.out.println("Invalid input try again");
				deposit();
			}
		}
		else {
			System.out.println("Invalid input try again");
			deposit();
		}
	}

	static void deleteBankAccount() {
		displayBankAccounts();
		if(AccountService.allAccounts(u.getB_id()).size() == 0) {
			System.out.println("No active accounts");
			menu();
		}
		System.out.println("Please enter account id to be deleted");
		input = scan.nextLine();
		boolean contains = false;
		if(input.matches("[0-9]+")) {
			for(Account acc:AccountService.allAccounts(u.getB_id())) {
				if(acc.getA_id() == Integer.parseInt(input)) {
					contains = true;
				}
			}
		}
		if(contains == false) {
			System.out.println("Invalid input try again");
			deleteBankAccount();
		}
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
			default:{System.out.println("Invalid input try again");
					deleteBankAccount();}
			}
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
		default:{System.out.println("Invalid input try again");
				createBankAccount();}
			
		}
		System.out.println("Account successfully created");
		System.out.println("Press Enter to continue");
		scan.nextLine();
		menu();
	}
	
	static void viewAccount() {
		if(AccountService.allAccounts(u.getB_id()).size() > 0) {
			System.out.println("Which account would you like to view?");
			System.out.println("Please enter account ID");
			displayBankAccounts();
			input = scan.nextLine();
			boolean contains = false;
			if(input.matches("[0-9]+")) {
				for(Account acc:AccountService.allAccounts(u.getB_id())) {
					if(acc.getA_id() == Integer.parseInt(input)) {
						contains = true;
					}
				}
			}
			if(contains == false) {
				System.out.println("Invalid input try again");
				viewAccount();
			}
			if(input.matches("[0-9]+")) {
				List<Transaction> transactions = TransactionService.getTransactions(Integer.parseInt(input));
			
				if(transactions.size() > 0) {
			
					System.out.printf("%45s", "Transactions for account "+input);
					System.out.println();
					System.out.println("------------------------------------------------------------------");
					System.out.printf("%20s %20s %20s","Date\\Time", "Difference", "Balance");
					System.out.println();
					System.out.println("------------------------------------------------------------------");
					for(Transaction tra: transactions) {
						System.out.format("%20s %20s %14s%.2f", tra.getDatetime(), tra.getChange(), "$", tra.getTotal());
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
				System.out.println("Invalid input try again");
				viewAccount();
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
			MyLogger.logger.info("User disconnected from database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}