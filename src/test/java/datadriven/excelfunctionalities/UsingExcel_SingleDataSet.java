package datadriven.excelfunctionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class UsingExcel_SingleDataSet {
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Constants.URL);
	}

	@Test
	public void testUsingExcel() throws Exception {
		Thread.sleep(2000);
		WebElement signInLink = driver.findElement(By.linkText("SIGN IN"));
		signInLink.click();

		// Tell the code about the location of Excel file
		ExcelUtility_SingleDataSet.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1");
		String username = ExcelUtility_SingleDataSet.getCellData(1, 0);
		String password = ExcelUtility_SingleDataSet.getCellData(1, 1);

		WebElement emailAddressTxtBx = driver.findElement(By.xpath("//input[@placeholder = 'Email Address']"));
		emailAddressTxtBx.sendKeys(username);
		WebElement passwordTxtBx = driver.findElement(By.id("login-password"));
		passwordTxtBx.sendKeys(password);
		Thread.sleep(2000);
		WebElement loginBtn = driver.findElement(By.id("login"));
		loginBtn.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		// Find if error messages exist
		boolean result = !driver.findElements(By.id("incorrectdetails")).isEmpty();
		Assert.assertTrue(result);

		// Set the test result in the Excel file
		ExcelUtility_SingleDataSet.setCellData("Pass", 2, 2);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
