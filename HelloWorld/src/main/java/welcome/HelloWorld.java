package welcome;

public class HelloWorld {
	
	//the ellipsis is another way to write array. To use 'varargs' is has to be the last
	//parameter in a method ex. public static void main(String... args)
	public static void main(String [] args) {
		
		System.out.println("Hello world");
		//any time you use the new keyword you have allocated 'new' memory for an object
		Car car = new Car();
		//
		
		//goto is a reserved keyword that will just give you a compiler error
		
		//this is a primitive
		int number = 100;
		change(number);
		System.out.println(number);
		
	}
	
	//copying the note saying where an object is stored
	public static void destroy(Car c) {
		c = null;
		
	}
	
	//Java is 100% pass by value
	public static void change(int num) {
		num = 20;
	}

}
