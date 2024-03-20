package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class ElementInsideElement {
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
	public void test() {
		driver.get(baseUrl);
		WebElement multiSelectExample = driver.findElement(By.id("multiple-select-example"));
		List<WebElement> allMultiselectOptions = multiSelectExample.findElements(By.tagName("option"));
		System.out.println("All Multiselect options are:");
		for (WebElement allMultiselectOption : allMultiselectOptions) {
			System.out.println(allMultiselectOption.getText());
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
