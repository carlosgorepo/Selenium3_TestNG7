package switchwindowandiframe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
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

		//Get the Handle   -> En que ventana estoy
		String parentHandle = driver.getWindowHandle();  // get.WindowHandle() Me devuelve la ventana en la que estoy.
		System.out.println("Parent Handle is --> " + parentHandle);

		//Find Open Window button
		WebElement openWindowBtn = driver.findElement(By.id("openwindow"));
		openWindowBtn.click();

		//Get all Handles and switch to the new one
		Set<String> handles = driver.getWindowHandles();  // get.WindowHandles() me trae todas las ventanas disponibles.
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);  // Cambiando a otra ventana
				Thread.sleep(2000);
				WebElement searchTxtBx = driver.findElement(By.xpath("//input[@id = 'search']"));
				searchTxtBx.sendKeys("Python");
				Thread.sleep(2000);
				driver.close(); // Cierra la ventana
				break;
			}
		}

		//Switch back to the Parent Window
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
		openWindowBtn.click();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}