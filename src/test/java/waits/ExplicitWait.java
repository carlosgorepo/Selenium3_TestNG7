package waits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseURL = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		WebElement signInLink = driver.findElement(By.linkText("SIGN IN"));
		signInLink.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailTxtBx = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder = 'Email Address']")));
		// Explicit : Igual que el implicito solo que utiliza condiciones para la espera
		// No tenemos forma de saber cuanto itera para buscar el elemento mientras se encuentra en la espera
		// Es necesario declarar el wait para utilizarlo en cada elemento que se desee manipular
		emailTxtBx.sendKeys("test");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
