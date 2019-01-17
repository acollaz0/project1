package abstractfun;

public interface Herbivore {
	//All interfaces can have variables but they must all be
	//public static final
	//even if not explicitly written
	
	public default void eatPlant() {
		
	}

	void makeSound();
}
