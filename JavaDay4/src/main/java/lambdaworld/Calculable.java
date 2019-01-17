package lambdaworld;

//Annotation is technically optional
//Prevents compiling if there is a second method in the interface
@FunctionalInterface
public interface Calculable {
	
	//Only allowed ONE abstract method inside a FunctionalInterface
	//This method is designed to take two numbers and give us one in return. Says nothing about implementation
	double calculate(double num1, double num2);

}
