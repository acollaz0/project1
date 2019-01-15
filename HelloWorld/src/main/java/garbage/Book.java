package garbage;

public class Book {

	
	String name;
	int pages;
	
	public Book(String name, int pages) {
		
		//'this' keyword denotes that the belongs to a single instance of a class
		this.name = name;
		this.pages = pages;
	}
	public String toString() {
		
		return this.name;
	}
	
	@Override
	//this method is a method that is called when an object is garbage collected
	// marked for deletion. its memory can be used for another purpose
	// NEVER use finalize. it is bad practice 
	public void finalize() {
		System.out.println("the book was destroyed" + this.name);
	}

}
