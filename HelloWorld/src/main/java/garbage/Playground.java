package garbage;

public class Playground {
	
	public static void main(String [] args) {
		
		// create three books
		Book frankenstein = new Book("Frankenstein", 140);
		Book frankenstein2 = new Book("Frankenstein", 140);
		Book frankenstein3 = new Book("Frankenstein", 140);
		
		// 
		Book dracula = new Book("Dracula", 400);
		
		// the object is eligible for collection
		dracula = null;
		
		// it will REQUEST that an object be garbage collected
		System.gc();
		
		// create one book
		Book it = new Book("It", 190);
		Book it2 = it;
		Book it3 = it2;
		
		it = null;
		System.gc();
		
		System.out.println("End of program.");
		
		// You as the programmer cannot destroy objects and you shouldn't even try
		// The most you can do is ignore an object and delete references 
		// And Java will eventually take care of it

	}
}
