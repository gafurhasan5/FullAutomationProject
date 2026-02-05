package base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import utils.CommonUtils;

public class Base {
	WebDriver driver;
	Properties prop;
	Actions actions;

	public WebDriver openBrowserAndApplication() throws IOException {

		prop = CommonUtils.loadProperties();
		String browserName = prop.getProperty("browserName");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		return driver;
	}
	public WebDriver navigateBack(WebDriver driver)
	{
		driver.navigate().back();
		return driver;
	}

	public WebDriver pressKeyMultipleTime(WebDriver driver, Keys keyName, int count) {
		Actions actions = new Actions(driver);
		for (int i = 1; i <= count; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
		return driver;
	}

	public WebDriver enterDetailIntoregisterAccountPageFields(WebDriver driver) throws IOException {
		prop = CommonUtils.loadProperties();
		Actions actions = new Actions(driver);
		actions.sendKeys(prop.getProperty("FirstName")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("LastName")).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(CommonUtils.getTimestampEmail()).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("PhoneNum"))
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(prop.getProperty("Password")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("Password")).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.ENTER).build().perform();
		return driver;

	}
	public WebDriver enterDetailIntoLoginField(WebDriver driver) throws IOException
	{
		prop = CommonUtils.loadProperties();
		Actions actions = new Actions(driver);
		actions.sendKeys(prop.getProperty("existingEmail")).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1)).sendKeys(prop.getProperty("existingPassword")).sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.ENTER).build().perform();
		
		return driver;
	}
}
