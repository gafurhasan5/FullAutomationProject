package tutorialNinja.Register;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class TC_RF_009 extends Base {
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
	public void verifyRegisteringAccountProvidingtheExistingEmail() {

		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterSecondName(prop.getProperty("LastName"));
		registerpage.enterEmail("rehankhan56390@gmail.com");
		registerpage.enterPhone(prop.getProperty("PhoneNum"));
		registerpage.enterPassword(prop.getProperty("Password"));
		registerpage.enterConPassword(prop.getProperty("Password"));
		registerpage.SelectPrivacyPolicy();
	    registerpage.clickContinueButton();

		String actualWarningMsg = "Warning: E-Mail Address is already registered!";
		String WarningMsg =registerpage.getExistingEmailWarning();

		Assert.assertTrue(actualWarningMsg.contains(WarningMsg));



	}

}
