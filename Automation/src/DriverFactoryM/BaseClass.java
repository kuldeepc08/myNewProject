package DriverFactoryM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	private static List<WebDriver> driverPool = new ArrayList<WebDriver>();
	
	/*driverPool is an array list or collection of webDriver object that are instantiated by all the derived class*/
	
	@BeforeSuite
	void setUpSuite()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Practices\\Automation\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "F:\\Practices\\Automation\\Drivers\\geckodriver.exe");
	}
	WebDriver getDriver() // method overloading
	{
		return getDriver(BrowserType.CHROME,"https://www.google.com/");
	}
	WebDriver getDriver(BrowserType type , String baseURL)
	{
		WebDriver driver = DriverFactory.getInstance().getDriver(type);
		driverPool.add(driver);
		driver.get(baseURL);
		return driver;
	}
	
	@AfterSuite
	void tearDownSuite()
	{
		for (WebDriver webdriver : driverPool) {
		//	webdriver.quit();
		}
	}
	
}
