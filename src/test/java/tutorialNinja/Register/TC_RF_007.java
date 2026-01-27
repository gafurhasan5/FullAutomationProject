package tutorialNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {
	@Test
	public void verifyNavigatingToRegisterAccountinMultipleWays() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

           Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
           
           driver.findElement(By.xpath("//span[text()='My Account']")).click();
           driver.findElement(By.xpath("//li/a[text()='Login']")).click();
           driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
           Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
         
           driver.findElement(By.xpath(" //a[@class='list-group-item'][text()='Register']")).click();
           Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		   driver.quit();

	}




}
