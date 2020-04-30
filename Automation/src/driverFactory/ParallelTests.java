package driverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTests {
	
	@BeforeClass
	void RunFirst()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Practices\\Automation\\Drivers\\chromedriver.exe");
	}

	@Test
	public void calcTest()
	{
		/*
		 * we are calling here DriverFactoryPattern.getInstance method that returns the instance of
		 * factory class and over the factory instance we are calling getDriver to get a unique Webdriver object every time */
		WebDriver driver = DriverFactoryPattern.getInstance().getDriver();
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("sqrt 100");
		element.submit();
	}
	
	@Test
	public void searchText()
	{
		WebDriver driver = DriverFactoryPattern.getInstance().getDriver();
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Appium");
		element.submit();
	}
	
}
