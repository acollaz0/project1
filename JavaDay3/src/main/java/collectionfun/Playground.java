package collectionfun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.*;

public class Playground {
	
	public static void main(String[] args) {
		
		//default constructor will be provided for a class if you do not have any
		//constructors. The default constructor is no arguments
		
		Person p = new Person();
		
		Person adam = new Person("Adam",19,100);
		Person jacob = new Person("Jacob",24,80);
		Person jaxon = new Person("Jaxon",22,130);
		Person alex = new Person("Alex",30,160);
		
		//the list maintains the order of insertion and allows duplicates
		List<Person> people = new ArrayList<Person>();
		
		people.add(adam);
		people.add(jacob);
		people.add(jaxon);
		people.add(alex);
		
		//System.out.println(people);
		//the order of insertion is not preserved and I cannot store a duplicate object
		Set<Person> peopleset = new HashSet<Person>();
		
		peopleset.add(adam);
		peopleset.add(jacob);
		peopleset.add(jaxon);
		peopleset.add(alex);
		peopleset.add(adam);
		//System.out.println(peopleset);
		//generics are like the bouncer who only allows certain objects into a collection
		Iterator<Person> iter = people.iterator();
		//iterating over the list printing out names
		while(iter.hasNext()) {
			Person person = iter.next();
			System.out.println(person.name);
		}
		//enhanced for loops are the best I love them
		//you cannot remove objects in an enhanced for loop
		for(Person person : people) {
			System.out.println(person.age);	
			
		}
		//a map is key value pair. you cannot iterate a map
		Map<String,Person> dictionary = new HashMap<String,Person>();
		
		dictionary.put("Adam", adam);
		dictionary.put("Jaxon", jaxon);
		
		System.out.println(dictionary.get("Jaxon"));
		//The closest you can get to iterating over a map is to get the key set which will contain
		//all of the keys and then iterate over the keys to grab each object
		//dictionary.keyset() this returns all the keys
		
	}

}
