package garbage;

public class Book {
	
	String name;
	int pages;
	
	public Book(String name, int pages) {
		// the this keyword denotes that belongs to a single instance of a class
		this.name = name;
		this.pages = pages;
	}
	
	public String toString() {
		
		return this.name;
	}
	
	// tells compiler that about to override parent class
	// called when an object is garbage collecting - marked for deletion
	// memory to be used for other purpose
	@Override
	// never use finalize. it is bad practice
	public void finalize() {
		
		System.out.println("The book was destroyed " + this.name);
	}
	
}
