package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountPageInformationOption;

	public boolean isAccountPageDisplayed() {
		return editAccountPageInformationOption.isDisplayed();
	}

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	private WebElement logOutOption;

	// a[@class='list-group-item'][text()='Logout']
	public boolean isUserLoggedIn() {

		return logOutOption.isDisplayed();
	}

	@FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
	private WebElement subscribeUnsubscribeNewsLetterOption;

	public NewsLetterPage selectsubscribeUnsubscribeNewsLetter() {

		subscribeUnsubscribeNewsLetterOption.click();
		return new NewsLetterPage(driver);
	}

//	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
//	private WebElement MenuDropDownLogOutOption;
//	
//
//	public AccountLogOutPage logOutApplication()
//	{
//		MenuDropDownLogOutOption.click();
//		return new AccountLogOutPage(driver);
//	}
	public AccountLogOutPage LogOut() {

		logOutOption.click();
		return new AccountLogOutPage(driver);
	}

	@FindBy(xpath = "//a[text()='Change your password']")
	private WebElement changePasswordbutton;

	public ChangePasswordPage isUserChangePassword(WebDriver driver) {

		changePasswordbutton.click();
		return new ChangePasswordPage(driver);
	}

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement changePasswordWarning;

	public String getPasswordChangeMsg() {

		return changePasswordWarning.getText();
	}

}
