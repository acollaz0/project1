package constructors;

public class ConstructionZone {

	public static void main(String[] args) {
		 
		Dwelling d  =  new Dwelling();
		System.out.println(d);
		//before you can build the house you need to build the dwelling
		//every object must build its parent before it can build itself
		House h = new House(4, 200);
		System.out.println(h);

	}

}
