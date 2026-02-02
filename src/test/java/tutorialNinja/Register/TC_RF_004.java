package tutorialNinja.Register;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;

public class TC_RF_004 extends Base {

	WebDriver driver;
	HomePage homepage;
	RegisterPage registerpage;

	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();

		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		homepage.selectRegisterOption();
		registerpage = new RegisterPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringWithoutAnyFields() {

		registerpage.clickContinueButton();
		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(registerpage.getFirstNameWarning(), expectedFirstNameWarning);
		Assert.assertEquals(registerpage.getlastNameWarning(), expectedLastNameWarning);
		Assert.assertEquals(registerpage.getEmailWarning(), expectedEmailWarning);
		Assert.assertEquals(registerpage.getTelePhoneWarning(), expectedTelephoneWarning);
		Assert.assertEquals(registerpage.getPasswordWarning(), expectedPasswordWarning);
		Assert.assertEquals(registerpage.getPrivicyPolicyWarning(), expectedPrivacyPolicyWarning);

	}

}
