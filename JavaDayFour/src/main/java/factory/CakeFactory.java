package factory;

public class CakeFactory {
	
	// With a factory design. I say what my requirements are or what I want
	// And it will give a class/object responsible or able to do what I want
	// without me ever needing what that object was
	public static Cake getCake(int amount) {
		
		if(amount >40) {
			return new WeddingCake();
		}else {
			return new CupCake();
		}
	}
	

}
