package factory;

public class CakeFactory {
	
	//With a factory desing. I say what my requirements are or what I want
	//And it will give a class/object
	
	public static Cake getCake(int amount) {
		if(amount >40) {
			return new WeddingCake();
		}
		else {
			return new CupCake();
		}
	}

}
