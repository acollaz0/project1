package garbage;

public class Book {
	
	String name;
	int pages;
	
	public Book(String name, int pages) {
		
		// "this" keyword denotes that the variable belongs to a single instance of a class
		this.name = name;
		this.pages = pages;
		
	}
	
	public String toString() {
		return this.name;
	}
	
	//Overrides a parent class' method.
	@Override
	//This method is called when an object is garbage collected. It is marked for deletion, and its
	//memory can be used
	//VERY BAD PRACTICE. Don't use finalize
	public void finalize() {
		System.out.println("This book was destroyed: " + this.name);
	}
	
}