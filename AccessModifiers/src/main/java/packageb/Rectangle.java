package packageb;

import packagea.Shape;

public class Rectangle extends Shape {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		//we are able to see the protected string because we are in a child class
		//in a different package
		System.out.println(r.prostring);
	}
}
