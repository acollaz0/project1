package garbage;

public class Playground {

	public static void main(String[] args)
	{
		//I have 3 frankenstein books
		Book frankenstein = new Book("Frankenstein", 140);
		Book frankenstein2 = new Book("Frankenstein", 140);
		Book frankenstein3 = new Book("Frankenstein", 140);
		
		
		Book dracula = new Book("Dracula", 400);
		
		dracula = null;
		
		//It will REQUEST that an object be garbage collected
		System.gc();
		
		//Only one boo was created
		//the new keyword is only used once
		Book it = new Book("It", 190);
		Book it2 = it;
		Book it3 = it2;
		
		it = null;
		System.gc();
		
		//You as the programmer cannot destroy objects and you shouldn't even try.
		//THe most you can do is ignore an object and delete references
		//and Java will eventually take care of it.
	}
}
