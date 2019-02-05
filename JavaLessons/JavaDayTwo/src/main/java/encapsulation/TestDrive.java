package encapsulation;

public class TestDrive {
	public static void main(String[] args) {
		//encapsulation will protect variables and methods from being used
		//in an illogical or silly way
		Car c = new Car();
		c.setModel("Subaru");
		//easy to create illogical values
		c.setMpg(-100);
//		easy to create illogical values if you don't encapsulate
	}
}
