package welcome;

public class HelloWorld {

	/// the ellipsis is another way to write array. To use 'varargs' it has to be the last 
	// parameter in a method
	public static void main(String... args) {
		
		System.out.println("Hello world");
		// any time you use the new keyword you have allocated 'new' memory for an object
		Car car = new Car();
		
		// the car variable is a box that holds a note that has the address of an object
		
		//goto is a reserved keyword that will just give you a compiler purpose
		
		// this a primitive
		int number = 100;
		change(number);
		System.out.println(number);
		
		System.out.println(car);
		destroy(car);
		System.out.println(car);
		
	}
	
	// Java is 100% pass by value
	public static void change(int num) {
		 num = 20;
	}
	
	// copying the note saying where an object is stored
	public static void destroy(Car c) {
		
		// I am not destroying the object
		// the c variable no longer has that note it instead has nothing
		c = null;
		
	}
	
}
