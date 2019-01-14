package scope;

public class Box {
	
	//Java doesn't have a global scope (whatever that means)
	
	//Static (or class) scope means that the variable or method belongs to the class,
	//and not to any particular instance of a class.
	static int staticnum = 10;
	
	//Instance scope means that the variable/method is attached to a particular instance.
	int instancenum = 100;
	
	//method scope are all variable created/initialized in a method
	//these do not leave the method
	public void method() {
		int num = 0; //this variable does not leave the method
		
		
		//block scope, aka local scope
		if (true) {
			int blocknum = 9; //this variable doesn't exist outside these brackets
		}
	}

}
