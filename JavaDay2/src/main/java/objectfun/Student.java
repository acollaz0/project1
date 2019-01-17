package objectfun;

public class Student {
	String name;
	int age;
	
	
	//normally written toString()
//	@Override
//	public String toString() {
//		return this.name + " " + this.age;
//	}
	
	//generated toString by STS
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
