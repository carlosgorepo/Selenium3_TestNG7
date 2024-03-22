package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ElementState {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement searchTxtBx = driver.findElement(By.name("q"));
		System.out.println("searchTxtBx is enabled? --> " + searchTxtBx.isEnabled());
		searchTxtBx.sendKeys("Youtube");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}