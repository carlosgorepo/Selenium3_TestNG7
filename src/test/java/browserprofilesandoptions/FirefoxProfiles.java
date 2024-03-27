package browserprofilesandoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxProfiles {
	public static void main(String[] args) {
		String baseURL = "https://www.letskodeit.com/practice";

    /*First we must open FireFox, type about:profiles as URL and create a new Profile,
    that name we put is the one we put in getProfile*/
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile firefoxProfile = profile.getProfile("Automation");

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(firefoxProfile);

		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
}