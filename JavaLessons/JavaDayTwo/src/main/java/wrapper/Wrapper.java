package wrapper;

public class Wrapper {
	public static void main(String[] args) {
		//wrappers turn primitives into objects and vice versa
		double d;
		Double dd= 0.0; //don't have to use new here
		Integer i;
		Byte bb;
		Character cc;
		Short ss;
		Long ll;
		Boolean bool;
		//the value within the object is unboxed
		int n1 = 10;
		int n2 = 9;
		add(n1,n2);
		multiply(n1,n2);
		
	}
	public static void add(int num1, int num2) {
		System.out.println(num1+ num2);
	}
	public static void multiply(int n1, int n2) {
		System.out.println(n1*n2);
	}
}
