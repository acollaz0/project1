package collectionfun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sorting {

	public static void main(String[] args) {
		
		Person adam = new Person("Adam", 19, 100);
		Person jacob = new Person("Jacob", 24, 80);
		Person jackson = new Person("Jackson", 24, 130);
		Person alex = new Person("Alex", 30, 160);
		
		//List maintains the order of insertion and allows duplicates
		List<Person> people = new ArrayList<Person>();
		
		people.add(adam);
		people.add(jacob);
		people.add(jackson);
		people.add(alex);
		people.add(adam);
		
		Set<Person> peopleset = new TreeSet<Person>();
		
		peopleset.addAll(people);
		//Jackson was removed because it was considered the same when it came
		//to ordering and this is set
		//System.out.println(peopleset);
		
		//utility methods. This one will order my list using compareTo
		//my list is now ordered
		Collections.sort(people);
		
		//logic is the same as compareTo but this takes in two objects. it 
		//does not use itself in the comparison
		System.out.println(people);
		Collections.sort(people, Person.HeightComparator);
		//System.out.println(Person.HeightComparator.compare(jackson, adam));
		System.out.println(people);

	}

}
