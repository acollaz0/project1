package model;

public class User {
	
	private int b_id;
	private String username;
	private String password;
	private int issuper;
	
	
	
	public User(int b_id, String username, String password, int issuper) {
		super();
		this.b_id = b_id;
		this.username = username;
		this.password = password;
		this.issuper = issuper;
	}



	@Override
	public String toString() {
		return "User [b_id=" + b_id + ", username=" + username + ", password=" + password + ", issuper=" + issuper
				+ "]";
	}



	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int isSuper() {
		return issuper;
	}
	public void setSuper(int issuper) {
		this.issuper = issuper;
	}


	public int getB_id() {
		return b_id;
	}



}
