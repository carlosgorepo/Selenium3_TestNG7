package switchwindowandiframe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SwitchIFrame {
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

		//Switching Iframe by ID
        driver.switchTo().frame("courses-iframe");

		//Switching Iframe by name
		//driver.switchTo().frame("iframe-name");

		//Switching Iframe by Index
		//driver.switchTo().frame(0);

		//Switch using Web Element
		//WebElement searchCourseTxtBx = driver.findElement(By.xpath("//input[@id = 'search']"));
		//driver.switchTo().frame(searchCourseTxtBx);

		//Tip : Generalmente las págs están compuestas por 2 IFrames, Muy probable que Menú de una pág hace parte del IFrame madre, id o name para IFrame
		//Para switchearme al IFrame principal usar el Index 0

		WebElement searchCourseTxtBx = driver.findElement(By.xpath("//input[@id = 'search']"));
		searchCourseTxtBx.sendKeys("Python");

		driver.switchTo().defaultContent();
		WebElement openWindowBtn = driver.findElement(By.id("openwindow"));
		openWindowBtn.click();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		//driver.quit();
	}
}
