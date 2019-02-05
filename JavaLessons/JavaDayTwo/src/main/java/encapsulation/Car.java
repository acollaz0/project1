package encapsulation;

public class Car {
	private String model;
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
		if(mpg < 0) 
			this.mpg = 1;
		
		this.mpg = mpg;
	}
	
}
