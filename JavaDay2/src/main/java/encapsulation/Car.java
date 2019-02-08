package encapsulation;

public class Car {
	
	String model;
	//by using private i have said this variable cannot be accessed anywhere
	//other than this class
	private int mpg;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMpg() {
		return mpg;
	}
	public void setMpg(int mpg) {
		if(mpg < 0) {
			this.mpg = 1;
		}
		else
			this.mpg = mpg;
	}
	
	
	

}
