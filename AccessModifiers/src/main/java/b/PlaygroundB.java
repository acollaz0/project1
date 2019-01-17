package b;

import a.Shape;

public class PlaygroundB {

	public static void main(String[] args) {

		Shape s = new Shape();
		
		//We can only access pubstring because public varables are available anywhere
		System.out.println(s.pubstring );

	}

}
