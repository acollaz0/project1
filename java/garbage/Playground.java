package garbage;

public class Playground {
	public static void main(String[] args) {
		Book frankenstein = new Book("Frankenstein", 1);
		Book frankenstein2 = new Book("Frankenstein", 2);
		Book frankenstein3 = new Book("Frankenstein", 3);
		
		Book it = new Book("It", 190);
		Book it2 = it;
		Book it3 = it2;
		it = null;
		//requests java run garbage collection
		System.gc();
		//You can't destroy objects and you shouldn't try
		
	}
}
