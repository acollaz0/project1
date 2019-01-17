package wrapper;

public class Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d; //Primitive
		Double dd = 0.0; //Object version
		
		byte b;
		Byte bb;
		
		int i;
		Integer ii;
		
		char c;
		Character cc;
		
		short s;
		Short ss;
		long l;
		Long ll;
		//etc, etc...
		Integer n1 = 8;
		Integer n2 = 9;
		add(n1,n2);
		
		//autoboxing a primitive into an object
		int n3 = 9;
		int n4 = 7;
		multiply(n3,n4);
	}
	
	//boxing and unboxing primitives
	public static void add(int num1, int num2) {
		
		System.out.println(num1 + num2);
		
	}
	
	public static void multiply(Integer num1, Integer num2) {
		
		System.out.println(num1 * num2);
		
	}

}
