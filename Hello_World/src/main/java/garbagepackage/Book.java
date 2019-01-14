package garbagepackage;

public class Book {

	String name;
	int pages;
	
	public Book(String name, int pages) {
			
		// the 'this' keyword denotes that it belongs to a single instance of a class
		this.name = name;
		this.pages = pages;
			
	}
	
	public String toSting() {
		return this.name;
	}
	
	@Override
	// this method is a method that is called when an object is garbage collected.
	// marked for deletion. Its memory can be used for another purpose
	// NEVER use finalize. It is bad practice
	public void finalize() {
		
		System.out.println("The Book was destroyed" + " " + this.name);
		
	}
	
}
