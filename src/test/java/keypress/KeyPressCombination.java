package keypress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class KeyPressCombination {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseURL = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(2000);

		WebElement openWindowBtn = driver.findElement(By.id("openwindow"));

		//1 Way
		//openWindowBtn.sendKeys(Keys.CONTROL + "a");

		//2 Way
		//openWindowBtn.sendKeys(Keys.chord(Keys.CONTROL, "a"));

		//3 Way
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		openWindowBtn.sendKeys(selectAll);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
