package users;

import java.util.UUID;

public class RegisteredUser implements User {
	
	final UUID userID = UUID.randomUUID();
	
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
	public User view() {
		return this;
	}
	public boolean validatePassword(UUID id) {
		
		return false;
	}

}
