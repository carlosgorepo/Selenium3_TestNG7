package usefulmethods;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Screenshot {
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		baseURL = "https://www.google.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test() {
		driver.get(baseURL);
		WebElement searchTxtBx = driver.findElement(By.name("q"));
		searchTxtBx.sendKeys("skap");
	}

	@After
	public void tearDown() throws IOException {
		String fileName = getRandomString(10) + ".png";                           // Nombre del archivo (caracteres aleatorios)
		String directory = System.getProperty("user.dir") + "//screenshots//";          // Ruta para almacenar imagenes
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  // Toma el pantallazo
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
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
