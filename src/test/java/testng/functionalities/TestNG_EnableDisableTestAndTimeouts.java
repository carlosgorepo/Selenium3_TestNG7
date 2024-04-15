package testng.functionalities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.tests.SomeClassToTest;

public class TestNG_EnableDisableTestAndTimeouts {

	@BeforeClass
	public void setUp() {
		System.out.println("Before Class");
	}

	@Test(enabled = false)
	public void test1() {
		System.out.println("Test 1");
	}

	@Test(timeOut = 1000)   //milliseconds    // Tiempo que se puede demorar máximo la prueba (performance)
	public void test2() throws InterruptedException {
		System.out.println("Test 2");
		Thread.sleep(2000); // Va a fallar la prueba por hacer esperar más del tiempo establecido en el timeout
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("After Class");
	}
}
