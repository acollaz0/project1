package dao;

import java.util.List;

import models.User;

public interface IUserDAO {
	
	/**
	 * @param user
	 * @return True if the operation didn't fail, false if it did.
	 */
	public boolean addUser(User user);
	/**
	 * @param user
	 * @return True if the username and password of user are in the BANKUSER table
	 */
	public boolean validateUser(User user);
	/**
	 * @param username
	 * @param password
	 * @return True if the username and password of user are in the BANKUSER table
	 */
	public boolean validateUser(String username, String password);
//	public boolean validateSuperUser(User user);
	/**
	 * @param username
	 * @return If a user is a superuser
	 */
	public boolean isSuperUser(String username);
	/**
	 * @param user
	 * @return If a username exists in the BANKUSER database.
	 */
	public boolean isExtantUser(String user);
	/**
	 * @param username
	 * @return The User object of the given userid, populated from the database. Will return null if the username doesn't exist
	 */
	public User getUser(String username);
	/**
	 * @return A list of all users in the BANKUSER table.
	 */
	public List<User> getAllUsers();
	public boolean deleteUser(User user);
	public boolean editUserInfo(User user, String n_username, String n_password);

}
