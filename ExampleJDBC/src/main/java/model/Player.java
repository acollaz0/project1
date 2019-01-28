package model;

public class Player {
	
	private int p_id;
	private String name;
	private int points;
	private int salary;
	private String team;
	
	
	
	public Player() {
		super();
	}
	public Player(int p_id, String name, int points, int salary, String team) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.points = points;
		this.salary = salary;
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "Player [p_id=" + p_id + ", name=" + name + ", points=" + points + ", salary=" + salary + ", team="
				+ team + "]";
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	

}
