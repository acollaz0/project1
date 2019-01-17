package factory;

public class CakeFactory {

	//With a factory design. I say what my requirements are or what i want
	//and it will give a class/object responsible or able to do what i want
	//without me ever knowing what that object was
	public static Cake getCake(int amount) {
		
		if(amount > 40)
			return new WeddingCake();
		else
			return new CupCake();
		
	}
}
