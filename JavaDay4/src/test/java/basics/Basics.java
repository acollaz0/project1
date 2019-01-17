package basics;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class Basics {

	
	@Before
	public void before() {
		
		System.out.println("Runs before");
	}
	@After
	public void after() {
		System.out.println("Runs after");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Runs before everything");
		
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("Runs after everything");
		//close connections and resources
	}
	
	
	@Test
	public void blank() {
		//fail("Not yet implemented"); any time
		//a test does not fail it is considered passed
	}
	
	@Test
	public void method() {
		//the first one passes
		//the second one fails
		//Every assert has to work
		Assert.assertTrue(true);
		Assert.assertTrue(false);

		
	}
	//unit testing - testing the smallest chunk of functionality
	//think of a testing a single method
	//TDD- Test Driven Development the developer writes the test first
	//and then creates code to pass them
	
	
	
	
}
