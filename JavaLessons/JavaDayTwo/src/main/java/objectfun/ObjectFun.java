package objectfun;

public class ObjectFun {

	public static void main(String[] args) {
		
		Object o = new Object();
		//These two lines are identical
		System.out.println(o);
		System.out.println(o.toString());
		//the toString method is to print the memory location of the object
		Student s = new Student();
		s.age = 19;
		s.name = "Jacob";
	}

}
