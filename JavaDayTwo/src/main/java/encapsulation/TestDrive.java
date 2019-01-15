package encapsulation;

public class TestDrive {

	public static void main(String[] args) {
		//encapsulation will protect variables and methods from being used
		// In an illogical or unhelpful way
		Car c = new Car();
		c.model = "Subaru";
		c.setMpg(-111);
		System.out.println(c.getMpg());
		
		// easy to create illogical values if you do not encapsulate
		
		

	}

}
