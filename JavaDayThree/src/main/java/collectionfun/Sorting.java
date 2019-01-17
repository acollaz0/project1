package collectionfun;

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
		Person art = new Person("Art",30,160);
		
		List<Person> people = new ArrayList<Person>();
		
		people.add(adam);
		people.add(jacob);
		people.add(jaxon);
		people.add(art);
		
		Set<Person> peopleset = new TreeSet<Person>();
		
		//In a set Jaxon is removed because it was considered the same when it came to ordering
		
		peopleset.addAll(people);
		System.out.println(peopleset);
		//utility methods
		Collections.sort(people);
		System.out.println(people);
		Collections.sort(people,  Person.HeightComparator);
		System.out.println(people);
		

	}
}
