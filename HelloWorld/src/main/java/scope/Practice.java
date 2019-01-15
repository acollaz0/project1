package scope;

public class Practice {

	public static void main(String[] args) {
		
		//I never made an instance of a box but i can still use the static variable
		//because it belongs to the class
		//shared among all the instances
		System.out.println(Box.staticnum);
		
		//every object gets its own copies of instance variables
		// an instance method must be used on an object
		Box box1 = new Box();
		System.out.println(box1.instancenum);
		
		Box box2 = new Box();
		box2.instancenum = 50;
		System.out.println(box2.instancenum);
		System.out.println(box1.instancenum);
		
	}
}
