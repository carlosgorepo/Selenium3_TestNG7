package testng.softasserts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testng.tests.SomeClassToTest;

public class TestNG_SoftAsserts {
	SomeClassToTest someClassToTest = new SomeClassToTest();

	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test --> testSum");
		SoftAssert softAssert = new SoftAssert();   //We need to create this SoftAssert object

		int result = someClassToTest.sumNumbers(1, 2);

		softAssert.assertEquals(result, 2,"SoftAsser1"); //With SoftAssert we don't use Assert anymore but SoftAssert object
		softAssert.assertEquals(result, 4,"SoftAsser2"); //With SoftAssert we don't use Assert anymore but SoftAssert object
		System.out.println("\nLine after assert 1");
		softAssert.assertEquals(result, 1 + 2);
		System.out.println("\nLine after assert 2");

		softAssert.assertAll(); //With this we can check which Soft Assertions failed
	}
}
