package users;

public class SuperUser extends RegisteredUser implements User {

	public boolean login() {

		return false;
	}

	public boolean logout() {

		return false;
	}

	public boolean withdraw() {

		return false;
	}

	public boolean deposit() {

		return false;
	}

	public boolean create() {

		return false;
	}

	public boolean delete() {

		return false;
	}

	public RegisteredUser viewUser(RegisteredUser u) {
		return u;
	}
		
	

}
