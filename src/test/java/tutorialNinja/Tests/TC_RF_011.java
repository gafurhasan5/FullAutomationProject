package tutorialNinja.Tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class TC_RF_011 extends Base {

	WebDriver driver;
	 Properties prop;
	 HomePage homepage;
		RegisterPage registerpage;
		AccountSuccessPage accountsuccesspage;
		AccountPage accountpage;
	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();
		prop=CommonUtils.loadProperties();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		homepage.selectRegisterOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringAccountInvalidMobileNumber() {

		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterSecondName(prop.getProperty("LastName"));
		registerpage.enterEmail(CommonUtils.getTimestampEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("12");
		registerpage.enterPassword(prop.getProperty("Password"));
		registerpage.enterConPassword(prop.getProperty("Password"));
		registerpage.SelectPrivacyPolicy();
	   registerpage.clickContinueButton();
		String actualWarningMsg = "Telephone must be between 3 and 32 characters!";
		String WarningMsg = registerpage.getTelePhoneWarningMatch();
		Assert.assertTrue(actualWarningMsg.contains(WarningMsg));

	}

}
