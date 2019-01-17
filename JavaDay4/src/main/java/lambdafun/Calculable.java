package lambdafun;

//This optional to put the annotation
//prevents compiling if there is another method in here
@FunctionalInterface
public interface Calculable {
	
	//this method is designed to take two numbers and give us 1 in return
	
	double calculate(double num1, double num2);

}
