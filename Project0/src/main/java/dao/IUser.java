package dao;

import java.util.List;

import model.User;

// interface for UserDAO methods
public interface IUser {
	
	public User getUser(String username);
	public boolean addUser(User u);
	public boolean updateUser(User u);
	public boolean deleteUser(int user_id);
	public List<User> allUsers();
}
