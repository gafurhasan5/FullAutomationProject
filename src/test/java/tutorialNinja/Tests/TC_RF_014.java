package tutorialNinja.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;

public class TC_RF_014 extends Base {

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
	public void verifyRegisteringWithMandatoryFieldsSymbolAndColorInRegisterPage() {

		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		Assert.assertEquals(registerpage.FirstNameLabelText(driver), expectedContent);
		Assert.assertEquals(registerpage.firstNameLabelColor(driver), expectedColor);

	}
}
