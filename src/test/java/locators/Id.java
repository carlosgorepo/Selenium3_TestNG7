package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Id {
    public static void main(String[] args) {
        String baseUrl = "https://sso.teachable.com/secure/42299/identity/login/password";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        driver.get(baseUrl);

        // WebElement emailTxtBx = driver.findElement(By.id("email"));  // Almacenado en una variable
        // emailTxtBx.sendKeys("test@aaaa.com");

        driver.findElement(By.id("email")).sendKeys("test@aaaa.com"); // Sin almacenar dentro de una variable

    }
}