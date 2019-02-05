package factory;

public class CakeFactory {
	public static Cake getCake(int amount) {
		if(amount > 40) {
			return new WeddingCake();
		}else {
			return new Cupcake();
		}
	}
}
