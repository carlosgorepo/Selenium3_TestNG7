package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Class {
    public static void main(String[] args) {
        String baseUrl = "https://www.letskodeit.com/practice";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        driver.get(baseUrl);

        driver.findElement(By.className("ui-autocomplete-input")).sendKeys("Carlos"); // If class name is separated by a space between words, each word represents a different class
    }
}