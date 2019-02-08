package abstractfun;

//when you put abstract on a class it only means you cannot instantiate the class
public abstract class Animal {
	
	//an abstract class can have any variables of any type and modifiers
	//it can have as many or as few abstract or concrete methods that you want
	String species;
	
	public void eat() {
		
		System.out.println("The animal is eating something");
	}
	//you do not have to have implementations of methods in an abstract
	//if you want a method that should always be overriden or implemented in a child
	//class you should make the method abstract
	public abstract void makeSound();
	
	//no abstract variables
}
