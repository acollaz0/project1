package finalkeyword;

//final on a class means you cannot inherit from this class anymore
//String is a final class, it is immutable.
public final class Calculator {
	
	//the final keyword means this cannot be changed
	final int x = 100;
	
	public final void add() {
		System.out.println("Add feature");
	}
	
}
