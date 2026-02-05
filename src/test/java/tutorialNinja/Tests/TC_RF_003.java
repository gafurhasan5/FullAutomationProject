package tutorialNinja.Tests;

import java.io.IOException;
import java.util.Properties;

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

public class TC_RF_003 extends Base {

	WebDriver driver;
	Properties prop;
	HomePage homepage;
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	AccountPage accountpage;

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
	public void verifyRegisteringWithAllFields() {

		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterSecondName(prop.getProperty("LastName"));
		registerpage.enterEmail(CommonUtils.getTimestampEmail());
		registerpage.enterPhone(prop.getProperty("PhoneNum"));
		registerpage.enterPassword(prop.getProperty("Password"));
		registerpage.enterConPassword(prop.getProperty("Password"));
		registerpage.SelectPrivacyPolicy();
		registerpage.selectNewsLetter();
		accountsuccesspage = registerpage.clickContinueButton();

		Assert.assertTrue(accountsuccesspage.displaylogoutOption());
		String expectedHeading = "Your Account Has Been Created!";

		Assert.assertEquals(accountsuccesspage.displayPageHeading(), expectedHeading);
		String expectedProperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFour = "contact us";
		String actualProperDetails = accountsuccesspage.displayPageContent();
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		accountpage = accountsuccesspage.clickContinueButton();
		Assert.assertTrue(accountpage.isAccountPageDisplayed());

	}

}
