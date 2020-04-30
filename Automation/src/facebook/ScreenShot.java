package facebook;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenShot {
	
WebDriver driver;
	
	@BeforeSuite
	void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Practices\\Automation\\Drivers\\chromedriver.exe");
	}
	@BeforeMethod
	void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// Sets the amount of time to wait for a page load to complete before throwing an error.
		
		driver.get("https://stackoverflow.com/questions/11947832/how-to-click-an-element-in-selenium-webdriver-using-javascript");
	}
	
	@Test
   public void takeaScreenShot() throws IOException
   {
		// TakesScreenshot is different interface and driver is instance of webdriver interface
		// as getScreenshotAs is a method from TakesScreenshot interface and we can't directly called getScreenshotAs 
		// method from TakesScreenshot interface.So that why we need to typecast webdriver into TakesScreenshot.
		// we can also use ChromeDriver or RemoteWebDriver instead of TakesScreenshot interface.
		
		TakesScreenshot srcShot =  ((TakesScreenshot)driver);
		File SrcFile = srcShot.getScreenshotAs(OutputType.FILE);
		
		File DeskFile = new File("F:\\Practices\\Automation\\ScreenShot\\test.png");
		Files.copy(SrcFile, DeskFile);
   }
}
