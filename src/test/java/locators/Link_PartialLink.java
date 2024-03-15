package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Link_PartialLink {
    public static void main(String[] args) {
        String baseUrl = "https://www.letskodeit.com/practice";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        driver.get(baseUrl);

        driver.findElement(By.linkText("Open Tab")).click(); // String same as it appears on the page not the DOM, has to redirect
        driver.findElement(By.partialLinkText("SUPP")).click(); // String same as it appears on the page not the DOM, has to redirect
    }
}
