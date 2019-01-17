package encapsulation;

public class TestDrive {
	
	public static void main(String[] args) {
		//encapsulation will protect variables and methods from being used
		//In an illogical of unhelpful way
		Car c = new Car();
		c.model = "Subaru";
		//easy to create illogical values if you don't encapsulate it
		c.setMpg(-111);
		System.out.println(c.getMpg());
		}

}
