package constructors;

public class Dwelling {
	
	int area;
	public Dwelling(int area) {
		System.out.println("Making a dwelling of size " +area);
		this.area = area;
		
	}
	public Dwelling() {
		
		System.out.println("You asked me to make a dwelling with no parameter sooo i'll make you this");
		this.area = 100;
	}
	@Override
	public String toString() {
		return "Dwelling [area=" + area + "]";
	}
	

}
