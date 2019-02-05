package a;

public class Shape {
	
	//can be accessed anywhere
	public String pubstring = "Public String";
	
	//esseniallt default with loophole if you inherit from the class you can get access
	protected String prostring = "Protected String";
	
	//default no access modifier means that the variable is only within the same 
	//package any class in a package can use this string
	String defstring = "Default String";
	
	//private String
	private String pristring = "Private String";
}
