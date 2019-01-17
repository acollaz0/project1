package abstractfun;

import java.util.ArrayList;
import java.util.List;

public class Jungle {
	
	public static void main(String[] args) {
		Lion l = new Lion();
		//Java only knows that this object has methods declared within the Animal Class
		//despite the fact it has other methods as well
		Animal human = new Human();
		
		human.makeSound();
		
		Human human2 = new Human();
		human2.eatMeat();
		
		Animal leon = new Lion();
		
		List<Carnivore> meateaters = new ArrayList<Carnivore>();
		meateaters.add(human);
		meateaters.add(human2);
		
		for(Carnivore c : meateaters) {
			c.eatMeat();
		}
	}

	
}
