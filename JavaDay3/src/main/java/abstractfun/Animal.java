package abstractfun;

//Putting abstract on a class only means you can't instantiate the class, nothing else.
public abstract class Animal {
	
	//An abstract class can have variables of any type/modifiers
	//Can have as many concrete or abstract methods as you need
	
	String species;
	
	
	public void eat() {
		System.out.println("THe animal is eating something");
	}
	
	//You do not need implementations for methods in an abstract class.
	//This means that this method should always be overridden in child classes
	public abstract void makeSound();
	
	//no such thing as an abstract variable

}
