package objectfun;

public class ObjectExperiment {

	//Java is an OOP language, and all Objects are of type "Object"
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = new Object();
		
		o.toString();
		System.out.println(o);
		System.out.println(o.toString());//These two lines are exactly identical.
		//println() will call any object's toString() method 
		//the default implimentation of toString() is to print the memory address. 
		
		Student s = new Student();
		s.age=19;
		s.name="jimbo";
		System.out.println(s);
		
	}

}
