package a;

public class Shape {
	
	//This variable is accessible anywhere in the application
	public String pubstring = "public string";
	
	//This is like default, but there is the loophole that if you inherit this class, you get access to this variable
	protected String prostring = "protected string";
	
	//default has no access modifier. Means that the variable is accessible only within same package
	//defstring is available to any class in "a"
	String defstring = "default string";
	
	//private variables are only accessible within the same class.
	private String privstring = "private string";
	
	

}
