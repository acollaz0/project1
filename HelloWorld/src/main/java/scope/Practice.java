package scope;

public class Practice {

	public static void main(String[] args) {
		//static belongs to the class
		//Shared among all the instances
		System.out.println(Box.staticnum);
		
		Box box1 = new Box();
		System.out.println(box1.instancenum);
		
		Box box2 = new Box();
		box2.instancenum = 50;
		System.out.println(box2.instancenum);
		System.out.println(box1.instancenum);
	}

}
