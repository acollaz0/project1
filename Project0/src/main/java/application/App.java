package application;

import java.util.Scanner;

import model.User;
import model.UserFactory;
import service.UserService;

public class App {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// create a superuser if one does not already exist
		UserService.addUser(new User("admin_a", "manager", "Admin", "A", "superuser"));
		
		// call the welcome method, which will allow you to sign in, register, or exit
		welcome();
		scan.close();
	}
	
	/**
	 * welcome method
	 * Prompts the user to sign in, register, or exit
	 */
	public static void welcome() {
				
		int choice;
		
		do {
			// prompt for user input
			System.out.println("---------------------------------------------------------");
			System.out.println("Welcome to the Bank");
			System.out.println("-------------------");
			System.out.println("Would you like to: ");
			System.out.println("1. Sign In");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print("Your choice: ");
			choice = scan.nextInt();
			scan.nextLine();
			System.out.println("---------------------------------------------------------\n");
			
			User user = null; // user will point at the User object returned by either signIn() or register()
			
			switch (choice) {
				case 1: // sign in
					System.out.println("Going to the sign in page\n");
					user = User.signIn(); // get the User returned by signIn()
					break;
				case 2: // register
					System.out.println("Going to the registration page\n");
					user = User.register(false); // get the User returned by register()
					break;
				case 3: // exit
					System.out.println("Now exiting program");
					break;
				default: // incorrect input
					System.out.println("Incorrect choice. Please select an option from 1-3.\n");
					break;	
			}
			
			// Call UserFactory to get either a Superuser if the user's type is "superuser"
			// or RegularUser if the user's type is "user". If null was returned from login()
			// or register(), then this code will not execute.
			if (user != null) {
				user = UserFactory.getUser(user);
				user.startUp(); // call the startUp() method on the returned Superuser/RegularUser
			}
			
			// loop until the user enters 3 to exit the program
		} while (choice != 3);
	}
}
