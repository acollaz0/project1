package garbage;

public class Playground {
	
	public static void main (String[] args) {
		
		//I have 3 frenkenstain books
		// the new keyword 3 times
		Book frankenstein = new Book("Frankenstein", 140);
		Book frankenstein2 = new Book("Frankenstein", 140);
		Book frankenstein3 = new Book("Frankenstein", 140);
		
		Book dracula = new Book("Dracula", 400);
		
		// the object is elligble for collection
		dracula = null;
		
		//it will REQUEST that an object be garbage collected
		System.gc();
		
		// 1 book was created
		// new keyword is only used once
		Book it = new Book("It", 190);
		Book it2 = it;
		Book it3 = it2;
		
		it = null;
		System.gc();
		
		System.out.println("End of program");
		
		//you as the programer can nor destroy objects and you shouldnt even try
		//the most you can do is ignore an object and delete reference
		// and eventually Java will take care of it
	}	

}
