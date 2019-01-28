package reflectionfun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Reflection is a way to for java to essentially write javacode from within java
//Reflection allows you to create code at runtime. You can manipulate anything.
//Can destroy the string pool
//access private variables
//
public class Frankenstien {
	
	Method bark;
	Method meow;
	
	public Frankenstien() {
		
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
		Frankenstien catdog = new Frankenstien();
		try {
			catdog.meow.invoke(null, null);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		Method[] methods = String.class.getMethods();
		
		for (Method m : methods) {
			System.out.println(m.toGenericString());
		}
		
	}

}