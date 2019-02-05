package factory;

public class Orderer {
	//I need a cake for 100 people
	Cake largeCake = CakeFactory.getCake(100);
	
	Cake smallcake = CakeFactory.getCake(10);
}
