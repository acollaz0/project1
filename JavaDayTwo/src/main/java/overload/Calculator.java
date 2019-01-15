package overload;

public class Calculator {
	
	public static void main(String[] args) {
		
		System.out.println(add(10,70));

		
	}

	// overloading is when you have a method with the same name but different parameters
	// the amount or the order of the parameters have to be unique
	public static int add(int num1, int num2) {		
		return num1+num2;
	}
	
	public static int add(Integer num1, Integer num2) {	
		System.out.println("I am a different method");
		return num1+num2;
	}
	
	public static int add(int num1, int num2, int num3) {		
		return num1+num2 +num3;
	}
	public static int add() {		
		return 0;
	}
	
	
}
