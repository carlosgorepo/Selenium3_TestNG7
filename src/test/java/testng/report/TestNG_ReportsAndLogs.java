package testng.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNG_ReportsAndLogs {
// Para que funcione el reporter de TestNG es necesario seguir los siguientes pasos en el IDE
	//1. En Edit Configurations del Run -> Seleccionar el archivo XML que vamos a usar
	//2. En la Pestaña de Listeners checkear el Use Default Reporters
	//3. Al correr el XML se creará una carpeta test-output
	//4. Dentro de la carpeta con el arhcivo index.html podremos ver el reporte visualmente en el navegador

	@BeforeClass
	public void setUp() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs once before class", true); //Este reporter es de TestNG
	}

	@AfterClass
	public void cleanUp() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs once after class", true); //logToStandardOut es
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs before every method", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> This runs after every method", true);
	}

	@Test
	public void testMethod1() {
		Reporter.log("TestNG_ReportsAndLogs -> testMethod1", true);
	}

	@Test
	public void testMethod2() {
		Reporter.log("TestNG_ReportsAndLogs -> testMethod2", true); // Falla para que veamos como se ve
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = {"testMethod2"})
	public void testMethod3() {
		Reporter.log("TestNG_ReportsAndLogs -> testMethod3", true);
	}
}
