package scope;

public class Practice {

	public static void main(String[] args) {
		
		// For static variable, don't need to make instance of Box class
		//"static" refers to the fact that the variable's memory location never changes
		System.out.println(Box.staticnum);
		
		Box box1 = new Box();
		System.out.println(box1.instancenum);
		
		Box box2 = new Box();
		box2.instancenum = 50;
		System.out.println(box2.instancenum);
		
		
	}

}
