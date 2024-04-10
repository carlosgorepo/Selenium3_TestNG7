package testng.classannotations;

import org.testng.annotations.*;

public class TestNG_ClassAnnotations {
	@BeforeClass
	public void setUp() {
		System.out.println("\nThis runs ONCE BEFORE class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("\nThis runs ONCE AFTER class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nThis runs BEFORE every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nThis runs AFTER every method");
	}

	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test --> testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("\nRunning Test --> testMethod2");
	}
}
