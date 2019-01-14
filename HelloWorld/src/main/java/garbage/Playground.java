package garbage;

public class Playground {
	
	public static void main(String[] args) {
		
		//Have three objects, even though they are functionally identical
		Book frankie = new Book("Frankenstein", 99);
		Book frankie1 = new Book("Frankenstein", 99);
		Book frankie2 = new Book("Frankenstein", 99);
		
		
		Book drack = new Book("Dracula", 456);
		drack = null; //This alone won't trigger the finalize method. Just says it's eligible for 
		//garbage collection
		
		System.gc(); //Request garbage collection
		
		//Only one book object was created
		Book it = new Book("It",678);
		Book it2 = it;
		Book it3 = it2;
		
		it = null;
		
		System.gc();
		//The programmer cannot destroy objects, and don't even try.
		//Can only ignore object and delete references and hope java takes care of it.
		
	}
	
}
