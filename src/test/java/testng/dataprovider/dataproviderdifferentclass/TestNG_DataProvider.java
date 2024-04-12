package testng.dataprovider.dataproviderdifferentclass;

import org.testng.annotations.DataProvider;

public class TestNG_DataProvider {
	@DataProvider(name = "inputs")
	public Object[][] getData() {
		return new Object[][]{
				{"bmw", 3},
				{"audi", 14},
				{"benz", 5}
		};
	}
}
