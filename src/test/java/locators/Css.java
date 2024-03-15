package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Css {
    public static void main(String[] args) {
        String baseURL = "https://www.letskodeit.com/support";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(baseURL);

        //By ID
        driver.findElement(By.cssSelector("#alertbtn")).click(); // # + id name

        //By Class
        driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("Juan"); // . + class name, for space between class name, use .word.word

        //MULTIPLE CLASSES
        driver.findElement(By.cssSelector(".ui-autocomplete-input.inputs")).sendKeys("Juan"); // for space between class name, use .word.word

        //TAG AND ATTRIBUTE
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys("Juan"); // very similar to xpath, without // and @

        //TAG AND CLASS
        driver.findElement(By.cssSelector("input.ui-autocomplete-input")).sendKeys("Juan");

        //START WITH...(^)
        driver.findElement(By.cssSelector("input[id^='nam']")).sendKeys("Juan"); // ^

        //ENDS WITH...($)
        driver.findElement(By.cssSelector("input[id$='me']")).sendKeys("Juan");// $

        //CONTAINS...(*)
        driver.findElement(By.cssSelector("input[id*='am']")).sendKeys("Juan");// *

        //ACCESS THE CHILD OF A TAG...(>)
        driver.findElement(By.cssSelector("fieldset>table")).sendKeys("Juan");// >

        //ACCESS THE CHILD OF A TAG WITH TAG ID...(>#)
        driver.findElement(By.cssSelector("fieldset>#product")).sendKeys("Juan");
    }
}