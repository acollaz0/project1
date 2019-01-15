package overriding;

public class Playground {

	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.work();
		
		Child c = new Child();
		c.work();
		
		Parent pc = new Child();
		pc.work();
				
		// the rules for overriding
		// The method signature has to be exactly the same as in the parent and child class
		
		// the three ways in which we see polymorphism in Java
		//1. Overloading
		//2. Overriding
		//3. We label an object with different/multiple names/types
	}
}
