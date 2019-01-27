package dao;

import java.util.List;

import model.User;

public interface IUser {

	public User getUser(String username);
	public boolean addUser(User u);
	public boolean deleteUser(int b_id);
	public boolean updateUserPass(int b_id, String password);
	public boolean updateUserName(int b_id, String username);
	public List<User> allUsers();
}
