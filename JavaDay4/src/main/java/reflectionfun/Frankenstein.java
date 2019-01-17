package reflectionfun;

import java.lang.reflect.InvocationTargetException;
import java.lang.relect.Method;
//refelection is a way for Java to essentially write code from within Java
//Reflection allows you to create code at run time
//It allows you to manipulate anything basically
//You could use reflection to access private variables
public class Frankenstein {
	
	Method bark;
	Method meow;
	
	public Frankenstein() {
		try {
		this.bark = Dog.class.getMethod("bark", null);
		this.meow = Cat.class.getMethod("Meow", null);
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		}catch (SecurityException e) {
			e.printStackTrace();
		}
		
		public static void main(String[]args) {
			
			Frankenstein catdog = new Frankenstein();
			
			try {
				catdog.meow.invoke(null,null);
				catdog.bark.invoke(null,null);
			}catch(IllegalAccessException e) {
				e.printStackTrace();
			}catch(IllegalArgumentException e) {
				e.printStackTrace();
			}catch(InvocationTargetException e) {
				e.printStackTrace();
			}
			
			Methods [] method
		}
		
	}
	

}
