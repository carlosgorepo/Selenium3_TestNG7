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

public class KeyPressDemo {
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
		WebElement signInLink = driver.findElement(By.linkText("SIGN IN"));
		signInLink.click();

		WebElement emailAddressTxtBx = driver.findElement(By.xpath("//input[@placeholder = 'Email Address']"));
		emailAddressTxtBx.sendKeys("j66cam@gmail.com");
		WebElement passwordTxtBx = driver.findElement(By.id("login-password"));
		passwordTxtBx.sendKeys("abc123");
		Thread.sleep(2000);

		WebElement loginBtn = driver.findElement(By.id("login"));
		loginBtn.sendKeys(Keys.ENTER); // Esto es un Boton, no tiene que ser un input para hacer sendKeys
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
