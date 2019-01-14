package welcomePackage;

public class HelloWorld {

	/// ellipses is another way to write array (replace [] with ...). To use 'varargs' it has to be the parameter in a method
	
	public static void main(String [] args) {
		
		System.out.println("Hello World");
		// any time you use the new keyword, you have allocated 'new' memory for an object
		Car car = new Car();

		//goto is a reserved keyword that will give you a compiler purpose
		
		//this is a primitive
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
	
	//copying the note saying where an object is stored
	public static void destroy(Car c) {
		
		// Not destroying the object
		// rather, the c variable no longer has that note. It instead has nothing
		c = null;
		
	}
	
	
	
	
}
