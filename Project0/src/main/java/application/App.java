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
	static int input;

	public static void main(String[] args) {
		System.out.println("Welcome to this.bank are you a registered user?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		input = Integer.parseInt(scan.nextLine());
		
		switch(input) {
		case 1:{logon();}break;
		case 2:{createAccount();}break;
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
				input = Integer.parseInt(scan.nextLine());
				
				switch(input) {
				case 1:{logon();}break;
				case 2:{createAccount();}break;
				}
			}
		}
		else {
			System.out.println("Invalid Username");
			System.out.println("Would you like to: ");
			System.out.println("1. Try again");
			System.out.println("2. Create account");
			input = Integer.parseInt(scan.nextLine());
			
			switch(input) {
			case 1:{logon();}break;
			case 2:{createAccount();}break;
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
			input = Integer.parseInt(scan.nextLine());
			
			switch(input) {
			case 1:{UserService.addUser(new User(0, username, password, 1));
					System.out.println("Account created successfully");
					menu();}break;
			case 2:{UserService.addUser(new User(0, username, password, 0));
					System.out.println("Account created successfully");
					menu();}break;
			}
		}
		
		if(UserService.addUser(new User(0, username, password, 0))) {
			System.out.println("Account created successfully");
			u = UserService.getUser(username);
			menu();
		}
		else {
			System.out.println("Would you like to: ");
			System.out.println("1. Try again");
			System.out.println("2. Log on");
			System.out.println("3. Log out");
			input = Integer.parseInt(scan.nextLine());
			
			switch(input) {
			case 1:{createAccount();}break;
			case 2:{logon();}break;
			case 3:{logout();}break;
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
		input = Integer.parseInt(scan.nextLine());
		
		switch(input) {
		case 1:{viewAccount();}break;
		case 2:{createBankAccount();}break;
		case 3:{deleteBankAccount();}break;
		case 4:{withdraw();}break;
		case 5:{deposit();}break;
		case 6:{logout();}break;
		case 7:{displayUsers();
				menu();}break;
		case 8:{createAccount();}break;
		case 9:{updateUser();}break;
		case 10:{deleteUser();}break;
		case 11:{viewUser();}break;
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
		menu();
	}

	static void deleteUser() {
		System.out.println("Which user would you like to delete?");
		displayUsers();
		int id = Integer.parseInt(scan.nextLine());
		UserService.deleteUser(id);
		System.out.println("User successfully deleted");
		menu();
	}

	static void updateUser() {
		System.out.println("Which user would you like to update?");
		displayUsers();
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Username or Password?");
		System.out.println("1. Username");
		System.out.println("2. Password");
		input = Integer.parseInt(scan.nextLine());
		
		switch(input) {
		case 1:{System.out.println("What will the new username be?");
				UserService.updateUserName(id, scan.nextLine());
				System.out.println("Username updated successfully");
				menu();}break;
		case 2:{System.out.println("What will the new password be?");
				UserService.updateUserPass(id, scan.nextLine());
				System.out.println("Password updated successfully");
				menu();}break;
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
		else
			System.out.println("No active bank accounts");
	}

	static void withdraw() {
		System.out.println("Which account would you like to withdraw from?");
		displayBankAccounts();
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("How much would you like to withdraw?");
		input = Integer.parseInt(scan.nextLine());
		if(AccountService.withdraw(id, input)) {
		System.out.println("Withdraw successful");
		menu();
		}
		else
			menu();
	}

	static void deposit() {
		System.out.println("Which account would you like to deposit into?");
		displayBankAccounts();
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("How much would you like to deposit?");
		input = Integer.parseInt(scan.nextLine());
		AccountService.deposit(id, input);
		System.out.println("Deposit successful");
		menu();
	}

	static void deleteBankAccount() {
		displayBankAccounts();
		System.out.println("Please enter account id to be deleted");
		input = Integer.parseInt(scan.nextLine());
		if(AccountService.getAccount(input).getAmount() == 0) {
			AccountService.deleteAccount(input);
			System.out.println("Account successfully deleted");
			menu();
		}
		else if(AccountService.getAccount(input).getAmount() > 0) {
			System.out.println("Account has funds would you like to:");
			System.out.println("1. Withdraw all funds and delete");
			System.out.println("2. Go back to menu");
			int id = input;
			input = Integer.parseInt(scan.nextLine());
			
			switch(input) {
			case 1:{
				AccountService.withdrawAll(id);
				AccountService.deleteAccount(id);
				System.out.println("Account successfully deleted");}break;
			case 2:{menu();}break;
			}
		}
		else {
			System.out.println("Invalid account id");
			menu();
		}
	}

	static void createBankAccount() {
		String type;
		System.out.println("What type of account would you like to create?");
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		input = Integer.parseInt(scan.nextLine());
		
		switch(input) {
		case 1:{
			type = "Checking";
			AccountService.addAccount(new Account(0, 0, type, u.getB_id()));}break;
		case 2:{
			type = "Savings";
			AccountService.addAccount(new Account(0, 0, type, u.getB_id()));}break;
			
		}
		System.out.println("Account successfully created");
		menu();
	}
	
	static void viewAccount() {
		System.out.println("Which account would you like to view?");
		displayBankAccounts();
		input = Integer.parseInt(scan.nextLine());
		List<Transaction> transactions = TransactionService.getTransactions(input);
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
			menu();
		}
		else {
			System.out.println("No account activity");
			menu();
		}
	}
	
	static void logout() {
		scan.close();
		try {
			JDBCConnection.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
