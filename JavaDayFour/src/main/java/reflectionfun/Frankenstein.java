package reflectionfun;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Reflection is a way for Java to essentially write Java code from with Java
// Reflection allows you to create code at run time
// It allows you to manipulate anything basically
// You can use reflection to destroy the string pool
// You could use reflection to access private variables
public class Frankenstein {

	Method bark;
	Method meow;
	
	Field f;
	
	// the class class
	Class c;
	
	public Frankenstein() {
		
		try {
			
			this.bark = Dog.class.getMethod("bark", null);
			this.meow = Cat.class.getMethod("meow", null);
				
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Frankenstein catdog = new Frankenstein();
		
		try {
			catdog.meow.invoke(null, null);
			catdog.bark.invoke(null, null);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Method [] methods = String.class.getMethods();
		
		// You can edit Java to your heart's content with reflection
		for(Method m : methods) {
			
			System.out.println(m.toGenericString());
			
		}
		
	}
	
	
}
