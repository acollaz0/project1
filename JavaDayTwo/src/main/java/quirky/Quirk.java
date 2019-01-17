package quirky;

public class Quirk {
	
	public static void main(String[] args) {
		//will not compile
		/*while(false) {
			System.out.println("In a flase loop");
		}*/
		//will compile
		if(false) {
			System.out.println("In a false statement");
		}
		//this is from before ide(s) which would allow easy debugging
		
	}

}
