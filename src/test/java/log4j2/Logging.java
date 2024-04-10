package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Logging {
	private WebDriver driver;
	private String baseUrl;

	//1. Define the instance of the Logger, put the class name that yoy want to log
	private static final Logger log = LogManager.getLogger(Logging.class.getName());

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.letskodeit.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		log.info("This message is from test method");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
