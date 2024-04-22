package testng.listeners.itestresult;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestNG_ScreenshotOnFailure {
	WebDriver driver;
	String baseURL;

	@BeforeMethod
	public void setUp() {
		baseURL = "https://www.facebook.com";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testLogin() {
		driver.get(baseURL);
		driver.findElement(By.id("email")).sendKeys("test");
		driver.findElement(By.id("pass")).sendKeys("test");
        driver.findElement(By.xpath("//button[@data-testid]")).click();
		//driver.findElement(By.id("login")).click();
	}

	@AfterMethod
	public void cleanUp(ITestResult testResult) throws IOException { // ITestResult puedo usarlo si no estoy en el Listener, simplemente lo importo y lo llamo
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed: " + testResult.getMethod().getMethodName());
			String filename = getRandomString(10) + ".png";
			String directory = System.getProperty("user.dir") + "//screenshots//";
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(directory + filename));
		}
		driver.quit();
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}