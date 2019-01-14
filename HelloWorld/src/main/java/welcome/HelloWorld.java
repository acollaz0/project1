package welcome;

public class HelloWorld {
	// can also be written like "String... args". Can only write parameters like this when it's
	// the last param in a method. Called varargs.
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		//Whenever you use the "new" keyword, you allocate new memory for an object. Always need to use new
		//in order to make new object.
		Car car = new Car();
		car.driveFast();
		
		//Primitive
		int number = 100;
		change(number);
		System.out.println(number); //will still return 100
		
		//Reference variable
		System.out.println(car);
		destroy(car);
		System.out.println(car);
		
	}
	
	//Java is 100% pass-by-value. Except the "value" of reference objects is the reference.
	public static void change(int num) {
		num = 20;
	}
	
	//Creates copy of the reference to same address as car, but can only destroy 
	//the new reference, not the object.
	public static void destroy(Car car) {
		
		car = null;
		//car variable no long has reference to the original car variable
		
	}
	
	
}
