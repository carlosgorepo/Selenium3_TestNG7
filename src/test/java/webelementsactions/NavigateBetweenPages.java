package webelementsactions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NavigateBetweenPages {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.letskodeit.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		System.out.println("Page Title --> " + driver.getTitle());
		System.out.println("Current URL --> " + driver.getCurrentUrl() + "\n");
		Thread.sleep(2000);

		String urlToNavigate = "https://www.letskodeit.com/login";
		driver.navigate().to(urlToNavigate);
		System.out.println("Navigating Other Url ---------->");
		System.out.println("Page Title --> " + driver.getTitle());
		System.out.println("Current URL --> " + driver.getCurrentUrl() + "\n");
		Thread.sleep(2000);

		driver.navigate().back();
		System.out.println("Navigate Back ---------->");
		System.out.println("Page Title --> " + driver.getTitle());
		System.out.println("Current URL --> " + driver.getCurrentUrl() + "\n");
		Thread.sleep(2000);

		driver.navigate().forward();
		System.out.println("Navigate Forward ---------->");
		System.out.println("Page Title --> " + driver.getTitle());
		System.out.println("Current URL --> " + driver.getCurrentUrl() + "\n");
		Thread.sleep(2000);

		driver.navigate().refresh();
		System.out.println("Refreshing ---------->");
		System.out.println("Page Title --> " + driver.getTitle());
		System.out.println("Current URL --> " + driver.getCurrentUrl() + "\n");
		Thread.sleep(2000);

		System.out.println("Page Source ----------> \n\n" + driver.getPageSource());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
