package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogOutPage {
	
	WebDriver driver;

	public AccountLogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h1[text()='Account Logout']")
	private WebElement logOut;

	public String getLogOutPageText() {
		return logOut.getText();
	}

}
