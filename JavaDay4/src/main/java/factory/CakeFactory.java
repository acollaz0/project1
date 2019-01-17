package factory;

public class CakeFactory {
	//A class designed to return the appropriate class that implements Cake interface
	//you input what your requirements are, and the factory returns an appropriate class without you ever needing 
	//to know what that object was
	
	
	public static Cake getCake(int peopletoserve) {
		
		if (peopletoserve > 40) {
			return new WeddingCake();
		}
		
		return new Cupcake();
	}

}
