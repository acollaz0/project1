package basics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class Basics {
	@Before
	public void before() {
		System.out.println("Runs before every method");
	}
	@After
	public void after() {
		
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Runs before everything");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("Runs before everything");
	}
	@Test
	public void test() {
//		fail("Not yet implemented"); any time a test does not fail it is considered passed.
	}
	@Test
	public void method() {
		//The first assertion passes 
		//the second one fails
		//Every assert has to work
		Assert.assertTrue(true);
	}
	
	//unit testing - testing the smallest chunk
	//think of testing a single method
	//TDD
	//All the Devs write tests first
	// then they write code to pass them
	
}
