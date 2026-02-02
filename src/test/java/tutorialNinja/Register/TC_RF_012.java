package tutorialNinja.Register;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
	public void verifyRegisteringAccountUsingKeyboarkey() {

		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		Actions actions = new Actions(driver);
		for (int i = 1; i <= 23; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}

		actions.sendKeys(prop.getProperty("FirstName")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("LastName")).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(CommonUtils.getTimestampEmail()).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("PhoneNum"))
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("Password")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("Password")).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.ENTER).build().perform();
		Assert.assertTrue(accountsuccesspage.displaylogoutOption());

		Assert.assertTrue(accountsuccesspage.getSuccessAccountBreadcrumb());

	}

}
