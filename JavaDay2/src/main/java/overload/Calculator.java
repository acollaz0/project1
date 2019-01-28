package overload;

public class Calculator {

	public static void main(String[] args) {

		System.out.println(add(10,89));
		//System.out.println(add(new Integer(10),89));
		System.out.println(add(10,89,1));

	}
	
	//Overloading is when you have a method with the same name but different parameters.
	//The amount or order of params must be unique.
	/**
	 * @param num1
	 * @param num2
	 * @return the sum of the parameters
	 */
	public static int add(int num1, int num2) {
		return num1+num2;
	}
	
	public static int add(Integer num1, Integer num2) {
		//This method overloads the previous method. Java will try to match the parameters 
		//as closely as it can
		System.out.println("I'm a different method");
		return num1+num2;
	}
	
	//overloading the previous method
	public static int add(int num1, int num2, int num3) {
		return num1+num2+num3;
	}

}