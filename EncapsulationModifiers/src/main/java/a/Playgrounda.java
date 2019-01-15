package a;

public class Playgrounda {

	public static void main(String[] args) {
		Shape s = new Shape();
		
		// We see all of them except for private because this is not the shape class
		System.out.println(s.defstring);
		System.out.println(s.pubstring);
		System.out.println(s.prostring);
		
		

	}

}
