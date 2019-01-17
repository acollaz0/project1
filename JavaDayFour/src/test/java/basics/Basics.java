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
		System.out.println("Runs before every Test Method");
	}
	
	@After
	public void after() {
		System.out.println("Runs after every Test Method");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Runs before everything else");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Runs after everything");
	}
	
	@Test
	public void blank() {
		//fail("Not yet implemented"); any time
		// a test does not fail it is considered passed
	}
	
	@Test
	public void method() {
		// The first assertion passes
		// the second one fails
		// Every assert has to work
		Assert.assertTrue(true);
		Assert.assertTrue(false);
		
	}

	// unit testing - testing the smallest chunk of functionality
	// think of a testing a single method
	// TDD- Test Driven Development the developer writes the test
	// first and then create code to pass them

}
