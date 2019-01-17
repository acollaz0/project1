package abstractfun;

import java.util.ArrayList;
import java.util.List;

public class Jungle {

	public static void main(String[] args) {
		
		//Animal a = new Animal(); //Can't make *just* an animal
		Lion l = new Lion();
		
		//Can still label a lion as an animal, tho
		Animal leo = new Lion();
		
		//a.makeSound();
		l.makeSound();
		leo.makeSound();
		
		Animal h = new Human();
		//Java only knows that this object has methods declared within the Animal class.
		//Java will fail to compile if you try to use "h" methods that aren't declared inside Animal.
		h.eat();
		
		Carnivore hcar = new Human();
		//Works very similarly to the case above. hcar can only access the eatMeat() method
		hcar.eatMeat();
		
		List<Carnivore> meateaters = new ArrayList<Carnivore>();
		
		meateaters.add(hcar);
		meateaters.add(l); //Can have both lions and humans in this list, since the only requirement is the Carnivore interface.
		//can't add "h" because Animal doesn't implement Carnivore, and java only sees it as an Animal.
		
		for (Carnivore c : meateaters) {
			c.eatMeat();
		}
		
		List<Petable> cutestuff = new ArrayList<Petable>();
		Bunny b = new Bunny();
		Giraffe g = new Giraffe();
		TeddyBear tb = new TeddyBear();
		
		cutestuff.add(b);
		cutestuff.add(g);
		cutestuff.add(tb);
		//Useing a marker interface is a way for us to organize very different objects
		//Generally, if it ends in "-able" then it is an interface

	}

}
