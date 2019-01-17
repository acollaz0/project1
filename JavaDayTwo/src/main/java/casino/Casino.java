package casino;

public class Casino {

	public static void main(String[] args) {
		
		double luck = Math.random();
		System.out.println(luck);
		
		try {
		gamble(luck);
		}catch(LostMoney e) {
			
		}
		
	}
	public static void gamble(double luck) {
		
		if(luck>.70) {
			System.out.println("Congratulations you won money");
		}
		else {
			throw new LostMoney();
		}
	}
}
