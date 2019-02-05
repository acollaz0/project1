package abstractfun;

public class Giraffe extends Animal implements Herbivore, Petable{
	@Override
	public void makeSound(){
		System.out.println("The animal is making a sound.");
	}
	public void eatPlant() {
		
	}

}
