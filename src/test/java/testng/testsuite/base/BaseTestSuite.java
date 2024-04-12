package testng.testsuite.base;

import org.testng.annotations.*;

public class BaseTestSuite {

	/* As the class is extended in the classes TestNG_TestClass1 and TestNG_TestClass2,
	then when executing the file testng_ExecuteOneOrOrMoreClasses,
	all the annotations defined here will be executed as if they were part of those classes.*/

	@BeforeClass
	public void beforeClassBase() {
		System.out.println("BASE BEFORE CLASS --> This runs ONCE BEFORE class");
	}

	@AfterClass
	public void afterClassBase() {
		System.out.println("BASE AFTER CLASS --> This runs ONCE AFTER class");
	}

//------------------------------------------------------------------------------------------------------------------

//These are annotations that are used before and after the execution of the tests (Tags test) defined in the testng.xml file

	@BeforeTest
	public void beforeTest() {
		System.out.println("BASE BEFORE TEST --> This runs ONCE BEFORE test in .xml file");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BASE AFTER TEST --> This runs ONCE AFTER test in .xml file");
	}

//------------------------------------------------------------------------------------------------------------------

	@BeforeSuite
	public void beforeMethodBase() {
		System.out.println("BASE BEFORE SUITE --> This runs ONCE BEFORE every class");
	}

	@AfterSuite
	public void afterMethodBase() {
		System.out.println("BASE AFTER SUITE --> This runs ONCE AFTER every class");
	}
}
