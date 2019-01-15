package objectfun;

public class ObjectFun {
	
	// Java is an OOP language
	// All objects are of type Object.
	public static void main(String[] args) {
		
		Object o = new Object();
	
		// these two lines are identical
		// Java will call the toString method on any object within a print statement
		// The default implementation of toString is to print the memory address
		System.out.println(o);
		System.out.println(o.toString());
		
		Object s = new Student();
//		s.age= 19;
//		s.name = "Jacob";
		
//		System.out.println(s.getClass());
		
		
	
		
	}

}
