package model;

public class Player {
	
	int id;
	String name;
	String team;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Player(int id, String name, String team) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
	}
	public Player() {
		super();
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", team=" + team + "]";
	}
	

}
