package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class RadioButtonsAndCheckboxes {
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
		WebElement bmwRB = driver.findElement(By.id("bmwradio"));
		System.out.println("BMW Radio Button is selected? --> " + bmwRB.isSelected());
		bmwRB.click();
		System.out.println("BMW Radio Button is selected? --> " + bmwRB.isSelected());
		Thread.sleep(1000);

		WebElement benzRB = driver.findElement(By.id("benzradio"));
		System.out.println("Benz Radio Button is selected? --> " + benzRB.isSelected());
		benzRB.click();
		System.out.println("Benz Radio Button is selected? --> " + benzRB.isSelected());
		Thread.sleep(1000);

		WebElement hondaRB = driver.findElement(By.id("hondaradio"));
		System.out.println("Honda Radio Button is selected? --> " + hondaRB.isSelected());
		hondaRB.click();
		System.out.println("Honda Radio Button is selected? --> " + hondaRB.isSelected());
		Thread.sleep(1000);

		WebElement bmwChBx = driver.findElement(By.id("bmwcheck"));
		System.out.println("BMW CheckBox is selected? --> " + bmwChBx.isSelected());
		bmwChBx.click();
		System.out.println("BMW CheckBox is selected? --> " + bmwChBx.isSelected());
		Thread.sleep(1000);

		WebElement benzChBx = driver.findElement(By.id("benzcheck"));
		System.out.println("Benz CheckBox is selected? --> " + benzChBx.isSelected());
		benzChBx.click();
		System.out.println("Benz CheckBox is selected? --> " + benzChBx.isSelected());
		Thread.sleep(1000);

		WebElement hondaChBx = driver.findElement(By.id("hondacheck"));
		System.out.println("Honda CheckBox is selected? --> " + hondaChBx.isSelected());
		hondaChBx.click();
		System.out.println("Honda CheckBox is selected? --> " + hondaChBx.isSelected());
		Thread.sleep(1000);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
