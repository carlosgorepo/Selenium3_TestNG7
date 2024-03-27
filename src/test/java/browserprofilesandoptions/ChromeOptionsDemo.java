package browserprofilesandoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeOptionsDemo {
	public static void main(String[] args) {
		String baseURL = "https://www.letskodeit.com/practice";
		ChromeOptions options = new ChromeOptions();  // Setea Chrome options antes de crear el driver
		options.addExtensions(new File(System.getProperty("user.dir") + "\\src\\test\\java\\browserprofilesandoptions\\extensions\\AdBlockExtension.crx")); // Vamos a darle una extensión de Adblock al ChromeOptions
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
}