package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Logout")
	private WebElement logoutOption;

	public boolean displaylogoutOption() {
		return logoutOption.isDisplayed();
	}

	@FindBy(xpath = "//div[@id='common-success']//h1")
	private WebElement getPageHeading;

	public String displayPageHeading() {
		return getPageHeading.getText();
	}

	@FindBy(id = "content")
	private WebElement PageContent;

	public String displayPageContent() {
		return PageContent.getText();
	}

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueButtonField;

	public AccountPage clickContinueButton() // continue button it goes to accounpage that why i return accuntpage
												// object
	{
		continueButtonField.click();
		return new AccountPage(driver);
	}

}
