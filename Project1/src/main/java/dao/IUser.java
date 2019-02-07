package dao;

import model.User;

public interface IUser {
	
	public User getUser(String username, String password);
	public User addUser(String username, String password);

}
