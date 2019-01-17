package constructors;

public class Dwelling {
	
	int area;
	
	//Can overload constructors as much as you want
	//must be named the same as the class you are building
	public Dwelling(int area) {
		System.out.println("Setting Dwelling area to " + area);
		this.area = area;
	}

	public Dwelling() {
		System.out.println("Setting Dwelling area to default of 100");
		this.area=100;
	}

	@Override
	public String toString() {
		return "Dwelling [area=" + area + "]";
	}

}
