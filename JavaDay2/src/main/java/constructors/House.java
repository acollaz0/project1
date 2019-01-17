package constructors;

public class House extends Dwelling {
	
	int walls;
	
	//The first line in a constructor is always "super()" unless specified otherwise.
	public House(int walls) {
		System.out.println("Building House with " + walls + " walls.");
		this.walls = walls;
	}
	
	//Can't override a constructor. They aren't inherited
	public House(int walls, int area) {
		super(area);
		this.walls = walls;
		System.out.println("Building House with " + walls + " walls.");
	}

	@Override
	public String toString() {
		return "House [walls=" + walls + "]";
	}

}
