package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	WebDriver driver;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "input-password")
	private WebElement changepasswordField;

	public void enterChangePassWordText(String changePasswordText) {
		changepasswordField.sendKeys(changePasswordText);
		
	}
	@FindBy(id ="input-confirm")
	private WebElement changeConfirmpasswordField;

	public void enterChangeConfirmPassWordText(String changePasswordText) {
		changeConfirmpasswordField.sendKeys(changePasswordText);
	}
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement optionbutton;

	public AccountPage clickContinueButton() {
		optionbutton.click();
		return new AccountPage(driver);
	}
}
