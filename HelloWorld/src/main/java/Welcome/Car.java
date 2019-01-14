package Welcome;

public class Car {
	
	//variables should be all lowercase
	int wheels = 4;
	
	//Constructor is responsible for building an instance of an object
	public Car()
	{
		System.out.println("Built a car");

	}
	
	//method names are camel case (first letter not capitalized, rest of the words are)
	public void driveFast()
	{
		System.out.println("Vroom Vroom");
	}
	
	public void driveCarefully()
	{
		System.out.println("Rumble Rumble");
	}
}
