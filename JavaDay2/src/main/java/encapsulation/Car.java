package encapsulation;

public class Car {
	//the private keyword means that a variable or method cannot be accessed anywhere but this one class
	
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
		if (mpg < 0) {
			this.mpg = 1; //set default
		} else {
			this.mpg = mpg;
		}
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", mpg=" + mpg + "]";
	}
	
	
	
	

}
