package tutorialNinja.Register;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;

public class TC_RF_013 extends Base {

	WebDriver driver;
	HomePage homepage;
	RegisterPage registerpage;

	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		homepage.selectRegisterOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyPlaceHoldersOfTextFieldsInRegisterPage() {

		String expectedFirstNamePlaceHolderText = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),
				expectedFirstNamePlaceHolderText);
		String expectedLastNamePlaceHolderText = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),
				expectedLastNamePlaceHolderText);
	}
}
