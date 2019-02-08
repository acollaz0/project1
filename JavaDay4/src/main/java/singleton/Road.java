package singleton;

public class Road {

	public static void main(String[] args) {
		//Car c = new Car(); impossible because the constructor is private
		
		Car c = Car.getCar();
		Car c2 = Car.getCar();
		
		System.out.println(c == c2);
		System.out.println(c2);
		
		c.drive(70);
		c.drive(5);
		
		System.out.println(c2.getMiles());
	}

}
