package newselenium4features;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OpenNewWindow {
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
	public void test1() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.WINDOW); // Crear nueva ventana Selenium 4
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}