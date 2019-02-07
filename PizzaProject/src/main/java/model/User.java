package model;

public class User {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private int rewardpoints;
	public User(String username, String password, String firstname, String lastname, String address, int rewardpoints) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.rewardpoints = rewardpoints;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public int getRewardpoints() {
		return rewardpoints;
	}
	
	
}
