package factory;

public class Orderer {
	
	public static void main(String[] args) {
		
		// I need a cake for 100 people
		Cake largecake = CakeFactory.getCake(100);
		largecake.serve();
		
		//I need a cake for only 10 people
		Cake smallcake = CakeFactory.getCake(10);
		smallcake.serve();
		
	}

}
