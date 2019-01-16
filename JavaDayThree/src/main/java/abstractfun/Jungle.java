package abstractfun;

import java.util.ArrayList;
import java.util.List;

public class Jungle {

	public static void main(String[] args) {
	
	// I cannot make just an animal
	// Animal a = new Animal();
		Lion l = new Lion();
		
		// Java only knows that this object has methods declared within the Animal class
		//Despite the fact it has other methods as well;
		Animal human = new Human();
		human.makeSound();
		
		// A human labeled as a human can do everything that a human can do
		// which is anything animal herbivore or carnivore
		Human human2 = new Human();
		human2.eatMeat();
		
		// It is okay to call a Lion an animal
		Animal leon = new Lion();
		
//		a.makeSound();
//		l.makeSound();
//		leon.makeSound();
		
		List<Carnivore> meateaters = new ArrayList<Carnivore>();
		
		// I can add human2 because it is labled as a carnivore
		meateaters.add(human2);
		//Even though this is a human Java knows the object is just an animal
		//meateaters.add(human);
		
		// I added a lion because the only requirement for the list
		// is to be a carnivore
		meateaters.add(l);
		
		for(Carnivore c : meateaters) {
			c.eatMeat();
		}
		
		// Using marker interfaces is a way to organize and designate classes
		// if it ends in able it is an interface* throwable is technically a class
		List<Petable> cutestuff = new ArrayList<Petable>();
		Bunny b = new Bunny();
		Giraffe g = new Giraffe();
		TeddyBear tb = new TeddyBear();
		
		cutestuff.add(tb);
		
		
		
		
		
		
		
		

	}

}
