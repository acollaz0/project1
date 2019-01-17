package abstractfun;

public abstract class Animal {
	String species;
	
	/*
	 * an abstract class can have any variables of any type and modifiers
	 * it can have as many or as few abstract or concrete methods that you want
	 */
	public void eat() {
		System.out.println("The animal is eating something.");
		
	}
	public void makeSound() {
		System.out.println("The animal is making a sound.");
	}
}
