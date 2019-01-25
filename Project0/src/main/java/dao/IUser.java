package dao;

import java.util.List;

import model.User;

public interface IUser {

	public User getUser(int u_id);
	public boolean addUser(User u);
	public boolean deleteUser(int u_id);
	public List<User> allUsers();
}
