package dao;

import model.User;

public interface IUser {
	
	public User getUser(String username,String password);
	public User addUser(User u);
	public User addSuperUser(User u);
	public boolean deleteUser(int uid);
	public boolean getAll();
	public boolean updateUser(User u);
	//public List<Account> getAccounts(String username);

}
