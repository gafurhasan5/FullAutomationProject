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
import pages.RegisterPage;
import utils.CommonUtils;

public class TC_RF_001 extends Base {
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
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringWithMandatoryFields() {

		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("FirstName"));
		registerpage.enterSecondName(prop.getProperty("LastName"));
		registerpage.enterEmail(CommonUtils.getTimestampEmail());
		registerpage.enterPhone(prop.getProperty("PhoneNum"));
		registerpage.enterPassword(prop.getProperty("Password"));
		registerpage.enterConPassword(prop.getProperty("Password"));
		registerpage.SelectPrivacyPolicy();
		accountsuccesspage = registerpage.clickContinueButton();

		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty(
		 * "FirstName"));
		 * 
		 * //driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty(
		 * "LastName")); driver.findElement(By.id("input-email")).sendKeys(CommonUtils.
		 * getTimestampEmail());
		 * driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty(
		 * "PhoneNum"));
		 * driver.findElement(By.id("input-password")).sendKeys(prop.getProperty(
		 * "Password"));
		 * driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty(
		 * "Password")); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 */

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

		/*
		 * Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		 * 
		 * String expectedHeading = "Your Account Has Been Created!";
		 * 
		 * Assert.assertEquals(driver.findElement(By.xpath(
		 * "//div[@id='common-success']//h1")).getText(), expectedHeading);
		 * 
		 * String actualProperDetailsOne =
		 * "Congratulations! Your new account has been successfully created!"; String
		 * actualProperDetailsTwo =
		 * "You can now take advantage of member privileges to enhance your online shopping experience with us."
		 * ; String actualProperDetailsThree =
		 * "If you have ANY questions about the operation of this online shop, please e-mail the store owner."
		 * ; String actualProperDetailsFour = "contact us";
		 * 
		 * String expectedProperDetails =
		 * driver.findElement(By.id("content")).getText();
		 * 
		 * Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsOne));
		 * Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsTwo));
		 * Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsThree));
		 * Assert.assertTrue(expectedProperDetails.contains(actualProperDetailsFour));
		 * 
		 * driver.findElement(By.xpath("//a[text()='Continue']")).click();
		 * 
		 * Assert.assertTrue(driver.findElement(By.
		 * linkText("Edit your account information")).isDisplayed());
		 */

	}

}