package constructors;

public class House extends Dwelling{

	int walls;
	
	//the first line in a constructor is always super(); unless explicitly otherwise
	// You cannot override constructors
	// no return type
	public House(int walls) {
		super();
		System.out.println("Building a house with so many walls " + walls);
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
