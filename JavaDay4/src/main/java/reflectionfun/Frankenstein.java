package reflectionfun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Reflection is a way for Java to essentially write Java code from within Java
//Reflection allows you to create code at run time
//It allows you to manipulate anything basically
//you can use Reflection to destroy the string pool
//you could use Reflection to access private variables

public class Frankenstein {

	Method bark;
	Method meow;
	
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
	
	public static void main(String [] args) {
	
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
		
		//you can edit Java to your heart's content with reflection
		for(Method m : methods) {
			System.out.println(m.toGenericString());
		}
		
	}
	
}
