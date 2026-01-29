package tutorialNinja.Register;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.CommonUtils;

public class TC_RF__009 extends Base {
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();
		prop = CommonUtils.loadProperties();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringAccountProvidingtheExistingEmail() {

		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys("rehankhan56390@gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("PhoneNum"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("Password"));

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualWarningMsg = "Warning: E-Mail Address is already registered!";
		String WarningMsg = driver.findElement(By.xpath(
				"//div[@class='alert alert-danger alert-dismissible'][text()='Warning: E-Mail Address is already registered!']"))
				.getText();
		Assert.assertTrue(actualWarningMsg.contains(WarningMsg));
		driver.quit();

	}

}
