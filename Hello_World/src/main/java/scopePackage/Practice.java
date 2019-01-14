package scopePackage;

public class Practice {

	// type mai..., then use 'ctrl' + spacebar to add by shortcut
	public static void main(String[] args) {
		
		// instance of a box was never made but can be used the static variable
		// static belongs to the class
		// Shared among all the instances
		System.out.println(Box.staticnum);
		
		//every object gets its own copies of instance variables
		//an instance method must be used on an object
		Box box1 = new Box();
		System.out.println(box1.instancenum);
		
		Box box2 = new Box();
		box2.instancenum = 50;
		System.out.println(box2.instancenum);
		System.out.println(box1.instancenum);
		
		
	}
	
}
