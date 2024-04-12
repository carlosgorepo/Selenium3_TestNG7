package testng.testsuite.regressionsuite;

import org.testng.annotations.*;
import testng.testsuite.base.BaseTestSuite;

public class TestNG_TestClass1 extends BaseTestSuite {

	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test --> TestClass1 --> testMethod1\n");
	}

	@Test
	public void testMethod2() {
		System.out.println("\nRunning Test --> TestClass1 --> testMethod2\n");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BEFORE METHOD TestClass1 --> This runs BEFORE every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AFTER METHOD TestClass1 --> This runs AFTER every method");
	}

	@BeforeClass
	public void setUp() {
		System.out.println("BEFORE CLASS TestClass1 --> This runs ONCE BEFORE class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("AFTER CLASS TestClass1 --> This runs ONCE AFTER class");
	}
}
