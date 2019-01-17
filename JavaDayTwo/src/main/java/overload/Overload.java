package overload;

public class Overload {

		public static void main(String[] args) {
			
			System.out.println(add(10,70));
			System.out.println(add(10,70,5));
		}
		//overloading is when you have a method with the same name but different parameters
		//the amount of the order of the parameters have to be unique
		public static int add(int num1, int num2) {
			
			return num1+num2;
		}
		//wrappers allow overloading of otherwise the same method
		public static int add(Integer num1, Integer num2) {
			System.out.println("I am a different method");
			return num1+num2;
		}
		public static int add(int num1, int num2, int num3) {
			
			return num1+num2+num3;
		}
}
