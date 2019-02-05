package singleton;
//
public class Car {
	String name;
	int miles;
	public static Car car = null;
	//All Singletons should have a private constructor
	private Car(String name, int miles) {
		this.name = name;
		this.miles = miles;
	}
	//Should have an instance for determining if an instance exists
	//if one does not, create one
	public static Car getCar() {
		
		if(car==null)
			car = new Car("car of the people", 0);
		
		return car;
	}
	public void drive(int drive) {
		this.miles += drive;
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
