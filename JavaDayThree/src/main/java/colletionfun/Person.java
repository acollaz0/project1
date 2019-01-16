package colletionfun;

import java.util.Comparator;

// using comparable is considered to be the natural ordering
// It gives only one way that an object can be compared
public class Person implements Comparable<Person>{
	
	String name;
	int age;
	int height;
	
	public Person(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	// the default constructor explicitly written
	public Person() {
		super();	
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
	}

	public int compareTo(Person p) {
		
		if(this.age<p.age) {
			return -1;
			// the negative one means that this instance of person
			// is 'smaller' than the person I am comparing it to
		}
		if(this.age>p.age) {
			return 1;
			// the positive one means that this instance of person
			// is 'larger' than the person I am comparing it to
		}	
		return 0;
	}
	
	public static Comparator<Person> HeightComparator = new Comparator<Person>() {

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
