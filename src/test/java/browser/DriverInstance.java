package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigFileReader;

import java.io.File;
import java.time.Duration;

public class DriverInstance {
    public WebDriver driver;

    @BeforeMethod
    public void initiateDriverInstance() throws Exception {
        switch (ConfigFileReader.getConfigValues("BROWSER").toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("–disable-notifications", "disable-infobars");
                chromeOptions.addExtensions(new File(System.getProperty("user.dir") + "\\config\\uBlock-Origin.crx"));
                driver = new ChromeDriver(chromeOptions); // Se abre el navegador al pasarle el driver
                //driver = new ChromeDriver(); // Opcional es el parámetro de chromeOptions
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("Incorrect Browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); // aumentar la espera del driver.get
        driver.get(ConfigFileReader.getConfigValues("URL")); // 60 seg de espera tiene el driver.get para que cargue la página por defecto
    }

    @AfterMethod
    public void closeDriverInstance() {
        driver.quit();
    } // cerrar todas las ventanas
    //public void closeDriverInstance() {driver.close();} // cerrar ventana actual
}