//Naming Conventions in Java

// package name should be all lower case
package welcomePackage;

// class name should be capitalized
public class Car {

	// constructor is the method responsible for building an instance of an object
	// it does not have a return type MUST named the same as the class
	public Car() {
		System.out.println("Built a car");
	}
	
	// variables (aka fields) should be all lowercase
	int wheels = 4;
	
	// methods get camel casing (The first world is not capitalized but the remaining are)
	public void driveFast() {
		System.out.println("Vroom vroom");
	}
	
	public void driveCarefully() {
		System.out.println("rumble rumble");
	}
	
}
