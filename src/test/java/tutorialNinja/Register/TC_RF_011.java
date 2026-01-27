package tutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_011 {
	
	@Test
	public void verifyRegisteringAccountInvalidMobileNumber() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Rehan");
		driver.findElement(By.id("input-lastname")).sendKeys("hassan");
		driver.findElement(By.id("input-email")).sendKeys(getTimestampEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("12");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualWarningMsg = "Telephone must be between 3 and 32 characters!";
		String WarningMsg = driver
				.findElement(By
						.xpath("//div[@class='text-danger'][text()='Telephone must be between 3 and 32 characters!']"))
				.getText();
		Assert.assertTrue(actualWarningMsg.contains(WarningMsg));
		
	}
	private String getTimestampEmail() {
		return "rehankhan" + System.currentTimeMillis() + "@gmail.com";
	}

}
