package abstractfun;

public class Bunny extends Animal implements Herbivore, Petable {

	public void eatsPlants() {
		System.out.println("The bunny eats a carrot.");
	}

	@Override
	public void makeSound() {
		System.out.println("What's up Doc?");
	}
	
	

}
