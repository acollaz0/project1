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
		
		Person p = new Person();
		
		Person adam = new Person("Adam",19,100);
		Person jacob = new Person("Jacob",24,80);
		Person jaxon = new Person("Jaxon",22,130);
		Person art = new Person("Art",30,160);
		
		//A List maintains order and allows duplicates
		List<Person> people = new ArrayList<Person>();
		
		people.add(adam);
		people.add(jacob);
		people.add(jaxon);
		people.add(art);
		
		for(Person pp : people) {
			System.out.println(pp);
		}
		
		//The order of insertion is not preserved and I cannot store a duplicae object
		Set<Person> peopleset = new HashSet<Person>();
		
		peopleset.add(adam);
		peopleset.add(jacob);
		peopleset.add(jaxon);
		peopleset.add(art);
		peopleset.add(adam);

		for(Person pp : peopleset) {
			System.out.println(pp);
		}
		
		//Generics are bouncers who only allow certain objects into a collection
		Iterator<Person> iter = people.iterator();
		//enhanced for loop
		//you cannot delete objects in an enhanced for loop
		while(iter.hasNext()) {
			Person ip = iter.next();
		Map<String, Person> dictionary = new HashMap<String, Person>();
		dictionary.put("Adam", adam);
		dictionary.put("Jaxon", jaxon);
//		dictionary.put("Jacob", jacob);
//		dictionary.put("Adam", adam);
		System.out.println(dictionary.get("Jaxon"));
		
		//The closest you can get to iterating over a map is 
		//to get the keyset which contains all keys, iterate over all keys to get each object
		//dictionary.keySet() returns all the keys
		//A map is a key value pair. you cannot Iterate over a map;
		
		dictionary.keySet();
		
		
		}
	}

}
