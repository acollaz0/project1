package a;

public class Shape {

	//Public means that this variable is accessible anywhere in the application
	public String pubstring = "Public String";
	
	//essentially default with the loophole that is you inherit this class you can get access
	protected String prostring = "Protected String";
	
	//default no access modifier means that the variable is only within the same package
	//any class in a can use this string
	String defstring = "Default String";
	
	//A private modifier means that the variable can only be accessed in the same class
	private String privstring = "Private String";
	
}
