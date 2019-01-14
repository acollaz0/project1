package welcome;

public class HelloWorld {

	//the ellipsis is another way to write array. To use 'varargs' it has to be the last parameter in a method.
	public static void main(String[] args)
	{
		System.out.println("Hello World");
		//any time you use the new keyword you have allocated 'new' memory for an Object.
		Car car = new Car();
		
		System.out.println(car);
		//goto is a reserved keyword that will just give you a compiler error on purpose.
		//this is a primitive variable
		int number = 100;
		change(number);
		destroy(car);
		System.out.println(number);
		
	}
	//Java is 100% pass by value
	public static void change(int num)
	{
		num = 20;
	}
	
	public static void destroy(Car c)
	{
		//I am not destroying the object
		//the c variable no longer has that note; it instead does nothing.
		c = null;
	}
}