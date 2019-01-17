package factory;

public class Orderer {

	public static void main(String[] args) {
		//I need a cake for 100 people
		Cake largecake = CakeFactory.getCake(100);
		largecake.serve();
		
		Cake smallcake = CakeFactory.getCake(10);
		smallcake.serve();
		
	}

}
