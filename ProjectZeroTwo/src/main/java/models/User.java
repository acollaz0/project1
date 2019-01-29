package models;

public class User {
	
	private String username;
	private String password;
	private boolean superUser;
	/**
	 * @param username
	 * @param password
	 * @param superUser
	 */
	public User(String username, String password, boolean superUser) {
		super();
		this.username = username;
		this.password = password;
		this.superUser = superUser;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isSuperUser() {
		return superUser;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", superUser=" + superUser + "]";
	}

}
