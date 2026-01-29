package tutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.CommonUtils;

public class TC_RF_012 extends Base {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyRegisteringAccountUsingKeyboarkey() {

		Actions actions = new Actions(driver);
		for (int i = 1; i <= 23; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
		/*
		 * actions.sendKeys("gafur").pause(Duration.ofSeconds(1))
		 * 
		 * .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("hassan").sendKeys(
		 * Keys.TAB)
		 * .pause(Duration.ofSeconds(1)).sendKeys("Motoori").sendKeys(Keys.TAB).pause(
		 * Duration.ofSeconds(1))
		 * .sendKeys(getTimestampEmail()).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)
		 * ) .sendKeys(getTimestampEmail())
		 * 
		 * .pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		 * 
		 * .sendKeys("9833847747").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 * 
		 * .pause(Duration.ofSeconds(1)).sendKeys("12345").pause(Duration.ofSeconds(1))
		 * 
		 * .sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("12345")
		 * 
		 * .pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		 * 
		 * .sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 * 
		 * .pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		 * 
		 * 
		 * 
		 * .sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		 * 
		 * .pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
		 */

		actions.sendKeys("Arun").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys("Motoori").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(CommonUtils.getTimestampEmail()).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("1234567890").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("12345").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("12345").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER)
				.build().perform();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='column-right']//a[text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

		driver.quit();

	}

}
