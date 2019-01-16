package abstractfun;

import java.util.ArrayList;
import java.util.List;

public class Jungle {

	public static void main(String[] args) {
		
		//i cannot make just an animal
		//Animal a = new Animal();
		Lion l = new Lion();
		
		//it is okay to call a lion an animal
		Animal leon = new Lion();
		
		//Java only knows that this object has methods declared within the Animal class
		//despite the fact that it has other methods as well;
		Animal human = new Human();
		human.makeSound();
		
		//a human labeled as a human can do everything that a human can do
		//which is anything an animal, herbivore, or carnivore can do
		Human human2 = new Human();
		human2.eatMeat();
		
		//a.makeSound();
		l.makeSound();
		leon.makeSound();

		List<Carnivore> meateaters = new ArrayList<Carnivore>();
		
		//i can add human2 because it is labeled as a carnivore 
		meateaters.add(human2);
		//this wont work. even though this is a human Java knows the object as an Animal
		//meateaters.add(human);
		
		//i added a lion because the only requirement for this list
		//is to be a carnivore
		meateaters.add(l);
		
		for(Carnivore c : meateaters) {
			c.eatMeat();
		}
		
		//using a marker interface is a way to organize and designate classes
		//if it ends in 'able' it is usually an interface throwable is technically a class
		List<Petable> cutestuff = new ArrayList<Petable>();
		
		Bunny b = new Bunny();
		Giraffe g = new Giraffe();
		TeddyBear tb = new TeddyBear();
		
		cutestuff.add(b);
	}

}
