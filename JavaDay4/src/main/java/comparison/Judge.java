package comparison;

public class Judge {

	public static void main(String[] args) {
		
		Apple a = new Apple();
		a.mass=20;
		a.sour=false;
		Orange o = new Orange();
		o.mass=20;
		
		//The equals method is overridden all the time
		System.out.println(a.equals(o));
		System.out.println(a.hashCode());
		
		Apple a2 = new Apple();
		a2.mass=20;
		a2.sour=true;
		
		
		
		

	}

}
