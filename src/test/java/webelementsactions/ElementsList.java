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

public class ElementsList {
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
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type = 'radio']")); // Agruparlos - Colección
		boolean isChecked = false;
		for (int i = 0; i < radioButtons.size(); i++) {
			isChecked = radioButtons.get(i).isSelected();
			if (!isChecked) {
				radioButtons.get(i).click();
				Thread.sleep(2000);
			}
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}