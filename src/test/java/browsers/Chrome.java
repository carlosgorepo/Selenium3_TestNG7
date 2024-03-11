package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Chrome {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-–disable-popup-blocking"); // Deshabilitar pop ups/alertas, todas se pueden enviar en el mismo addArgunments
        options.addArguments("–disable-notifications"); //
        options.addArguments("disable-infobars"); //
        options.addArguments("--lang=en-US");
        options.addExtensions(new File(System.getProperty("user.dir") + "\\config\\uBlock-Origin.crx"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); //Tiempo para carga de la página del get
        driver.get("https://www.letskodeit.com/practice");
        driver.quit();
    }
}