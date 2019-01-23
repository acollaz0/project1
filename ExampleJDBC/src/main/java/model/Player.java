package model;

public class Player {
	int p_id;
	String name;
	int salary;
	int points;
	String team;
	public Player() {
		
	}
	public Player(int p_id, String name, int salary, int points, String team) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.salary = salary;
		this.points = points;
		this.team = team;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "Player [p_id=" + p_id + ", name=" + name + ", salary=" + salary + ", points=" + points + ", team=" + team + "]";
	}
	
	
	//could make a bean
}
