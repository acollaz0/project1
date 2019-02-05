package testing;

public class Test {
	
	public static void main(String[]args) {
		
		System.out.println(calculateNthPrime(100));
	}
		
	public static int calculateNthPrime(int n) {
		// TODO Write an implementation for this method declaration
		int count =2;
		int prime =3;
		if(n==1) {
			return 2;
		}
		else if(n==2){
			return 3;
		}
		else {
		do {
			if(count%2!=0) {
				if(count%3!=0) {
					count++;
				}
			}
			prime++;
			
			
			
		}while(count<=n);
		}
		return prime;
	}

}
