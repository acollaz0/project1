package abstractfun;

// You can implement as many interfaces as you want
// You can only ever extend one class
public class Human extends Animal implements Herbivore, Carnivore {

	@Override
	public void makeSound() {
		System.out.println("Hello I can talk");		
	}

	public void eatMeat() {
		System.out.println("Cuts into steak");
	}

	public void eatPlant() {
		System.out.println("Makes a salad");		
	}

}
