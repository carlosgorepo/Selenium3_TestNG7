package javascrpitexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class JavaScriptExecution_Click {
	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseURL = "https://www.letskodeit.com/practice";
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() throws InterruptedException {
		js.executeScript("window.location = '" + baseURL + "';");   // Navegar hacia la URL especificada, es un driver.get utilizando JavaScript
		Thread.sleep(3000);

		// Clicking
		WebElement bmwChBx = driver.findElement(By.id("bmwcheck"));
		//     bmwChBx.click();
		js.executeScript("arguments[0].click()", bmwChBx);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}