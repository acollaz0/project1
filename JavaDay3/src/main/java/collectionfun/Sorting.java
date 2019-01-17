package collectionfun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.*;

public class Sorting {
public static void main(String[] args) {
		
		//default constructor will be provided for a class if you do not have any
		//constructors. The default constructor is no arguments
		
		Person p = new Person();
		
		Person adam = new Person("Adam",19,100);
		Person jacob = new Person("Jacob",24,80);
		Person jaxon = new Person("Jaxon",22,130);
		Person alex = new Person("Alex",30,160);
		
List<Person> people = new ArrayList<Person>();
		
		people.add(adam);
		people.add(jacob);
		people.add(jaxon);
		people.add(alex);
		
		Set<Person> peopleset = new TreeSet<Person>();
		peopleset.addAll(people);
		//Jaxon was removed because it was considered the same when it came to ordering and this is a set
		
		//System.out.println(peopleset);
		
		Collections.sort(people);
		
		Collections.sort(people, Person.HeightComparator);
		System.out.println(people);

}

}
