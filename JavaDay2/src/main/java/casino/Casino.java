package casino;

public class Casino {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double luck = Math.random();
		System.out.println(luck);
		try {
			gamble(luck);
		} catch (LostMoneyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	public static void gamble(double luck) throws LostMoneyException {
		if(luck > .07) {
			System.out.println("You win money");
		} else {
			throw new LostMoneyException();
		}
	}
	
	

}