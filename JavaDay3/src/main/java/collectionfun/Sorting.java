package collectionfun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sorting {

	public static void main(String[] args) {
		
		Person p = new Person("Jimbo",30,60);
		
		
		Person adam = new Person("Adam",19,100);
		Person jacob = new Person("Jacob",24,80);
		Person jackson = new Person("Jackson",22,130);
		Person alex = new Person("Alex",30,100);

		List<Person> peeps = new ArrayList<Person>();

		peeps.add(alex);
		peeps.add(jackson);
		peeps.add(jacob);
		peeps.add(adam);
		peeps.add(p);
		peeps.add(adam);

		System.out.println(jacob.compareTo(adam));
		
		Set<Person> peepset = new TreeSet<Person>();
		
		peepset.addAll(peeps);
		
		System.out.println(peepset);
		//Notice there is no Jimbo.
		//He has the same age as Alex, and is therefore considered "the same" in a TreeSet (but not in a HashSet)
		
		//Utility method to sort an arraylist. Uses natural ordering of the Comparable interface
		Collections.sort(peeps);
		System.out.println(peeps);
		
		System.out.println(Person.HeightComparator.compare(jackson, alex));
		
		//The second argument makes the sort method use height to order the peeps list.
		Collections.sort(peeps, Person.HeightComparator);
		System.out.println(peeps);
		
		
	}

}
