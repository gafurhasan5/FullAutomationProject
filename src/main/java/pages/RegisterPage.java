package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	public void enterFirstName(String firstNameText) 
	{
		firstNameField.sendKeys(firstNameText);
	}
	@FindBy(id="input-lastname")
	private WebElement secondNameField;
	public void enterSecondName(String secondNameText) 
	{
		secondNameField.sendKeys(secondNameText);
	}
	@FindBy(id="input-email")
	private WebElement emailField;
	public void enterEmail(String emailText) 
	{
		emailField.sendKeys(emailText);
	}
	@FindBy(id="input-telephone")
	private WebElement telePhoneField;
	public void enterPhone(String phoneText) 
	{
		telePhoneField.sendKeys(phoneText);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	public void enterPassword(String passwordText) 
	{
		passwordField.sendKeys(passwordText);
	}
	@FindBy(id="input-confirm")
	private WebElement conpasswordField;
	public void enterConPassword(String conpasswordText) 
	{
		conpasswordField.sendKeys(conpasswordText);
	}
	@FindBy(name="agree")
	private WebElement selectPrivacyFiled;
	public void  SelectPrivacyPolicy() 
	{
		selectPrivacyFiled.click();
	}
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButtonField;
	public AccountSuccessPage  clickContinueButton()  // continue button it goes to accounsuccessPage that why i return accountsuccesspage object
	{
		continueButtonField.click();
		return new AccountSuccessPage(driver);
	}
	
}
