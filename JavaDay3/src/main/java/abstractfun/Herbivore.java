package abstractfun;

public interface Herbivore {
	
	//all interfaces can have variables BUT they must all be public static final
	//Even if it is not explicitly written
	int num = 100;
	
	//Since Java 8 you can use the default keyword to define an implementation
	public default void eatPlant() {
		System.out.println("Eat plants yum");
	}

}
