package model;

public class User {
	
	private String first;//personal information
	private String last;//personal information
	private String username;//composite key 1
	private String password;//composite key 2
	private int u_id;//unique key
	//Set<Account> accounts = new TreeSet<Account>();
	public User() {
		super();
	}
	public User(int u_id,String username, String password,String first, String last) {
		super();
		this.first = first;
		this.last = last;
		this.username = username;
		this.password = password;
		this.u_id = u_id;
		}
	public User(String username, String password,String first, String last) {
		this.first = first;
		this.last=last;
		this.username=username;
		this.password=password;
	}
	public User(String username,String password) {
		this.username=username;
		this.password=password;
		this.first="";
		this.last="";
		this.u_id=0;
	}
	@Override
	public String toString() {
		return "User [first=" + first + ", last=" + last + ", username=" + username + ", password=" + password
				+ ", u_id=" + u_id + "]";
	}
	public int getU_id() {
		return this.u_id;
	}
	public void setU_id(int u_id) {
		this.u_id=u_id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
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
	
	

}
