package bank;

import java.util.*;
import model.*;
import service.*;

public class PowerBank{
	public static final Scanner scan = new Scanner(System.in);
	//public static Connection con = JDBCConnection.getConnection();
	public static User u=new User();
	public static Account a=new Account();
	public static void main(String[] args) {


		start();
			
		scan.close();
	}
	public static void login() {
		String username;
		String password;
			System.out.println("Username:");
			username = scan.nextLine();
			System.out.println("Password:");
			password = scan.nextLine();
			User u = new User(username,password);
			u=UserService.getUser(u);			
			if(u!=null) {
				if(u.getU_id()%2==0) {
				home(u);
				}
				else {
					superHome(u);
				}
			}
			else {
			System.out.println("Incorrect username or password");
				login();
			}
		}
	
	public static void home(User u) {
		System.out.println("Welcome, "+ u.getFirst() +", to the Battery Bank!" );
		AccountService.getAccount(u.getU_id());
		System.out.println("What would you like to do today?");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Create Account");
		System.out.println("4. Delete Account");
		System.out.println("5. View Account");
		System.out.println("0. Exit");
			switch(scan.nextLine()) {
			case "0":{
				System.out.println("Have a nice day!");
				start();
				break;
			}
			case "4":{
				System.out.println("Which account would you like to delete?");
				int accnum = Integer.parseInt(scan.nextLine());
				if(AccountService.getAmount(accnum)!=0.00) {
					System.out.println("Please withdraw remaining amount if you wish to close the account");
					home(u);
				}
				System.out.println("Are you sure? (y/n)");
				String check = scan.nextLine();
				if(check.equals("y")) {
				AccountService.deleteAccount(accnum);
				}
				else {
					System.out.println("OK");
				}
				home(u);
				break;	
			}
			case "1":{
				System.out.println("Which account would you like to withdraw from?");
				int accnum = Integer.parseInt(scan.nextLine());
				System.out.println("How much would you like to withdraw?");
				double with = Double.parseDouble(scan.nextLine());
				if(AccountService.getAmount(accnum)-with<0.00) {
					System.out.println("There is not enough in account to withdraw that amount");
					scan.nextLine();
					home(u);
				}
				else {
				AccountService.withdraw(accnum,with);
				}
				home(u);
				break;
			}
			case "2":{
				System.out.println("Which account would you like to deposit to?");
				int accnum = Integer.parseInt(scan.nextLine());
				System.out.println("How much would you like to deposit?");
				double dep = Double.parseDouble(scan.nextLine());
				AccountService.deposit(accnum,dep);
				home(u);
				break;
			}
			case "3":{
				AccountService.createAccount(u);
				System.out.println("An account has been created for you");
				home(u);
				break;
			}
			case "5":{
				System.out.println("Which account would you like to view?");
				int accnum = Integer.parseInt(scan.nextLine());
				TransactionService.getTransaction(accnum);
				scan.nextLine();
				home(u);
				break;
			}
			default:{
				System.out.println("Please choose an available option.");
				home(u);
			}
			}
	}
	public static void register() {
			System.out.println("First name:");
			String first=scan.next();
			System.out.println("Last name:");
			String last=scan.next();
			System.out.println("Username:");
			String username=scan.next();
			System.out.println("Password:");
			String password=scan.next();

			User u = new User(username, password, first, last);
			u=UserService.addUser(u);
			home(u);
	}
	public static void start() {
		System.out.println("Welcome to the Battery Bank!");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("0. Exit");
		
			switch(scan.nextLine()) {
			case "0":case"Exit":case"exit":{
				break;
			}
			case "1":case "Login":case"login":{
				login();
				break;
				
			}
			case "2":case"Register":case"register":{
				register();
				break;
			}
			default:{
				System.out.println("Please choose an available option.");	
				start();
			}			
	}	
	}
	public static void superHome(User u) {
		System.out.println("What would you like to do today?");
		System.out.println("1. View all accounts");
		System.out.println("2. Update User");
		System.out.println("3. Create User");
		System.out.println("4. Delete User");
		System.out.println("5. Create Super User");
		System.out.println("0. Exit");
			switch(scan.nextLine()) {
			case "0":{
				System.out.println("Have a nice day!");
				start();
				break;
			}
			case "4":{
				System.out.println("Which User would you like to delete?");
				UserService.getAll();
				int uid = Integer.parseInt(scan.nextLine());
				System.out.println("Are you sure? (y/n)");
				String check = scan.nextLine();
				if(check.equals("y")) {
				UserService.deleteUser(uid);
				}
				else {
					System.out.println("OK");
				}
				superHome(u);
				break;	
			}
			case "1":{
				UserService.getAll();
				superHome(u);
				break;
			}
			case "2":{
				System.out.println("Which User would you like to update?");
				int uid = Integer.parseInt(scan.nextLine());
				System.out.println("First name:");
				String first=scan.next();
				System.out.println("Last name:");
				String last=scan.next();
				System.out.println("Username:");
				String username=scan.next();
				System.out.println("Password:");
				String password=scan.next();
				
				User u2 = new User(uid,username, password, first, last);
				UserService.updateUser(u2);
				superHome(u);
				break;
			}
			case "3":{
				System.out.println("First name:");
				String first=scan.next();
				System.out.println("Last name:");
				String last=scan.next();
				System.out.println("Username:");
				String username=scan.next();
				System.out.println("Password:");
				String password=scan.next();

				User u2 = new User(username, password, first, last);
				u2=UserService.addUser(u2);
				superHome(u);
				break;
			}
			case"5":{
				System.out.println("First name:");
				String first=scan.next();
				System.out.println("Last name:");
				String last=scan.next();
				System.out.println("Username:");
				String username=scan.next();
				System.out.println("Password:");
				String password=scan.next();

				User u2 = new User(username, password, first, last);
				u2=UserService.addSuperUser(u2);
				superHome(u);
				break;
			}
			default:{
				System.out.println("Please choose an available option.");
				superHome(u);
			}
			}
	}

}
