package dao;

import model.User;
public interface IUser {
	
	public User getUser();
	public boolean addUser();
	public boolean deleteUser();
	public boolean deposit();
	public boolean withdraw();
	public boolean logout();
	
	
}
