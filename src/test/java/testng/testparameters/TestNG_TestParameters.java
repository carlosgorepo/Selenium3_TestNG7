package testng.testparameters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_TestParameters {

	@BeforeClass
	@Parameters({"browser", "platform"})
	public void setUp(String browser, String platform) {
		System.out.println("TestNG_TestParameters --> SetUp");
		System.out.println("1. Parameter value from xml file: " + browser);
		System.out.println("2. Parameter value from xml file: " + platform);
	}

	@Test
	@Parameters({"response"}) // Importante nombrar los parametros y crear las variables para cada uno de ellos
	public void test1(int response) { // Tipo de dato se puede cambiar así en el xml t0do parezca en string
		boolean test = true;
		System.out.println("TestNG_TestParameters --> Test 1");
		System.out.println("Response from xml file: " + response);
	}
}
