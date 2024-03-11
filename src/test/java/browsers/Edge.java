package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class Edge {
    public static void main(String[] args) {
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); //Tiempo para carga de la página del get
        driver.get("https://www.letskodeit.com/practice");
        driver.quit();
    }
}
