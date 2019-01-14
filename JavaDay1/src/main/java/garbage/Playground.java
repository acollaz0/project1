package garbage;

public class Playground {
	
	public static void main(String[] args) {
		//I have 3 frankenstien books
		//the new keyword 3 times
		Book frankenstein = new Book("Frankenstein", 140);
		Book frankenstein2 = new Book("Frankenstein", 140);
		Book frankenstein3 = new Book("Frankenstein", 140);
		
		Book dracula = new Book("Dracula", 400);
		//the object is eligible to be collected
		dracula = null;
		//it will REQUEST that an object be grabage collected
		System.gc();
		
		//only one book was created
		//the new keyword is only used once
		Book it = new Book("It", 140);
		Book it2 = it;
		Book it3 = it2;
		
		it = null;
		System.gc();
		
		System.out.println("End of Program");
		
		//You as the programmer cannot destroy objects and you shouldn't even try
		//the most you can do is ignore an object and delete its references
		//and Java will eventually take care of it
	}
	
	
	
}
