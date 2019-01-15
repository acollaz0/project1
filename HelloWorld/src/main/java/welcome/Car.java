//naming conventions in Java

//should be all lower case
package welcome;

//Should be capitalized 
public class Car {
	
	
	//Constructor is the method responsible for building an instance of an object
	// it does not have a return type. named the same as the class
	public Car () {
		System.out.println("Build a car");
	}
		
		//variables aka fields should be lower case
		int wheels = 4;
		

	// methods get camel casing. (1st word is not capitalized
	public void driveFast() {
		System.out.println("Vroom vroom");
	}
	
	
	public void driveCarefully() {
		System.out.println("rumble rumble");
	}

}
