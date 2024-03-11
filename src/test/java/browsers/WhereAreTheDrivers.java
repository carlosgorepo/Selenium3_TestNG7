package browsers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.manager.SeleniumManager;

public class WhereAreTheDrivers {
    public static void main(String[] args) {
        //Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("goog:chromeOptions", true);
        String chromeBrowserPath = SeleniumManager.getInstance().getDriverPath(chromeOptions, false).getBrowserPath();
        String chromeDriverPath = SeleniumManager.getInstance().getDriverPath(chromeOptions, false).getDriverPath();
        System.out.println("chromeBrowserPath--" + chromeBrowserPath); // Path del ejecutable del navegador en local
        System.out.println("chromeDriverPath--" + chromeDriverPath); // Path del ejecutable del chrome driver (Selenium)

        //Edge
        EdgeOptions edgeOptions = new EdgeOptions();
        String edgeBrowserPath = SeleniumManager.getInstance().getDriverPath(edgeOptions, false).getBrowserPath();
        String edgeDriverPath = SeleniumManager.getInstance().getDriverPath(edgeOptions, false).getDriverPath();
        System.out.println("edgeBrowserPath--" + edgeBrowserPath);// Path del ejecutable del navegador en local
        System.out.println("EdgeDriverPath--" + edgeDriverPath);// Path del ejecutable del edge driver (Selenium)

        //Firefox
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        String fireFoxBrowserPath = SeleniumManager.getInstance().getDriverPath(firefoxOptions, false).getBrowserPath();
        String fireFoxDriverPath = SeleniumManager.getInstance().getDriverPath(firefoxOptions, false).getDriverPath();
        System.out.println("fireFoxBrowserPath--" + fireFoxBrowserPath);// Path del ejecutable del navegador en local
        System.out.println("fireFoxDriverPath--" + fireFoxDriverPath);// Path del ejecutable del firefox driver (Selenium)
    }
}
