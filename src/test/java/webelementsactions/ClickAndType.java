package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClickAndType {

	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		baseURL = "https://www.letskodeit.com/";
	}

	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.linkText("SIGN IN")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("carlos@test.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("contraseña");
	}

	@After
	public void teardown(){
		driver.quit();
	}
}