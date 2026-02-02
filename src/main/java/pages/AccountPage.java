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
	@FindBy(xpath="//a[text()='Subscribe / unsubscribe to newsletter']")
	private WebElement subscribeUnsubscribeNewsLetterOption;

	public NewsLetterPage selectsubscribeUnsubscribeNewsLetter() {

		subscribeUnsubscribeNewsLetterOption.click();
		return new NewsLetterPage(driver);
	}
}
