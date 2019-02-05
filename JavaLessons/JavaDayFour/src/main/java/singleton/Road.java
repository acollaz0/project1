package singleton;

public class Road {
	public static void main(String[] args) {
		//Car c = new Car(); impossible because constructor is private
		Car c = Car.getCar();
		Car c2 = Car.getCar();
		System.out.println(c == c2);
		System.out.println();
		
	}
}
