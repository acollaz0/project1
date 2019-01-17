package collectionfun;
import java.util.*;

public class Person implements Comparable<Person> {
	
	String name;
	int age;
	int height;
	
	
	public Person(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	//the default constructor
	public Person() {
		
		
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	public int compareTo(Person p) {
		
		if(this.age<p.age) {
			return -1;
		}
		if(this.age>p.age){
			return 1;
		}
		return 0;
	}
	
	public static Comparator<Person> HeightComparator = new Comparator<Person>(){
		public int compare(Person p1, Person p2) {
			
			if(p1.height<p2.height) {
				return -1;
			}
			if(p1.height>p2.height) {
				return 1;
			}
			
			return 0;
		}
		
	};
	
	

}
