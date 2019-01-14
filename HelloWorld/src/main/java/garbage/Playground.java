package garbage;

public class Playground {
	
	public static void main(String[] args) {
		
		// I have 3 frankenstein books
		// Used the 'new' keyword 3 times 
		Book frankenstein = new Book("Frankenstein", 140);
		Book frankenstein2 = new Book("Frankenstein", 140);
		Book frankenstein3 = new Book("Frankenstein", 140);
		
		Book dracula = new Book("Dracula", 400);
		
		// The object is ELIGIBLE for garbage collection
		dracula = null;
		
		// REQUEST that an object be garbage collected
		System.gc();
		
		// Only one book was created
		// Used the 'new' keyword only once
		Book it = new Book("It", 190);
		Book it2 = it;
		Book it3 = it2;
		
		// it2 and it3 still hold memory address of "It" book
		it = null;
		System.gc();
		
		System.out.println("End of program");
		
		// You as the programmer cannot destroy objects and you shouldn't even try.
		// The most you can do is ignore an object and delete its references.
		// Java will eventually take care of it.
	}
}
