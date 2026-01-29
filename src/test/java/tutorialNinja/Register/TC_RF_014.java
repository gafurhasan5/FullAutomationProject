package tutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_014 {
	@Test
	public void verifyRegisteringWithMandatoryFieldsSymbolAndColorInRegisterPage() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		WebElement firstName = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String fnContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')", firstName);
		String fnColor = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", firstName);
		System.out.println(fnContent);
		System.out.println(fnColor);
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);
		driver.quit();
	}
}
