package abstractfun;

public class Giraffe extends Animal implements Herbivore, Petable{

	@Override
	public void makeSound() {
		System.out.println("The giraffe says hows the weather down there");	
	}

	public void eatPlant() {
		System.out.println("Eat the leaves from a tall tree");
		
	}
	

}
