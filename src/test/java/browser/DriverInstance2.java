package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import utilities.ConfigFileReader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverInstance2 {
    public WebDriver driver;

    public WebDriver initiateDriverInstance() throws Exception {
        switch (ConfigFileReader.getConfigValues("BROWSER").toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("–disable-notifications", "disable-infobars");
                chromeOptions.addExtensions(new File(System.getProperty("user.dir") + "\\config\\uBlock-Origin.crx"));

                //To stop Chrome from displaying the automated test message
                //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                //For Headless Execution
                //options.addArguments("--headless", "--disable-gpu");

                chromeOptions.addArguments("-–disable-popup-blocking");

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new Exception("[ERROR] - Incorrect Browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(ConfigFileReader.getConfigValues("URL"));
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void closeDriverInstance() {
        driver = getDriver();
        if (driver != null) driver.quit();
    }
}
