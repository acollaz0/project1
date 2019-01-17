package abstractfun;

public abstract class Animal {
	
	
	//an abstract class can have any variables of any type and modifiers
	//it can have 
	
	String species;
	
	public void eat() {
		System.out.println("The animal is eating something");
		
	}
	//You do not have to have implementations of methods in an abstract
	//If you want a method that should always be overriden or implemented in a child class
	//you should make the method abstract
	public abstract void makeSound();
	
	//no abstract variables
	

}
