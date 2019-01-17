package reflectionfun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Reflection is a way for Java to essentially write
//Java code within java code
//Reflection allows you to create code at Runtime
//You can use reflection to access private variables
//You can use reflection to destroy the string pool
public class Frankenstein {
	
	Method bark;
	Method meow;
	
	public Frankenstein() {
		try {
			this.bark = Dog.class.getMethod("bark", null);
			this.meow = Cat.class.getMethod("meow", null);
		}catch(NoSuchMethodException e) {
			
		}catch(SecurityException e) {
			
		}
	}
	public static void main(String[] args) {
		Frankenstein catdog = new Frankenstein();
		try {
			catdog.meow.invoke(meow);
		}catch(IllegalAccessException e) {
			
		}catch(IllegalArgumentException e) {
			
		}catch(InvocationTargetException e) {
			
		}
		Method[] methods = String.class.getMethods();
		for(Method m : methods) {
			System.out.println(m.toGenericString());
		}
	}
}
