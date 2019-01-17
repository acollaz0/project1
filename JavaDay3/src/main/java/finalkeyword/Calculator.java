package finalkeyword;

public class Calculator {
	
	//Can use the "final" keyword in three ways
	//1: Can use final on a variable
	final int x = 100; //final means that the value cannot change
	
	//2: Can use final on a method:
	//putting final on a method removes the ability to override it
	public final void add() {
		System.out.println("Add feature");
	}

}
