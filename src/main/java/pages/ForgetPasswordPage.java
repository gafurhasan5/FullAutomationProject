package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {
	WebDriver driver;

	public ForgetPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@id='content']//h1[text()='Forgot Your Password?']")
	private WebElement NavigateforgetpasswordPage;

	public boolean isNavigateforgetpasswordPage() {
		return NavigateforgetpasswordPage.isDisplayed();
	}
}
