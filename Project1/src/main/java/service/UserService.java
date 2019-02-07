package service;

import dao.UserDao;
import model.User;

public class UserService {
	
public static UserDao ud = new UserDao();
	
	public static User getUser(User ui) {
		//System.out.println(ui.getUsername());
		return ud.getUser(ui.getUsername(),ui.getPassword());	
	}
	public static User getUser(String username, String password) {
		//System.out.println(ui.getUsername());
		return ud.getUser(username,password);	
	}
	public static User addUser(String username, String password) {
		return ud.addUser(username, password);
	}
}
