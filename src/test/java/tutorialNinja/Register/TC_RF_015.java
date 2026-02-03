package tutorialNinja.Register;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class TC_RF_015 extends Base {

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

	@Test(dataProvider = "environmentSupplier")
	public void verifyRegisteringWithDifferentTestEnvironments(String env) {
		//WebDriver driver = null;
		//String browserName = env;

		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterSecondName(prop.getProperty("LastName"));
		registerpage.enterEmail(CommonUtils.getTimestampEmail());
		registerpage.enterPhone(prop.getProperty("PhoneNum"));
		registerpage.enterPassword(prop.getProperty("Password"));
		registerpage.enterConPassword(prop.getProperty("Password"));
		registerpage.SelectPrivacyPolicy();
		accountsuccesspage = registerpage.clickContinueButton();

		Assert.assertTrue(accountsuccesspage.displaylogoutOption());
		Assert.assertTrue(accountsuccesspage.getSuccessAccountBreadcrumb());
		

		


	}

	@DataProvider(name = "environmentSupplier")
	public Object[][] passTestEnvironment() {
		Object[][] envs = { { "chrome" }, { "firefox" }, { "edge" } };
		return envs;
	}

}
