package tutorialNinja.Register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {

	@Test(priority = 5)
	public void verifyRegisteringAccountWithInvalidEmail() throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("Rehan");
		driver.findElement(By.id("input-lastname")).sendKeys("hassan");
		driver.findElement(By.id("input-email")).sendKeys("rehankhan");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		File screenShot = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(screenShot,
				new File("C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\sc1Actual.png"));
		BufferedImage actualbufferedImag = ImageIO.read(
				new File("C:\\\\FullAutomationLiveProject\\\\FullAutomationProject\\\\Screenshots\\\\sc1Actual.png"));
		BufferedImage expectedbufferedImag = ImageIO
				.read(new File("C:\\FullAutomationLiveProject\\FullAutomationProject\\Screenshots\\Sc1Expected.png"));
		ImageDiffer imgdiffer = new ImageDiffer();
		ImageDiff ImageDifferences = imgdiffer.makeDiff(expectedbufferedImag, actualbufferedImag);
		// If image has no difference it return true
		boolean b = ImageDifferences.hasDiff();
		System.out.println(b);
		Assert.assertFalse(ImageDifferences.hasDiff());
		driver.quit();
	}

}