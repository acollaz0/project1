package model;

public class PizzaUser {
	@Override
	public String toString() {
		return "PizzaUser [u_id=" + u_id + ", username=" + username + ", password=" + password + ", rewards=" + rewards
				+ ", employee=" + employee + "]";
	}
	private int u_id;
	private String username;
	private String password;
	private int rewards;
	private int employee;
	
	
	public PizzaUser() {
		super();
	}
	
	public PizzaUser(int u_id, String username, String password, int rewards, int employee) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.password = password;
		this.rewards = rewards;
		this.employee = employee;
	}
	public int getU_id() {
		return u_id;
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
	public int getRewards() {
		return rewards;
	}
	public void setRewards(int rewards) {
		this.rewards = rewards;
	}
	public int getEmployee() {
		return employee;
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}

}
