package testing;

public class Acronym {
	
	
	public void main(String[] args) {
		
		String phrase = "hello";
		acronym(phrase);
		
	}
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String a="";
		for (int i=0; i <= phrase.length();i++) {
			
			/*if(phrase.charAt(i)=" ") {
				a=a+phrase.charAt(i+1);				
			}*/
			
		}
		System.out.println(a);
		
		// TODO Write an implementation for this method declaration
		return null;
	}

}
