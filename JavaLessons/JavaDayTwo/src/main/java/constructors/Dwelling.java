package constructors;

public class Dwelling {
	int area;
	
	public Dwelling(int area) {
		this.area = area;
		System.out.println("Making a dwelling of size " + area);

	}
	public Dwelling() {
		System.out.println("You asked me to make a dewlling with no params so ill make one for you.");
		
	}
	@Override
	public String toString() {
		return "Dwelling [area=" + area + "]";
	}
	
}
