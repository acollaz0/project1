package constructors;

public class ConstructionZone {

	public static void main(String[] args) {
//		Dwelling d = new Dwelling();
//		System.out.println(d);
		
		// before you can build a house you need to build the dwelling
		// Every object must build its parent before it can build itself
		House h = new House(4,200);

	}

}
