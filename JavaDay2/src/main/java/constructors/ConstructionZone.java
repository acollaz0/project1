package constructors;

public class ConstructionZone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Dwelling d = new Dwelling();
//		System.out.println(d);
		
		//Before you can build a house, you need to build a dwelling
		//Every object must build its parent before it can build itself
		House h = new House(4,200);
		System.out.println(h);
	}

}
