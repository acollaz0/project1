package constructors;

public class House extends Dwelling{
	
	int walls;
	 public House(int walls) {
		 super();
		 System.out.println("Building a house with so many wall " + walls);
		 this.walls = walls;
	 }
	 
	 public House(int walls, int area) {
	super(area);
	System.out.println("Building a house with so many walls" + walls);
	this.walls=walls;
	
		 
	 }

	@Override
	public String toString() {
		return "House [walls=" + walls + "]";
	}

	
	 

	
}


