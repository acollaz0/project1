package scope;

public class Box 
{
	//Java does NOT HAVE A GLOBAL SCOPE
	
	// static/class scope: the variable or method belongs to the class
	// and not to any particular instance of the class
	static int staticnum = 10;
	
	//instance scope means that the variable/method is attached to a particular instance
	int instancenum = 100;
	
	//method scope are all variables created/initialized in a method
	//these do not leave the method.
	public void method() 
	{
		//method variable
		int methodnum = 0;
		
		//block scope
		if(true)
		{
			int blocknum = 9;
		}
		
	}
	
	
}
