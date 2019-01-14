//Just a lesson on naming conventions
//packages are all lowercase
package welcome;

//Class names are capitalized
public class Car {
	
	//Constructor is a method which instantiates an object
	//Does not have a return type, and must be named same as the class
	public Car() {
		//Code that's called when you instantiate the Car class
		System.out.println("build a car");
	}
	
	
	//variables (aka fields) should be all lowercase. Should only have one-word variables (if possible, which is a stupid restriction
	int wheels = 4;
	
	//methods get camel case
	public void driveFast() {
		System.out.println("Zoom Zoom");
	}
	
	public void driveSlow() {
		System.out.println("Putt Putt");
	}
	
	
	
}