package lambdaworld;

public class Calculator {
	
	
	//Lambdas give us the ability to perform functional programming in java
	//Use skinny arrow notation and a functional interface
	//most useful when you want one function to have multiple implementations withing the same class
	public static void main(String[] args) {
		
		//This basically says that this "add" object is an implementation of the Calculable interface.
		//the add variable is now a lambda
		Calculable add = (x,y) -> {
			System.out.println("Adding two numbers");
			return x+y;
		};
		
		Calculable mult = (x,y) -> {
			System.out.println("Multiplying two numbers");
			return x*y;
		};
		
		System.out.println(add.calculate(4, 50));
		System.out.println(mult.calculate(3, 4));
		
	}

}