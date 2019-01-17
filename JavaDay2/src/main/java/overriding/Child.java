package overriding;

public class Child extends Parent {
	
	@Override
	public void work() {
		System.out.println("I'll start rock band instead");
	}
	
}
