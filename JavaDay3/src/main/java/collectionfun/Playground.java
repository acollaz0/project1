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

		//default constructor will be provided if you do not have any
		//constructors. The default constructor is no arguments
		
		Person p = new Person();
		
		Person adam = new Person("Adam", 19, 100);
		Person jacob = new Person("Jacob", 24, 80);
		Person jackson = new Person("Jackson", 22, 130);
		Person alex = new Person("Alex", 30, 160);
		
		//List maintains the order of insertion and allows duplicates
		List<Person> people = new ArrayList<Person>();
		
		people.add(adam);
		people.add(jacob);
		people.add(jackson);
		people.add(alex);
		people.add(adam);
		
		//System.out.println(people);
		
		//order of insertion is not preserved and I cannot store a duplicate object
		Set<Person> peopleset = new HashSet<Person>();
		
		peopleset.add(adam);
		peopleset.add(jacob);
		peopleset.add(jackson);
		peopleset.add(alex);
		peopleset.add(adam);
		
		System.out.println(peopleset);
		
		//generics are like the bouncer who only allows certain objects into a collection
		Iterator<Person> iter = peopleset.iterator();
		
		//iterating over the list printing out names
		while(iter.hasNext()) {
			Person person = iter.next();
			System.out.println(person.name);
			
		}
		
		//enhanced for loops are the best i love them
		//you cannot remove or create objects in an enhanced for loop
		for(Person person : people) {
			System.out.println(person.age);
		}
		
		//A Map is a key value pair. you cannot iterate over a map
		Map<String, Person> dictionary = new HashMap<String, Person>();
		
		
		dictionary.put("Adam", adam);
		dictionary.put("Jackson", jackson);
		
		System.out.println(dictionary.get("Jackson"));
		//the closest you can get to iterating over a map is to get the key set which contains all the keys
		//then iterate over the keys to grab each object
		//dictionary.keySet();
		
		
	}

}
