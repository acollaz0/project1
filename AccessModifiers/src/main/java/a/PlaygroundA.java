package a;

public class PlaygroundA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s = new Shape();
		
		//We see all the strings except privstring because we're not inside the Shape class
		System.out.println(s.defstring );
		System.out.println(s.prostring );
		System.out.println(s.pubstring );

	}

}
