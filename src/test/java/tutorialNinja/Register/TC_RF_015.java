package tutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonUtils;

public class TC_RF_015 {

	@Test(dataProvider = "environmentSupplier")
	public void verifyRegisteringWithDifferentTestEnvironments(String env) {
		WebDriver driver = null;
		String browserName = env;
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Rehan");
		driver.findElement(By.id("input-lastname")).sendKeys("hassan");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getTimestampEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertEquals("Congratulations! Your new account has been successfully created!",
				driver.findElement(
						By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]"))
						.getText());
		// Assert.assertTrue(driver.findElement(By.linkText("Edit your account
		// information")).isDisplayed());

		driver.quit();

	}

	@DataProvider(name = "environmentSupplier")
	public Object[][] passTestEnvironment() {
		Object[][] envs = { { "chrome" }, { "firefox" }, { "edge" } };
		return envs;
	}

}
