package tutorialNinja.Register;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class TC_RF_010 extends Base {

	WebDriver driver;
	Properties prop;
	HomePage homepage;
	RegisterPage registerpage;

	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();
		prop = CommonUtils.loadProperties();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		homepage.selectRegisterOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringAccountWithInvalidEmail() throws IOException, InterruptedException {

		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys("rehankhan");
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("PhoneNum"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("Password"));

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//Thread.sleep(3000);
		File screenShot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot1,
				new File("C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\sc1Actual.png"));
		Assert.assertFalse(CommonUtils.CompareTwoScreenshots(
				"C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\sc1Actual.png",
				"C:\\FullAutomationLiveProject\\FullAutomationProject\\\\Screenshots\\Sc1Expected.png"));
		//Thread.sleep(3000);

//		driver.findElement(By.id("input-email")).clear();
//		driver.findElement(By.id("input-email")).sendKeys("rehankhan@");
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		Thread.sleep(3000);
//		File screenShot2 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
//				.getScreenshotAs(OutputType.FILE);
//
//		FileHandler.copy(screenShot2,
//				new File("C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\sc2Actual.png"));
//		Thread.sleep(3000);
//		Assert.assertFalse(CommonUtils.CompareTwoScreenshots(
//				"C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\sc2Actual.png",
//				"C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\Sc2Expected.png"));
		// Thread.sleep(3000);

//		driver.findElement(By.id("input-email")).clear();
//		driver.findElement(By.id("input-email")).sendKeys("rehankhangmail");
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		File screenShot3 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
//				.getScreenshotAs(OutputType.FILE);
//		//Thread.sleep(3000);
//		FileHandler.copy(screenShot3,
//				new File("C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\sc3Actual.png"));
//
//		Assert.assertFalse(CommonUtils.CompareTwoScreenshots(
//				"C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\sc3Actual.png",
//				"C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\Sc3Expected.png"));
//
	}

}