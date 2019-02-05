package casino;

public class Casino {

	public static void main(String[] args) {

		double luck = Math.random();
		System.out.print(luck);
		try {
		gamble();
		}catch(LostMoney e) {
//			e.printStackTrace();
		}
	}
	public static void gamble(double luck) throws LostMoney {
		if (luck > .7) {
			System.out.println("Congratulations you won the money");
		}else {
			throw new LostMoney();
		}
	}

}
