//naming conventions in Java

// package should be all lower case
package welcome;

// class name should be capitalized
public class Car {
	
	//Constructor is the method responsible for building an instance of an object
	//It does not have a return type MUST be named the same as the class	
	public Car() {
		System.out.println("Built a car");
	}
	
	// variables aka fields should be all lower case
	int wheels = 4;
	
	//methods get camel casing. The first word is not capitalized but the remaining are
	public void driveFast() {
		System.out.println("Vroom vroom");
	}
	
	public void driveCarefully() {
		System.out.println("rumble rumble");
	}

}
