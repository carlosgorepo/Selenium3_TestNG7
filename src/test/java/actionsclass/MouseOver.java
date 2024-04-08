package actionsclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseOver {
	WebDriver driver;
	String baseURL;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		baseURL = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		js.executeScript("window.scrollBy(0, 600)");
		Thread.sleep(2000);

		WebElement mouseOverBtn = driver.findElement(By.id("mousehover"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseOverBtn).perform();  // Movernos hasta el elemento que le pasemos
		Thread.sleep(2000);

		WebElement topOption = driver.findElement(By.xpath("//div[@class = 'mouse-hover-content']/a[text() = 'Top']"));
        //topOption.click();
		actions.moveToElement(topOption).click().build().perform();
		Thread.sleep(2000);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
