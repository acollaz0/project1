package casino;

public class Casino {
	
	public static void main(String[] args) {
		
		double luck = Math.random();
		System.out.println(luck);
		
		try {
			gamble(luck);
		} catch (LostMoney e) {
			//e.printStackTrace();
		}
	}
	
	public static void gamble(double luck) throws LostMoney {
		
		if(luck>.70)
		{
			System.out.println("Congratulations you won money");
		}else {
			throw new LostMoney();
		}
		
	}
	
}
