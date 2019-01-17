package abstractfun;

public interface Herbivore {
	
	//All interfaces can have variables. But they MUST all be public static final
	//Even if it isn't explicitly written.
	int num = 100;
	
	public default void eatsPlants() { //Using default implementation is a relatively new addition to java (Java 8)
		System.out.println("Eat plants yum");
	}

}
