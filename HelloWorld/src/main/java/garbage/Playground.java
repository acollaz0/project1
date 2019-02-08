package garbage;

public class Playground {
	
	public static void main(String [] args) {
		
		//I have 3 frankenstein books
		//the new keyword 3 times
		Book frankenstein = new Book("Frankenstein",140);
		Book frankenstein2 = new Book("Frankenstein",140);
		Book frankenstein3 = new Book("Frankenstein",140);
		
		Book dracula = new Book("Dracula",400);
		dracula = null;
		
		//only one book was created
		//the new keyword is only used once
		Book it = new Book("It",190);
		Book it2 = it;
		Book it3 = it2;
		
		//it will REQUEST that an object be garbage collected
		System.gc();
		
		it = null;
		System.gc();
		
		System.out.println("End of program");
		
		//you as the programmer cannot destroy objects and you shuldnt even try
		//the most you can do is ignore an object and delete it's references and hope 
		// that Java will eventually take care of it
		
	}

}
