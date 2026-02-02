package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	@FindBy(id = "input-lastname")
	private WebElement secondNameField;

	public void enterSecondName(String secondNameText) {
		secondNameField.sendKeys(secondNameText);
	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	@FindBy(id = "input-telephone")
	private WebElement telePhoneField;

	public void enterPhone(String phoneText) {
		telePhoneField.sendKeys(phoneText);
	}

	@FindBy(id = "input-password")
	private WebElement passwordField;

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	@FindBy(id = "input-confirm")
	private WebElement conpasswordField;

	public void enterConPassword(String conpasswordText) {
		conpasswordField.sendKeys(conpasswordText);
	}

	@FindBy(name = "agree")
	private WebElement selectPrivacyFiled;

	public void SelectPrivacyPolicy() {
		selectPrivacyFiled.click();
	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButtonField;

	public AccountSuccessPage clickContinueButton() // continue button it goes to accounsuccessPage that why i return
													// accountsuccesspage object
	{
		continueButtonField.click();
		return new AccountSuccessPage(driver);
	}

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement selectNewsLetterField;

	public void selectNewsLetter()

	{
		selectNewsLetterField.click();

	}

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	public String getFirstNameWarning()

	{
		return firstNameWarning.getText();

	}

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	public String getlastNameWarning()

	{
		return lastNameWarning.getText();

	}

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;

	public String getEmailWarning()

	{
		return emailWarning.getText();

	}

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telePhoneWarning;

	public String getTelePhoneWarning()

	{
		return telePhoneWarning.getText();

	}

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public String getPasswordWarning()

	{
		return passwordWarning.getText();

	}

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privaciPolicyWarning;

	public String getPrivicyPolicyWarning()

	{
		return privaciPolicyWarning.getText();

	}

	@FindBy(xpath = "//input[@name='newsletter'][@value='0']")
	private WebElement noSelectNewsLetterOption;

	public void noSelectNewsLetter()

	{
		noSelectNewsLetterOption.click();

	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Register']")
	private WebElement registerBreadcrum;

	public boolean didNavigateToRegisterAccountPage()

	{
		return registerBreadcrum.isDisplayed();

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDemoOnRegisterPage;

	public void clickMyAccountMenuOnRegisterPage()

	{
		myAccountDemoOnRegisterPage.click();

	}

	
	
	@FindBy(linkText="Login")
	private WebElement myAccountLoginRegisterPage;

	public LoginPage clickMyAccountLoginRegisterPage()

	{
		 myAccountLoginRegisterPage.click();
		 return new LoginPage(driver);

	}

	@FindBy(xpath = "//a[@class='btn btn-primary'][text()='Continue']")
	private WebElement loginOptionOnRegisterPage;

	public void clickLoginButtonOnRegisterAccountPage() {
		loginOptionOnRegisterPage.click();
	}

	
	@FindBy(xpath = "//div[@class='text-danger' and text()='Password confirmation does not match password!']")
	private WebElement passwordWarningMisMatch;

	public String getPasswordWarningMisMatch()

	{
		return passwordWarningMisMatch.getText();

	}
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement existingEmailWarning;

	public String getExistingEmailWarning()

	{
		return existingEmailWarning.getText();

	}
	@FindBy(xpath = "//div[@class='text-danger'][text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telePhoneWarningMatch;

	public String getTelePhoneWarningMatch()

	{
		return  telePhoneWarningMatch.getText();

	}


}
