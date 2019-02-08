package abstractfun;

public interface Herbivore {

	//All interfaces can have variables BUT they must all be public static final
	//even if it not explicitly written
	int num = 100;
	
	//since Java 8 you can use the default keyword to define an implementation
	public default void eatPlant() {
		System.out.println("Eat plants");
	}
}
