package abstractfun;

//You can extend ONCE
//you make implement as many interfaces as you want
public class Human extends Animal implements Carnivore, Herbivore{
	public void makeSound() {
		System.out.println("Helli I can talk");
	}
	public void eatMeat() {
		System.out.println("Human cuts into steak");
	}
	public void eatPlant() {
		System.out.println("Human eats a salad");
	}
}
