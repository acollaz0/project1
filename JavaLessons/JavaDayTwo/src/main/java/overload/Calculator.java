package overload;

public class Calculator {
	public static void main(String[] args) {
		System.out.println(add(10,70));
	}
	//overloading is having the same method with different names but the same parameter
	//the amount or order of params must be unique
	public static int add(int num1, int num2) {
		return (num1 + num2);
	}
	public static int add(Integer num1, Integer num2) {
		return (num1 + num2);
	}
	public static int add(int num1, int num2, int num3) {
		return (num1 + num2 + num3);
	}
}
