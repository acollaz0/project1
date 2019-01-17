package overriding;

public class Playspace {
	
	public static void main(String[] args) {
		Parent p = new Parent();
		p.work();
		
		Child c = new Child();
		c.work();
		
		Parent pc = new Child();
		pc.work();
		System.out.println(pc.getClass());
		
		//The rules for overriding:
		//The method signature has to be exactly the same in the parent and child class (same name/params)
		
		//Three ways we see polmorphism in java:
		//Overloading
		//Overriding
		//Labeling an object with different/multiple names or types (I.e.: Parent pc = new Child();)
		
	}
}
