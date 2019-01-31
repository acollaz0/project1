package model;

import java.util.Scanner;

import application.App;
import service.UserService;

public class User {
	
	private int user_id;
	private String username;
	private String password;
	private String f_name;
	private String l_name;
	private String type;
	
	/**
	 * Constructor used for getting a User from the database
	 * @param user_id
	 * @param username
	 * @param password
	 * @param f_name
	 * @param l_name
	 * @param type
	 */
	public User(int user_id, String username, String password, String f_name, String l_name, String type) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.type = type;
	}

	/**
	 * Constructor used for adding a User to the database.
	 * Lacks a user_id parameter because a SQL sequence will generate a new user_id.
	 * @param username
	 * @param password
	 * @param f_name
	 * @param l_name
	 * @param type
	 */
	public User(String username, String password, String f_name, String l_name, String type) {
		super();
		this.username = username;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.type = type;
	}
	
	/**
	 * The startUp() function is meant to be overridden in Superuser and RegularUser
	 */
	public void startUp() {
		System.out.println("User functionality goes here");
	}
	
	/**
	 * signIn method
	 * Prompts for a username and password. Returns that user if that user exists
	 * and the entered password is correct.
	 * @return A User if the login was successful, else return null
	 */
	public static User signIn() {
		
		// prompt for a username and password
		System.out.println("---------------------------------------------------------");
		System.out.println("Please Sign In");
		System.out.println("--------------");
		System.out.print("Enter your username: ");
		String username = App.scan.nextLine();
		System.out.print("Enter your password: ");
		String password = App.scan.nextLine();
		System.out.println("---------------------------------------------------------\n");
		
		// Get the User from the database with the entered username
		// Gets null if the User was not found
		User user = UserService.getUser(username);
		
		// If the user was found, verify if the entered password matches the username
		if (user != null) {
			
			// check if password matches for this user
			if (password.equals(user.getPassword())) {
				// sign in if the password matches the username
				System.out.println("Successfully signed in as a " + user.getType());
				
				// incorrect password for this username
			} else {
				System.out.println("Incorrect password for the user: " + username);
				user = null; // reset user so it points at null
			}
		} else {
			System.out.println("User not found.");
		}
		System.out.println();
		
		// If the login was successful, return the User, else return null
		return user;
	}
	
	/**
	 * register method
	 * Prompts for a username, password, first name, and last name. Creates a
	 * superuser if superuser is true, else creates a regular user.
	 * @param superuser Whether a superuser is being registered or not
	 * @return A new User if the registration was successful, else null
	 */
	public static User register(boolean superuser) {
		
		User user = null;
		
		// prompt for a username, password, first name, and last name
		System.out.println("---------------------------------------------------------");
		System.out.println("User Creation");
		System.out.println("----------------");
		System.out.print("Enter a username: ");
		String username = App.scan.nextLine();
		System.out.print("Enter a password: ");
		String password = App.scan.nextLine();
		System.out.print("Enter first name: ");
		String f_name = App.scan.nextLine();
		System.out.print("Enter last name: ");
		String l_name = App.scan.nextLine();
		System.out.println("---------------------------------------------------------\n");
		
		// usertype is set to "superuser" if superuser is true
		// else usertype is set to "user"
		String usertype = null;
		if (superuser) {
			usertype = "superuser";
		} else {
			usertype = "user";
		}
		
		// Add this user to the database if the username does not already exist.
		if (UserService.addUser(new User(username, password, f_name, l_name, usertype))) {
			// Get this user from the database with the user_id included
			user = UserService.getUser(username);
			System.out.println("Successfully registered a " + user.getType());
			System.out.println("Now signing you in");
		} else {
			System.out.println("User already exists.");
		}
		
		System.out.println();
	
		// Return the new user if the registration was successful, else null
		return user;
	}
	
	/**
	 * registerSuperuser method
	 * Asks if you want to register a new superuser or not
	 * @return true if a superuser will be registered, else false
	 */
	public static boolean registerSuperuser() {
		
		// ask if a new superuser will be registered
		System.out.print("Are you registering a new superuser? (Y/N): ");
		char answer = App.scan.nextLine().charAt(0);
		
		// return true if the user enters 'Y' or 'y'
		switch(answer) {
		case 'Y':
		case 'y':
			System.out.println("\nYou are now registering as a superuser\n");
			return true;
		case 'N':
		case 'n':
			System.out.println("\nYou are not registering a superuser\n");
			return false;
		default:
			System.out.println("\nYou are not registering a superuser\n");
			return false;
		}
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the f_name
	 */
	public String getF_name() {
		return f_name;
	}

	/**
	 * @param f_name the f_name to set
	 */
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	/**
	 * @return the l_name
	 */
	public String getL_name() {
		return l_name;
	}

	/**
	 * @param l_name the l_name to set
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", f_name=" + f_name
				+ ", l_name=" + l_name + ", type=" + type + "]";
	}

	
	
	
	
}
