package singleton;

public class Road {
	
	public static void main(String[] args) {
//		Car c = new Car("Bad car", 666); This is impossible, because the constructor is private.
		Car c = Car.getCar();
		Car c2 = Car.getCar();
		
		System.out.println(c.getName());
		System.out.println(c2.getName()); //Both c and c2 are the same exact car
		//can only ever have one instance of the car per application.
		c.drive(5);
		c2.drive(20);
		System.out.println(c2.getMiles());
	}

}
