package finalkeyword;

//final on a class means that you cannot inherit from this class anymore
public final class Calculator {
	
	
	// We can use the final keyword in three ways
	final int x = 100; //final means the value cannot change
	
	// putting final on a method removes the ability to override it
	public final void add() {
		System.out.println("Add feature");
	}

}
