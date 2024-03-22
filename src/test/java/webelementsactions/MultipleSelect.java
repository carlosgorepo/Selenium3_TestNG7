package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class MultipleSelect {
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
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement multiSelect = driver.findElement(By.id("multiple-select-example"));
		Select select = new Select(multiSelect);

		Thread.sleep(1000);
		System.out.println("Select orange by Value");
		select.selectByValue("orange");

		Thread.sleep(1000);
		System.out.println("Deselect orange by value");
		select.deselectByValue("orange");

		Thread.sleep(1000);
		System.out.println("Select peach by index");
		select.selectByIndex(2);

		Thread.sleep(1000);
		System.out.println("Select Apple by Visible text");
		select.selectByVisibleText("Apple");

		Thread.sleep(1000);
		System.out.println("Print all selected options");
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}

		Thread.sleep(1000);
		System.out.println("Deselect all selected options");
		select.deselectAll();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}