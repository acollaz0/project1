package comparison;

public class Judge {
	public static void main(String[] args) {
		Apple a = new Apple();
		a.mass = 20;
		a.sour = false;
		
		Apple a2 = new Apple();
		a.mass = 20;
		a.sour = false;
		
		//Whenever you have two objects with different 
		//states end up with the same
		//hash number it is called a hash collision
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		Orange o = new Orange();
		o.mass = 20;

		System.out.println(a.equals(o));
		System.out.println(o.equals(a));
		
		System.out.println();
	}
}
