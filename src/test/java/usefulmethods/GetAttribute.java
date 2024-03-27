package usefulmethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class GetAttribute {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseURL = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test1() {
		driver.get(baseURL);
		WebElement enterYourNameTxtBx = driver.findElement(By.id("name"));
		System.out.println("Value of attribute class is --> " + enterYourNameTxtBx.getAttribute("class")); // Valor del atributo que se especifica entre comillas dobles ej:"class"
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
