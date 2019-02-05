package constructors;

public class House extends Dwelling{
	int walls;
	//First line of a constructor is super();
	//You cannot override constructors
	public House(int walls) {
		super();
		this.walls = walls;
	}
	public House(int walls, int area) {
		super(area);
		System.out.println("Building a house with so many walls " + walls);
		System.out.println("Building a house with this size " + area);
		this.walls = walls;
	}
	@Override
	public String toString() {
		return "House [walls=" + walls + "]";
	}
	
}
