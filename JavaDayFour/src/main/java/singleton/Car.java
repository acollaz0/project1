package singleton;

public class Car {
	
	
	String name;
	int miles;
	
	public static Car car = null;
	
	// all singletons should have a private constructor
	private Car(String name, int miles) {
		
		this.name = name;
		this.miles = miles;
		
	}
	
	//should have a method responsible for determining if an instance exists
	// and if not creating one
	public static Car getCar() {
		
		if(car==null) {
			car = new Car("Car of the people", 0);
		}
		
		return car;
	}
	
	public void drive(int miles) {
		this.miles = this.miles+ miles;
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

	public static void setCar(Car car) {
		Car.car = car;
	}
	
	
	
	
	

}
