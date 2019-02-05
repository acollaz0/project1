package overriding;

public class Playground {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.work();
		Child c = new Child();
		c.work();
		
		//calls work of child
		Parent pc = new Child();
		pc.work();
		
		//the rules for overriding
		//the method signature must be exactly the same as in the parent and child 
		
		//three ways we see polymorphism in java
		//1. Overloading
		//2. Overriding
		//3. We label an object with different or multiple names/types
		
	}

}
