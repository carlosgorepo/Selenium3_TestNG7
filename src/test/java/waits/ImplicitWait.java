package waits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ImplicitWait {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseURL = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit : Espera a cada elemento que haga parte del dom. Sondeo -> Wait -> Sondeo
		                                                                   // Solo se declara una vez por Webdriver que se maneja (recomendado usarlo en un Before o Clase DriverInstance2)
																		   // Si encuentra el elemento antes del tiempo seteado el no espera el tiempo máximo y sigue con el programa (lo encuentra y hace la acción especificada)
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Is the Text Box Displayed? --> " + textBox.isDisplayed());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
