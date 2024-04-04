package javascrpitexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class JavaScriptExecution_BasicFLow {
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
		//Navigation
//     driver.get(baseURL);
		js.executeScript("window.location = 'https://www.letskodeit.com/practice';");  // Navegar hacia la URL especificada, es un driver.get utilizando JavaScript

		Thread.sleep(3000);

		//Finding Elements
//     WebElement textBox = driver.findElement(By.id("autosuggest"));
		WebElement textBox = (WebElement) js.executeScript("return document.getElementById('autosuggest');");
		textBox.sendKeys("test");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
