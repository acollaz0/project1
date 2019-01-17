package lambdafun;

// this is optional to put the annotation
// prevents compiling if there is another method in here
@FunctionalInterface
public interface Calcuable {
	
	//this method is designed to take two numbers and 
	//give us one in return
	double calculate(double num1, double num2);

}
