package welcome;

public class HelloWorld {
	//The ellipsis '...' is another way to write array. To use 'varargs' it has to be the last
	//parameter in a method
	public static void main(String... args) {
		
		System.out.println("Hello World!!");
		//any time you use the 'new' keyword you have allocated 'new' memory for an object 
		Car car = new Car();
		//The yellow line under car is because it has not been used yet
		
		//This is a primitive
		int number = 100;
		change(number);
		System.out.println(number);
		
		System.out.println(car);
		destroy(car);
		//memory is the same even when the memory address is set equal to null
		//not destroying the actual memory
		System.out.println(car);
		
		
	}
	
	//JAVA IS 100% PASS BY VALUE
	public static void change(int num) {
		num = 20;
		
	}
	
	public static void destroy(Car c) {
	
		c = null;
	}

}
