package garbagepackage;

public class Playground {

	public static void main(String[] args) {
		
		// 3 Frankenstein books
		// the 'new' keyword was used 3 times
		Book Frankenstein = new Book("Frankenstein", 140);
		Book Frankenstein2 = new Book("Frankenstein", 140);
		Book Frankenstein3 = new Book("Frankenstein", 140);
		
		Book dracula = new Book("Dracula", 400);
		
		//the object is eligible for collection
		dracula = null;
		
		//it will REQUEST that an object be garbage collected
		System.gc();
		
		// Only 1 book 
		// the 'new' keyword was used once
		Book it = new Book("It", 190);
		Book it2 = it;
		Book it3 = it2;
		
		it = null;
		System.gc();
		
		System.out.println("End of program");
	
		// The programmer cannot destroy objects and should not even try
		// most that can be done is simply ignoring an object and delete references
		// Java will eventually take care of it
	}
	
}
