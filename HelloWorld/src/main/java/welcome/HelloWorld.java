package welcome;

public class HelloWorld {
	// could be (String ... args)
	// to use 'varargs' it has to be the last parameter in a method
	public static void main (String[] args) {
		
		System.out.println("Hello, world.");
		// any time you use the new keyword you have allocated 'new' memory for an object
		// the car variable is a box that holds a note (memory address)
		Car car = new Car();
		
		// goto is a reserved keyword that will just give you a compiler purpose
		
		// this is a primitive variable
		int number = 100;
		change(number);
		System.out.println(number);
		
		System.out.println(car);
		destroy(car);
		System.out.println(car);
		
	}
	
	// Java is 100% passed by value
	public static void change(int num) {
		num = 20;
	}
	
	// copying the note saying where the object is stored
	public static void destroy(Car carInput) {
		// not destroying the object
		// the c variable no longer has that note, instead has nothing
		carInput = null;
	}
}
