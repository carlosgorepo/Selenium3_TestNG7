package testng.functionalities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.tests.SomeClassToTest;

public class TestNG_DependentTests {
	SomeClassToTest obj;

	@BeforeClass
	public void setUp() {
		obj = new SomeClassToTest();
		System.out.println("Before Class");
	}

	@Test(dependsOnMethods = "test2", alwaysRun = true) // dependonMethods -> Depende del test2 = Siempre se ejecuta después de test2. // alwaysrun = No importa si falla el test2 el test1 corre
	public void test1() {
		System.out.println("Test 1");
	}

	@Test
	public void test2() {
		System.out.println("Test 2");
		int result = obj.sumNumbers(1,4);
		Assert.assertEquals(result,3);
	}

	@Test(dependsOnMethods = "test1")
	public void test3() {
		System.out.println("Test 3");
	}

	@Test
	public void test4() {
		System.out.println("Test 4");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("After Class");
	}
}
