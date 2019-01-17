package abstractfun;
//you can implement as many interface as you want
//You can only ever extend one class
public class Human extends Animal implements Herbivore,Carnivore{
	
	public void makeSound() {
		System.out.println("Hello I can talk");
		
	}

	public void eatMeat() {
		System.out.println("Cuts into a steak");
		
	}

	public void eatPlant() {
		System.out.println("Eats a salad");		
	}
	

}
