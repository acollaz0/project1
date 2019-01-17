package comparison;

public class Judge {
	
	public static void main(String[]args) {
		Apple a = new Apple();
		a.mass = 20;
		a.sour = false;
		
		Apple a2 = new Apple();
		a2.mass = 20;
		a2.sour = true;
		
		//whenever you have 2 objects with different states end up with the same 
		//hash number - hash collision
		
		Orange o = new Orange();
		o.mass = 20;
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		//successfully compared apples and oranges
		
		System.out.println(a.equals(o));
		System.out.println(o.equals(a));
		
	}

}
