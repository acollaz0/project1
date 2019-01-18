package lambdafun;

public class Calculator {
	public static void main(String[] args) {
		
		//Lambdas give us the ability to perform functional programming in java
		//They use skinny arrow notation as well as a functional interface
		//most useful when you want one function to have multiple implementations
		//within the same class
		Calculable add = (x,y) -> {
			System.out.println("Adding Two Numbers");
			return(x+y);
		};
		Calculable multiply = (x,y) -> {
			System.out.println("Multiplying Two Numbers");
			return(x*y);
		};
		System.out.println(add.calculate(4,40));
		System.out.println(multiply.calculate(4,40));
		
	}
}