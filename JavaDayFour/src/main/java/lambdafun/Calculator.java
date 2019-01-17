package lambdafun;

public class Calculator  {

	// Lambdas give us the ability to perform functional programming in Java
	// They use skinny arrow notation and a functional interface
	// They are most useful when you want one function to have multiple 
	// implementations within the same class
	
	public static void main(String[] args) {
		
		Calcuable add = (x,y) -> { 
			System.out.println("Adding two numbers");
			return (x+y);
			};
		
		Calcuable multiply = (x,y) -> {
			System.out.println("Multiply two numbers");
			return (x*y);
		};
		
		System.out.println(add.calculate(4, 40));
		System.out.println(multiply.calculate(4, 40));
					
	}

	
	
}
