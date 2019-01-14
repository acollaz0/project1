package garbage;

public class Playground {

	public static void main (String[] args) {
		
		//I have 3 frankenstein books
		//the 'new' keyword 3 times
		Book frankenstein = new Book("Frenkenstein", 140);
		Book frankenstein2 = new Book("Frenkenstein", 140);
		Book frankenstein3 = new Book("Frenkenstein", 140);

		Book dracula = new Book ("Dracula", 400);
		
		//the object is eligible for collection
		dracula = null;
		
		//it will REQUEST that an object to be garbage collected
		System.gc();
		
		//only one book was created 
		//the new keyword is only used once
		Book it = new Book("It", 190);
		Book it2 = it;
		Book it3 = it;
		
		it = null;
		System.gc();
		
		System.out.println("End of program");
		
		//You as the programer cannot destroy objects and you should not even
		//try. The most you can do is ignore an object and delete its references
		//and Jave will evnentually take care of it
	}
}
