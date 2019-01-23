package model;

public class Player {
	
	private int p_id;
	private String name;
	private int salary;
	private int points;
	private String team;
		
	public Player() {
		super();
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
		return "Player [p_id=" + p_id + ", name=" + name + ", salary=" + salary + ", points=" + points + ", team="
				+ team + "]";
	}
	
	
	// you could make this a bean

}
