package scope;

public class Practice {

	public static void main(String[] args) {
		
		// Never made an instance of box, staticnum belongs to class itself
		// Shared among all instances
		System.out.println(Box.staticnum);
		
		// every object gets its own copies of instance variables
		// an instance method must be used on an object
		Box box1 = new Box();
		System.out.println(box1.instancenum);
		
		Box box2 = new Box();
		box2.instancenum = 50;
		System.out.println(box2.instancenum);
		System.out.println(box1.instancenum);
		
	}
}
