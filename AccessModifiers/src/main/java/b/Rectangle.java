package b;

import a.Shape;

public class Rectangle extends Shape {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle();

		//we're able to see the prostring, because we're in a child class in a different package
		System.out.println(r.prostring );
		System.out.println(r.pubstring );
	}

}
