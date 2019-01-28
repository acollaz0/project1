package basics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Basics {

	
	@Before
	public void before() {
		System.out.println("Runs before every test");
	}
	
	@After
	public void after() {
		System.out.println("Run after every test");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Runs before anything else");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Runs after everything");
	}
	
	@Test
	public void blank() {
		//fail("Not yet implemented");
		//Any time a test doesn't fail, it is considered passed
	}
	
	@Test
	public void method() {
		//the first assertion passes, but the second one fails
		//assert doesn't stop the test
		//Every assert has to work for a test to pass
		Assert.assertTrue(true);
		Assert.assertTrue(false);
	}
	
	
	
	//unit testing - testing the smallest chunk of functionality
	//i.e.: testing a single method
	//TDD - test driven development: the developer writes the tests first, and then creates code to pass them

}