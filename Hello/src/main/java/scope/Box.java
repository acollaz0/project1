package scope;

public class Box {
	
	//Java does NOT HAVE A GLOBAL SCOPE
	
	//static/class scope  the variable or method belongs to the class
	// and not to any particular instance of the class
	
	static int staticnum = 10;

	// Instance scope means that the variable/method is attached to a particular instance
	int instancenum = 100;

	// method scope are variable created/initialized in a method
	// these variables do not leave the method
	public void method() {
		
		// method variable
		int num = 0;
		
		// block scope		
		if(true) {
			int blocknum = 9;		
		}
		
//		System.out.println(blocknum);
		
	}
	
	
}
