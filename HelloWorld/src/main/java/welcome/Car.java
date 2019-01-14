// naming conventions

// package should be all lower case
package welcome;

// class name should be capitalized
public class Car {
	
	// constructor is the method responsible for building an instance of an object
	// does not have a return type
	// named the same as the class
	public Car() {
		System.out.println("Built a car");
	}
	
	// variables, a.k.a. fields, should be all lower case
	int wheels = 4;
	
	// methods get camel casing; the first word isn't capitalized, the rest are
	public void driveFast() {
		System.out.println("Vroom vroom");
	}
	
	public void driveCarefully() {
		System.out.println("Rumble rumble");
	}
	
}
