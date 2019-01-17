package collectionfun;

import java.util.Comparator;

//Using Comparable is considered to be using the natural ordering
//gives you only ONE way that an object can be compared
//If you want more ways to compare, you need to use a comparator
public class Person implements Comparable<Person> {
	String name;
	int age;
	int height;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + "]\n";
	}
	
	public Person(String name, int age, int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * return -1 if this instance of Person is "smaller" than p
	 * 0 if they are equivalent
	 * 1 if this instance is "bigger"
	 */
	public int compareTo(Person p) {
		
		if (this.age<p.age) {//this instance is smaller than p
			return -1;
		}
		if (this.age>p.age) {//this instance is bigger than p
			return 1;
		}
		
		return 0;
	}
	
	//This is kind of a "static class"
	public static Comparator<Person> HeightComparator = new Comparator<Person>() {

		public int compare(Person p1, Person p2) {
			
			if (p1.height<p2.height) {
				return -1;
			}
			if (p1.height>p2.height) {
				return 1;
			}
			
			return 0;
		}
		
	};
	
}
