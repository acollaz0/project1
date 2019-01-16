package colletionfun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sorting {

	public static void main(String[] args) {
		Person adam = new Person("Adam",19,100);
		Person jacob = new Person("Jacob",24,80);
		Person jaxon = new Person("Jaxon",24,130);
		Person alex = new Person("Alex",30,130);
		
	List<Person> people = new ArrayList<Person>(); 
		
		people.add(adam);
		people.add(jacob);
		people.add(jaxon);
		people.add(alex);
		people.add(adam);
		
		Set<Person> peopleset = new TreeSet<Person>();
		peopleset.addAll(people);
		// Jaxon was removed because it was considered the same when it came to ordering
		// and this is a set
		//System.out.println(peopleset);
		
		//utility methods. This one will order my list using compareTo
		//natural ordering uses comparable
		// My list is now ordered
		Collections.sort(people);
		
//		System.out.println(people);
		
		// Logic is the same as compare to but this takes in to objects. It does not
		// use itself in the comparison
//		System.out.println(Person.HeightComparator.compare(alex, jaxon));
		

		// comparator allows us as many ways as we want to compare objects/ order them
		Collections.sort(people,Person.HeightComparator);
		
		System.out.println(people);
	
	
	}

}
