package lambdafun;

//this is optional to put the annotation
//prevents compiling if there is more than 1 method in here
@FunctionalInterface
public interface Calcuable {
	
	//this method is designed to take 2 numbers and 
	//give us one in return
	double calculate(double num1, double num2);
	

}
