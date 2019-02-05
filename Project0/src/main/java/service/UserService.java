package service;

import model.User;
import dao.UserDao;

public class UserService {
	
	public static UserDao ud = new UserDao();
	
	public static User getUser(User ui) {
		//System.out.println(ui.getUsername());
		return ud.getUser(ui.getUsername(),ui.getPassword());
		
	}
	public static User addUser(User u) {
		return ud.addUser(u);
	}
	public static User addSuperUser(User u) {
		return ud.addSuperUser(u);
	}
	public static boolean getAll() {
		ud.getAll();
		return false;
	}
	public static boolean deleteUser(int uid) {
		ud.deleteUser(uid);
		return false;
	}
	public static boolean updateUser(User u) {
		ud.updateUser(u);
		return false;
	}

}
