package abstractfun;

public class Lion extends Animal implements Carnivore {

	@Override
	public void eat() {
		System.out.println("The lion eats tonight in the jungle");
	}
	
	@Override
	public void makeSound() {
		System.out.println("RoAAarR");
	}

	public void eatMeat() {
		System.out.println("The lion tears into the gazelle with its canines");	
	}
	
}
