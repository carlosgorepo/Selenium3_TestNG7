package testng.dataprovider.dataproviderdifferentclass;

import org.testng.annotations.Test;

public class TestNG_Test {
	@Test(dataProvider = "inputs", dataProviderClass = TestNG_DataProvider.class)
	public void test(String input1, int input2) {
		System.out.println("Input 1: " + input1);
		System.out.println("Input 2: " + input2);
	}
}