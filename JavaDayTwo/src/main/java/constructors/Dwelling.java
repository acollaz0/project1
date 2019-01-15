package constructors;

public class Dwelling {
	
	int area;
	
	// You can overload constructors all you want
	// constructors must be named the same as the class that you are building
	public Dwelling(int area) {
		System.out.println("Making a dwelling of size " + area);
		this.area = area;	
	}
	
	public Dwelling() {
		System.out.println("You asked me to make a dwelling with no paramerter sooo ill just make one for you");	
		this.area = 100;
	}

	@Override
	public String toString() {
		return "Dwelling [area=" + area + "]";
	}
	

}
