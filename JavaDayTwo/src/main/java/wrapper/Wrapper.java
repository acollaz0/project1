package wrapper;

public class Wrapper {

	public static void main(String[] args) {
		
		double d; // primitive version
		Double dd = 0.0; // object wrapper version 
		Byte bb;
		Integer ii;
		Character cc;
		Short ss;
		Long ll;
		Boolean boo;
		
		// the value within the object is unboxed  unboxing
		Integer n1 = 9;
		Integer n2 = 10;
		add(n1,n2);
		

		// Primitive turns into an object autoboxing
		int n3 = 4;
		int n4 = 20;
		multiply(n3,n4);
	}
	
	public static void add(int num1, int num2) {
		
		System.out.println(num1 + num2);
		
	}
	
	public static void multiply(Integer num1, Integer num2) {
		
		System.out.println(num1*num2);
		
	}
	

}
