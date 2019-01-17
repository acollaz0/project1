package abstractfun;

public class Giraffe extends Animal implements Herbivore, Petable {

	@Override
	public void makeSound() {
		System.out.println("*Incomprehensible giraffe snort.*");
	}

	public void eatsPlants() {
		System.out.println("The Giraffe eats some leaves.");
	}
	
	
	
}
