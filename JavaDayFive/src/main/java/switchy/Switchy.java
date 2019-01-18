package switchy;

public class Switchy {
	
	
	
	public static void main(String[] args) {
		
		//Switch statements are a form of control flow
		
		int choice = 3;
		
		// all cases must be unique i.e. you cannot have 
//		case 1:{some code}
//		case 1:{some other code} this is ambigous because the same 'choice' 1 has
		// two codes it could call
		
		//switches start execution of all case proceeding downward
		// A break is need to stop this execution
		
		//inputing 1 will execute case 1 and 170 and 3
		//inputing 3 will execute only case 3
	
		
		switch(choice) {
			
		case 1: {System.out.println("Execute case 1");}
		case 170: {System.out.println("Execute case 170");}
		case 3: {System.out.println("Execute case 3");} break;
		case 9: {System.out.println("Execute case 9");}
		default: {System.out.println("Anything else");}
		
		
		}
		
		
		// Java 7 introduced the ability to use strings in switch cases
		String decision = "steve";
		
		switch(decision) {
		
		case "mark":{System.out.println("Hello Marcus");} break;
		case "steve":{System.out.println("Hello Steven");} break;
		default:{System.out.println("not a valid name");}
		}
		
		
		
		
		
		
	}

}
