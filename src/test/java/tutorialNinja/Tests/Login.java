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
import pages.AccountLogOutPage;
import pages.AccountPage;
import pages.ChangePasswordPage;
import pages.ForgetPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login extends Base {
	WebDriver driver;
	Properties prop;
	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	ForgetPasswordPage forgetpasswordpage;
	AccountLogOutPage accountlogoutpage;
	ChangePasswordPage changepasswordpage;

	@BeforeMethod
	public void setup() throws IOException {

		driver = openBrowserAndApplication();
		prop = CommonUtils.loadProperties();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		loginpage = homepage.selectLoginOption();
		AccountPage accountpage = new AccountPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// TC_LF_001
	@Test(priority = 1)
	public void verifyloginWithValidCredentials() {
		Assert.assertTrue(loginpage.navigateLoginPaged());
		loginpage.enterEmailText(prop.getProperty("existingEmail"));
		loginpage.enterPassword(prop.getProperty("existingPassword"));
		accountpage = loginpage.clickLoginButtonOnLoginPage();
		Assert.assertTrue(accountpage.isUserLoggedIn());
		Assert.assertTrue(accountpage.isAccountPageDisplayed());

	}

	// TC_LF_002
	@Test(priority = 2)
	public void verifyloginWithInValidCredentials() {

		loginpage.enterEmailText(prop.getProperty("InvalidEmail"));
		loginpage.enterPassword(prop.getProperty("InvaliPassword"));
		loginpage.clickLoginButtonOnLoginPage();
		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);

	}

	// TC_LF_003
	@Test(priority = 3)
	public void verifyloginWithInValidEmailAndvalidPassword() {

		loginpage.enterEmailText(prop.getProperty("InvalidEmail"));
		loginpage.enterPassword(prop.getProperty("Password"));
		loginpage.clickLoginButtonOnLoginPage();
		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
	}

	// TC_LF_004
	@Test(priority = 4)
	public void verifyloginWithIValidEmailInvalidPassword() {

		loginpage.enterEmailText(prop.getProperty("existingEmail"));
		loginpage.enterPassword(prop.getProperty("InvaliPassword"));
		loginpage.clickLoginButtonOnLoginPage();
		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
	}

	// TC_LF_005
	@Test(priority = 6)
	public void verifyloginWithoutAnyCredentials() {

		loginpage.enterEmailText("");
		loginpage.enterPassword("");
		loginpage.clickLoginButtonOnLoginPage();
		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
	}

	// TC_LF_006
	@Test(priority = 6)
	public void verifyForgotttenPasswordlink() {
		Assert.assertTrue(loginpage.navigateLoginPaged());
		Assert.assertTrue(loginpage.getForgetButton());
		forgetpasswordpage = loginpage.clickForgetButton();
		Assert.assertTrue(forgetpasswordpage.isNavigateforgetpasswordPage());

	}

	// TC_LF_007
	@Test(priority = 7)
	public void verifyLoginwithUsingTab() throws IOException {

		driver = pressKeyMultipleTime(driver, Keys.TAB, 23);
		driver = enterDetailIntoLoginField(driver);
		AccountPage accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.isUserLoggedIn());
		Assert.assertTrue(accountpage.isAccountPageDisplayed());

	}

	// TC_LF_008
	@Test(priority = 8)
	public void verifyloginFieldPlaceholder() {

		String emailPlaceholder = "E-Mail Address";
		String passwordPlaceholder = "Password";
		Assert.assertEquals(loginpage.getEmailFieldPlaceholder(), emailPlaceholder);
		Assert.assertEquals(loginpage.getPasswordFieldPlaceholder(), passwordPlaceholder);

	}

	// TC_LF_009
	@Test(priority = 9)
	public void verifyloginBrwoserbackButton() {
		loginpage.enterEmailText(prop.getProperty("existingEmail"));
		loginpage.enterPassword(prop.getProperty("existingPassword"));
		accountpage = loginpage.clickLoginButtonOnLoginPage();
		driver = navigateBack(driver);
		driver.navigate().refresh();
		Assert.assertTrue(accountpage.isUserLoggedIn());
		Assert.assertTrue(accountpage.isAccountPageDisplayed());

	}

	// TC_LF_010
	@Test(priority = 10)
	public void verifylogingoutAndBrwoserbackButton() {
		loginpage.enterEmailText(prop.getProperty("existingEmail"));
		loginpage.enterPassword(prop.getProperty("existingPassword"));
		accountpage = loginpage.clickLoginButtonOnLoginPage();
		accountlogoutpage = accountpage.LogOut();
		String logOutMsg = "Account Logout";
		Assert.assertEquals(accountlogoutpage.getLogOutPageText(), logOutMsg);
		driver = navigateBack(driver);
		driver.navigate().refresh();
		LoginPage loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.navigateLoginPaged());

	}

	// TC_LF_012
	@Test(priority = 11)
	public void verifyloginMaxLimitTryLogging() {
		loginpage.enterEmailText(CommonUtils.getTimestampEmail());
		loginpage.enterPassword(prop.getProperty("InvaliPassword"));
		loginpage.clickLoginButtonOnLoginPage();
		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
		loginpage.clickLoginButtonOnLoginPage();
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
		loginpage.clickLoginButtonOnLoginPage();
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
		loginpage.clickLoginButtonOnLoginPage();
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
		loginpage.clickLoginButtonOnLoginPage();
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);
		loginpage.clickLoginButtonOnLoginPage();
		String MaxLimitLoginWarning = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
		Assert.assertEquals(loginpage.getinvaliMaxLimitWarningLoginMsg(), MaxLimitLoginWarning);
	}

	// TC_LF_013
	@Test(priority = 12)
	public void verifyCopyingofTextEnteredIntoPasswordField() {

		String passwordText = prop.getProperty("InvaliPassword");

		loginpage.enterPassword(passwordText);
		driver = loginpage.selectPasswordFieldTextAndCopy(driver);
		driver = loginpage.pasteCopiedPasswordIntoEmailField(driver);
		Assert.assertNotEquals(loginpage.getCopiedintEmailField(), passwordText);

	}

	// TC_LF_015
	@Test(priority = 13)
	public void verifyloggingAfterPasswordChange() {
		String oldPassword = prop.getProperty("existingPassword");
		String newPassword = prop.getProperty("changePassword");
		loginpage.enterEmailText(prop.getProperty("existingEmail"));
		loginpage.enterPassword(oldPassword);
		accountpage = loginpage.clickLoginButtonOnLoginPage();

		changepasswordpage = accountpage.isUserChangePassword(driver);

		changepasswordpage.enterChangePassWordText(newPassword);

		changepasswordpage.enterChangeConfirmPassWordText(newPassword);
		accountpage = changepasswordpage.clickContinueButton();
		String passwordChangeSuccesmsg = "Success: Your password has been successfully updated.";
		Assert.assertEquals(accountpage.getPasswordChangeMsg(), passwordChangeSuccesmsg);
		accountpage.LogOut();

		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();

		loginpage = homepage.selectLoginOption();

		loginpage.enterEmailText(prop.getProperty("existingEmail"));

		loginpage.enterPassword(oldPassword);

		loginpage.clickLoginButtonOnLoginPage();
		String expectedWarningMsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginpage.getInvaliWarningLoginMsg(), expectedWarningMsg);

		loginpage.enterPassword(newPassword);

		accountpage = loginpage.clickLoginButtonOnLoginPage();
		Assert.assertTrue(accountpage.isUserLoggedIn());
		Assert.assertTrue(accountpage.isAccountPageDisplayed());
		prop.setProperty("existingPassword", newPassword);
		prop.setProperty("changePassword", oldPassword);

	}

}
