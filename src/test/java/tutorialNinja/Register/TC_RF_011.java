package tutorialNinja.Register;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.CommonUtils;

public class TC_RF_011 extends Base {

	WebDriver driver;
	 Properties prop;
	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();
		prop=CommonUtils.loadProperties();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringAccountInvalidMobileNumber() {

		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("LastName")); 
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getTimestampEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("12");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("Password"));

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualWarningMsg = "Telephone must be between 3 and 32 characters!";
		String WarningMsg = driver
				.findElement(By
						.xpath("//div[@class='text-danger'][text()='Telephone must be between 3 and 32 characters!']"))
				.getText();
		Assert.assertTrue(actualWarningMsg.contains(WarningMsg));

	}

}
