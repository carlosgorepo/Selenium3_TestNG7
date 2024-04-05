package switchwindowandiframe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SwitchAlert {
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

		WebElement enterYourNameTxtBx = driver.findElement(By.xpath("//input[@placeholder = 'Enter Your Name']"));
		enterYourNameTxtBx.sendKeys("Juan");

		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		alertBtn.click();
		Thread.sleep(2000);
		//Alert alert = driver.switchTo().alert(); //Se puede almacenar la alerta de la siguiente forma
		//alert.accept();
		driver.switchTo().alert().accept();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
