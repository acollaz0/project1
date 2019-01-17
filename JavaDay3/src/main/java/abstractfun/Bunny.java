package abstractfun;

public class Bunny extends Animal implements Herbivore,Petable{
	
	public void eatPlant() {
		System.out.println("Eats carrots");
	}
	public void makeSound() {
		System.out.println("Whats up doc?");		
	}

}
