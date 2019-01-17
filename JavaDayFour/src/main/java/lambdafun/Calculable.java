package lambdafun;

//Optinal annotation
@FunctionalInterface
//Will prevent compiling if there is another method in here
//Only one method allowed
public interface Calculable {
	//this method is designed to take two numbers and give us one in return
	
	double calculate(double num1, double num2);
}
