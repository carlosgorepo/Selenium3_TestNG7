package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class NewSyntax {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();  //Open new browser, most up to date

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // Deprecated
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver,3); // Deprecated
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        //Desired Capabilities - Options
        ChromeOptions options = new ChromeOptions();

    }
}