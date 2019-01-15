package scope;

public class Box {
	
	//Java does not have a global scope
	//static/class scope - the variable or method belongs to the class
	static int staticnum = 10;
	
	// not to any particular instance of the class
	//the variable or method is attached to a particular instance
	int instancenum = 100;
	
	//method scope are all variables created or initialized in a method
	//these do not leave the method
	public void method() {
		//method variable
		int methodnum = 1000;
		
		//block scope
		if (true) {
			int blocknum = 10000;
		}
			
	}
}
