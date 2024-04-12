package testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProviders {
	@DataProvider(name = "inputs")
	public Object[][] getData() {
		return new Object[][]{
				{"bmw", 3},
				{"audi", 14},
				{"benz", 5}
		};
	}

	@Test(dataProvider = "inputs")  //Test con data provider itera dependiendo del número de listas (filas/arreglos)
	public void test(String input1, int input2) { // Valores para cada valor de la columna que va a tomar en cada iteración, importante mantener el tipo de dato
		System.out.println("Input 1: " + input1);
		System.out.println("Input 2: " + input2);
	}
}