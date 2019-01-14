package garbage;

public class Book {
	
	String name;
	int pages;
	
	public Book(String name, int pages) {
		
		// The 'this' keyword denotes that the variable belongs to a single instance of a class.
		this.name = name;
		this.pages = pages;
	}
	
	public String toString() {
		
		return this.name;
	}
	
	@Override
	// This method is a method that is called when an object is garbage collected.
	// Marked for deletion. Its memory can be used for another purpose.
	// NEVER use finalize. It is bad practice.
	public void finalize() {
		
		System.out.println("The book was destroyed: " + this.name);
	}
}
