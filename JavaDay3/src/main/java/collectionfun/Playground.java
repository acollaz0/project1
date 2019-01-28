package collectionfun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Playground {

	public static void main(String[] args) {
		
		//default constructor will be provided for a class if there are no constructors
		//the default constructor is no arguments.
		
		Person p = new Person("Jimbo",47,60);
		
		
		Person adam = new Person("Adam",19,100);
		Person jacob = new Person("Jacob",24,80);
		Person jackson = new Person("Jackson",22,130);
		Person alex = new Person("Alex",30,160);
		
		List<Person> peeps = new ArrayList<Person>();
		
		peeps.add(alex);
		peeps.add(jackson);
		peeps.add(jacob);
		peeps.add(adam);
		peeps.add(p);
		peeps.add(adam);
		//order of insertion is maintained, and duplicates are allowed
		
		System.out.println(peeps);
		
		Set<Person> peepset = new HashSet<Person>();
		
		peepset.add(alex);
		peepset.add(jackson);
		peepset.add(jacob);
		peepset.add(adam);
		peepset.add(p);
		peepset.add(adam);
		//Order of insertion is not preserved, and can't store a duplicate object
		
		System.out.println(peepset);
		
		//ITERATORS:
		Iterator<Person> iter = peepset.iterator(); //note: Should define the generic <> so that you don't need
		//to cast iter's type later.
		
		while (iter.hasNext()) {
			Person dawg = iter.next();
			System.out.println(dawg.name);
		}
		
		//Enhanced for loops are nice
		//Only disadvantage is you cannot delete or create objects in the list in an enhanced for loop
		for (Person dawg : peeps) {
			System.out.println(dawg.name);
		}
		
		//MAPS:
		//Data always stored in key-value pairs. Cannot iterate over a map.
		//dictionary.keySet() is the closest you can get to iterating over a map.
		Map<String,Person> dictionary = new HashMap<String,Person>();
		
		dictionary.put("Adam", adam);
		dictionary.put("Jackson", jackson);
		dictionary.put("Alex", alex);
		
		System.out.println(dictionary.get("Adam"));
		
		
		
	}

}