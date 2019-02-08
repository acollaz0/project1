package lambdafun;

public class Calculator {
	
	
	//lambdas give us the ability to perform function programming in Java
	//use -> skinny arrow notation and a functional interface
	//they are most useful when you want one function to have multiple 
	//implementations within the same class
	
	
	public static void main(String[] args) {
		
		Calcuable add = (x, y) -> {
			System.out.println("adding 2 numbers");
			return (x+y);
			};
		
		Calcuable multiply = (x,y)->{
			System.out.println("Multiply 2 numbers");
			return(x*y);
		};
		
		System.out.println(add.calculate(4, 40));
		System.out.println(multiply.calculate(4, 40));
	}

	

}
