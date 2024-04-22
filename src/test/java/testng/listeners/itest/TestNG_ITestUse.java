package testng.listeners.itest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_ITestUse {

	@BeforeClass
	public void setUp() {
		System.out.println("Code in Before Class");
	}

	@Test
	public void test1() {
		System.out.println("Code in Test 1");
		Assert.assertTrue(true);
	}

	@Test
	public void test2() {
		System.out.println("Code in Test 2");
		Assert.assertTrue(false);
	}

	@AfterClass
	public void cleanUp() {

		System.out.println("Code in After Class");
	}
}
