package service;

import dao.UserDAO;
import model.User;

public class UserService {
	
	private static UserDAO ud = new UserDAO();
	
	/**
	 * getUser method
	 * Returns a User from the database if the given username is found
	 * @param username The username of the user you want to retrieve from the database
	 * @return A User if the given username is found, else null
	 */
	public static User getUser(String username) {
		
		User u = ud.getUser(username);
		return u;
	}
	
	/**
	 * addUser method
	 * Adds a User to the database
	 * @param The User to add to the database
	 * @return true if the User was successfully added, else false
	 */
	public static boolean addUser(User u) {
		
		return ud.addUser(u);
	}
}
