package encapsulation;

public class TestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Encapsulation protects variables and methods from being used in an illogical or unhelpful way.
		
		Car c = new Car();
		c.setModel("Subaru");
		c.setMpg(-120000); 
		System.out.println(c);
		
		//it's easy to create illogical values if you don't encapsulate

	}

}