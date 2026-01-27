package tutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF__009 {
	
	@Test
	public void verifyRegisteringAccountProvidingtheExistingEmail() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Rehan");
		driver.findElement(By.id("input-lastname")).sendKeys("hassan");
		driver.findElement(By.id("input-email")).sendKeys("rehankhan56390@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("123459");

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualWarningMsg = "Warning: E-Mail Address is already registered!";
		String WarningMsg = driver
				.findElement(By
						.xpath("//div[@class='alert alert-danger alert-dismissible'][text()='Warning: E-Mail Address is already registered!']"))
				.getText();
		Assert.assertTrue(actualWarningMsg.contains(WarningMsg));
		driver.quit();

	}

}
