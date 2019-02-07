package model;

public class Employee {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	public Employee(String username, String password, String salt, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		
		this.firstname = firstname;
		this.lastname = lastname;
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
}
