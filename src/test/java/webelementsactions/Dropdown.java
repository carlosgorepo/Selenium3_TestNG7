package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement dropdown = driver.findElement(By.id("carselect"));
		Select select = new Select(dropdown);

		Thread.sleep(1000);
		System.out.println("Select Benz by Value");
		select.selectByValue("benz");  // Propiedad del atributo value = "" en el tag select

		Thread.sleep(1000);
		System.out.println("Select Honda by index");
		select.selectByIndex(2);  // Seleccionar utilizando el index del arreglo

		Thread.sleep(1000);
		System.out.println("Select BMW by Visible Text");
		select.selectByVisibleText("BMW");   // Seleccionar utilizando el valor que se muestra en el dropdown en la página

		Thread.sleep(1000);
		List<WebElement> options = select.getOptions();  // .getOptions() referencia de la lista de las opciones en el select
		System.out.println("Print the list of all options: ");
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
