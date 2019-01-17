package factory;

public class Orderer {
	
	public static void main(String[]args) {
		//I need a cake for 100 people
		Cake largeCake = CakeFactory.getCake(100);
		largeCake.serve();
		
		Cake smallCake = CakeFactory.getCake(10);
		smallCake.serve();
		
	}

}
