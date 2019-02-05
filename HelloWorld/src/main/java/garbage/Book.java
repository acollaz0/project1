package garbage;

public class Book {
	
	String name;
	int pages;
	
	
	public Book(String name, int pages) {
		
		this.name = name;
		this.pages = pages;
		
	}
	
	public String toString(Book book) {
		return this.name;
	}
	
//	@Override
//	//method that is called when an object is garbage collected
//	// Marked for deletion and this memory can be used
	//using finalize is bad practice
//	public void finalize() {
//		
//		System.out.println(x);
//	}
}
