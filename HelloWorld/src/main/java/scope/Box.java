package scope;

public class Box {
	
	// Java does NOT HAVE A GLOBAL SCOPE
	
	// static/class scope - The variable or method belongs to the class and not to any particular instance of the class
	static int staticnum = 10;
	
	// instance scope - The variable/method is attached to a particular instance	
	int instancenum = 100;
	
	// method scope - All variables created/initialized inn a method. These do not leave the method.
	public void method() {
		
		// method variable
		int num = 0;
		
		// block scope
		if (true) {
			int blocknum = 9;
		}
//		System.out.println(blocknum);
	}
}
