package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ElementDisplayed {
	WebDriver driver;
	String baseUrl1;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl1 = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get(baseUrl1);
		WebElement textBox = driver.findElement(By.id("displayed-text"));  // Textbox = Input
		System.out.println("Is the Text Box Displayed? --> " + textBox.isDisplayed());
		Thread.sleep(2000);

		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked on Hide button");
		System.out.println("Is the Text Box Displayed? --> " + textBox.isDisplayed());
		Thread.sleep(2000);

		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked on Show button");
		System.out.println("Is the Text Box Displayed? --> " + textBox.isDisplayed());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}