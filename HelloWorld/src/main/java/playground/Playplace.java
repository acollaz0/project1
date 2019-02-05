package playground;

public class Playplace {

	public static void main(String[] args) {
//		String s1 = "+1 (613)-995-0253";
//		String s2 = "613-995-0253"; 
//		String s3 = "1 613 995 0253";
//		String s4 = "613.995.0253";
		
		StringBuilder sb1 = new StringBuilder();
//		StringBuilder sb2 = new StringBuilder();
//		StringBuilder sb3 = new StringBuilder();
//		StringBuilder sb4 = new StringBuilder();
		
		String ws = "223 456   7890   ";
		
		for(String str : ws.split("[^0-9]")) {
			sb1.append(str);
		}
		
		System.out.println(sb1.toString());
		
		
	}

}
