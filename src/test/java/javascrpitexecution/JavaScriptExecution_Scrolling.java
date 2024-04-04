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

public class JavaScriptExecution_Scrolling {
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
		js.executeScript("window.location = '" + baseURL + "';");
		Thread.sleep(3000);

		//Scroll Down
		js.executeScript("window.scrollBy(0, 1900);");
		Thread.sleep(2000);

		//Scroll Up
		js.executeScript("window.scrollBy(0, -1900);");  // Para scroll horizontal utilizar el primer campo de los parametros que se pasa (Horizontal, Vertical)
		Thread.sleep(2000);

		//Scroll Element into view
		WebElement mouseHoverBtn = driver.findElement(By.id("mousehover")); // Scroll hasta ver el elemento
		js.executeScript("arguments[0].scrollIntoView(true);", mouseHoverBtn);
		Thread.sleep(2000);

		//Scroll Up
		js.executeScript("window.scrollBy(0, -190);");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
