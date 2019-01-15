package encapsulation;

public class TestDrive {

	public static void main(String[] args) {
		
		//encapsulation will protect variables and methods from being used
		//in an illogical or unhelpful way
		Car c = new Car();
		c.model = "Subaru";
		//easy to create illogical values if you dont encapsulate
		c.setMpg(-111);
		System.out.println(c.getMpg());

	}

}
