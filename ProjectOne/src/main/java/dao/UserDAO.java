package dao;

import model.User;

public class UserDAO implements IUser{

	public User getUser(int u_id) {
		String sql = "SELECT * FROM player WHERE u_id = ?";
		return null;
	}

	public boolean addUser() {
		String sql = "";
		return false;
	}

	public boolean deleteUser() {

		return false;
	}

	public boolean deposit() {

		return false;
	}

	public boolean withdraw() {

		return false;
	}

	public boolean logout() {

		return false;
	}

	public User getUser() {
		
		return null;
	}

}
