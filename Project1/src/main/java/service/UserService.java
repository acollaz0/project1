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
	
	/**
	 * updateLoyaltyPoints method
	 * Updates a User's loyalty points in the database
	 * @param The User to update
	 * @return true if a User was actually updated, else false
	 */
	public static boolean updateLoyaltyPoints(User u) {
		
		return ud.updateLoyaltyPoints(u);
	}
	
	/**
	 * deleteUser method
	 * Deletes a user from the database
	 * @param The user id for the User you want to delete
	 * @return true if a User was actually deleted, else false
	 */
	public static boolean deleteUser(int user_id) {
		
		return ud.deleteUser(user_id);
	}
}
