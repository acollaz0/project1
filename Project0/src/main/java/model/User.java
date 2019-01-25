package model;

public class User {
	
	private int u_id;
	private String username;
	private String password;
	private boolean issuper;
	
	
	public int getU_id() {
		return u_id;
	}

	public User(int u_id, String username, String password, boolean issuper) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.password = password;
		this.issuper = issuper;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
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
	public boolean isSuper() {
		return issuper;
	}
	public void setSuper(boolean issuper) {
		this.issuper = issuper;
	}

}
