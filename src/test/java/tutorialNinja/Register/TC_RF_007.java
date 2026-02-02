package tutorialNinja.Register;

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
import pages.LoginPage;
import pages.RegisterPage;
import utils.CommonUtils;

public class TC_RF_007 extends Base {

	WebDriver driver;
	Properties prop;
	HomePage homepage;
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	AccountPage accountpage;
	LoginPage loginpage;

	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();
		prop = CommonUtils.loadProperties();
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
	public void verifyNavigatingToRegisterAccountinMultipleWays() throws InterruptedException {
		Thread.sleep(100);
		Assert.assertTrue(registerpage.didNavigateToRegisterAccountPage());

		registerpage.clickMyAccountMenuOnRegisterPage();

		loginpage = registerpage.clickMyAccountLoginRegisterPage();
		loginpage.selectContinueButtonOnLoginPage();
		Assert.assertTrue(registerpage.didNavigateToRegisterAccountPage());
		loginpage = registerpage.clickMyAccountLoginRegisterPage();
		loginpage.selectContinueButtonOnLoginPage();

		loginpage.clickRegisterOptionOnSideLoginPage();

		Assert.assertTrue(registerpage.didNavigateToRegisterAccountPage());

	}

}
