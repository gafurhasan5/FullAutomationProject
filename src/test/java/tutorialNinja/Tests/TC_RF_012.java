package tutorialNinja.Tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
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

public class TC_RF_012 extends Base {

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
	public void verifyRegisteringAccountUsingKeyboarkey() throws IOException {

		 driver=pressKeyMultipleTime(driver,Keys.TAB,23);
			driver= enterDetailIntoregisterAccountPageFields(driver);
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		
		Assert.assertTrue(accountsuccesspage.displaylogoutOption());

		Assert.assertTrue(accountsuccesspage.getSuccessAccountBreadcrumb());

	}

}
