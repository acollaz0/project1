package collectionfun;

import java.util.Comparator;

// using comparable is considered to be the natural ordering
//It gives only one way that an object can be compared
public class Person implements Comparable<Person> {
	String name;
	int age;
	int height;
	
	//default constructor will be provided for a class if you don't have any constructors
	public Person(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	public int compareTo(Person p) {
		//-1 means that this instance is smaller than the person I am comparing it to
		if(this.age< p.age) 
			return -1;
		if(this.age > p.age) {
			return 1;
		}
		return 0;
	}
	//static class
	public static Comparator<Person> HeightComparator = new Comparator<Person>(){
		public int compare(Person p1, Person p2) {
			if(p1.height < p2.height) 
				return -1;
			if(p1.height > p2.height)
				return 1;
			return 0;
		}
		
	};
	
	
}
