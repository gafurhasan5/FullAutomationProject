package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "input-email")
	private WebElement emailField;

	public void enterEmailText(String emailtext) {
		emailField.sendKeys(emailtext);
	}
	@FindBy(id = "input-password")
	private WebElement passwordField;

	public void enterPassword(String passwordtext) {
		passwordField.clear();
		passwordField.sendKeys(passwordtext);
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginButtonOnLoginPage;

	public AccountPage clickLoginButtonOnLoginPage() {
		LoginButtonOnLoginPage.click();
		return new AccountPage(driver);
	}
	
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Login']")
	private WebElement navigateLoginPage;

	public boolean navigateLoginPaged() {
		return navigateLoginPage.isDisplayed();
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary'][text()='Continue']")
	private WebElement ContinueButtonOnLoginPage;

	public void selectContinueButtonOnLoginPage() {
		ContinueButtonOnLoginPage.click();
	}
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Register']")
	private WebElement RegisterOptionOnSideLoginPage;

	public void clickRegisterOptionOnSideLoginPage() {
		RegisterOptionOnSideLoginPage.click();
	}
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invaliWarningLoginMsg;

	public String getInvaliWarningLoginMsg() {
		return invaliWarningLoginMsg.getText();
	}
	@FindBy(xpath = "//div[@class='form-group']//a[text()='Forgotten Password']")
	private WebElement forgetButtondisplay;

	public boolean getForgetButton() {
		return forgetButtondisplay.isDisplayed();
	}
	@FindBy(xpath = "//div[@class='form-group']//a[text()='Forgotten Password']")
	private WebElement forgetButton;

	public ForgetPasswordPage clickForgetButton() {
		forgetButton.click();
		return new ForgetPasswordPage(driver);
	}
	public String getEmailFieldPlaceholder()
	{
		return emailField.getDomAttribute("placeholder");
	}
	public String getPasswordFieldPlaceholder()
	{
		return passwordField.getDomAttribute("placeholder");
	}
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invaliMaxLimitWarningLoginMsg;

	public String getinvaliMaxLimitWarningLoginMsg() {
		return  invaliMaxLimitWarningLoginMsg.getText();
	}
	
	public WebDriver selectPasswordFieldTextAndCopy(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(passwordField).keyDown(Keys.CONTROL)
		.sendKeys("c").keyUp(Keys.CONTROL);
		return driver;
	}
	public WebDriver pasteCopiedPasswordIntoEmailField(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(emailField).keyDown(Keys.CONTROL)
		.sendKeys("v").keyUp(Keys.CONTROL);
		return driver;
	}
	public String getCopiedintEmailField()
	{
		return emailField.getDomAttribute("value");
	}
	
	


}
