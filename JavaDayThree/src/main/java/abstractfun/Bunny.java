package abstractfun;

public class Bunny extends Animal implements Herbivore, Petable{

//	public void eatPlant() {
//		System.out.println("Eats carrots");
//		
//	}

	@Override
	public void makeSound() {
		System.out.println("Hello I am Peter Cottontail");
	}

}
