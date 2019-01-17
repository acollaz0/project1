package abstractfun;

//Can implement as many interfaces as you want.
//Can only extend one class
public class Human extends Animal implements Herbivore, Carnivore {

	@Override
	public void makeSound() {
		System.out.println("Hey I can talk.");
	}

	public void eatMeat() {
		System.out.println("The human enjoys some steak.");
	}

	public void eatsPlants() {
		System.out.println("The human tolerates some arugala.");
	}

}
