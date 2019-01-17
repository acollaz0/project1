package comparison;

public class Judge {

	public static void main(String[] args) {
		Apple a = new Apple();
		a.mass = 20;
		a.sour = false;
		
		Apple a2 = new Apple();
		a2.mass = 20;
		a.sour = true;
		
		// whenever you have two objects with different states end up with the same
		// hash number  hash collision
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(a.hashCode());
		
		Orange o = new Orange();
		o.mass = 20;
		
		// successfully compared apples to oranges
		// The equals method is overridden all the time
		// second perhaps only to toString
		System.out.println(a.equals(o));
		
		System.out.println(o.equals(a));

	}

}
