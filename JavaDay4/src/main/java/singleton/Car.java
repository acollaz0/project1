package singleton;

public class Car {
	//If we want to make this a singleton, use private constructors to start.
	
	String name;
	int miles;
	
	public static Car car = null;
	
	//if this is private, then this can only be access within this class
	private Car(String name, int miles) {
		this.name = name;
		this.miles = miles;
	}
	
	//need to write another method to get an instance
	//this makes it impossible to create more than one instance of a car
	public static Car getCar() {
		
		if (car == null) {
			//there is no instance of car yet
			car = new Car("Car of the people", 0);
		}
		
		
		return car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}
	
	public void drive(int miles) {
		this.miles += miles;
	}
	

}
