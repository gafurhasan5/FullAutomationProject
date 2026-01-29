package tutorialNinja.Register;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_013 extends Base {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowserAndApplication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyPlaceHoldersOfTextFieldsInRegisterPage() {

		String expectedFirstNamePlaceHolderText = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),
				expectedFirstNamePlaceHolderText);
		String expectedLastNamePlaceHolderText = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),
				expectedLastNamePlaceHolderText);
	}
}
