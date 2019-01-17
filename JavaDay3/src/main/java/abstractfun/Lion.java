package abstractfun;

public class Lion extends Animal implements Carnivore {

	@Override
	public void eat() {
		System.out.println("The lion eats in the Jungle.");
	}

	//This method must be overridden, since the parent class doesn't have implementation for it.
	@Override
	public void makeSound() {
		System.out.println("Rooaar");
	}
	
	public void eatMeat() {
		System.out.println("The lion eats the gazelle.");
	}
	
	
	
}
