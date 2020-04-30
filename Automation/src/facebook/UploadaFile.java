package facebook;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class UploadaFile {
WebDriver driver;
WebDriverWait wait ;



	@BeforeSuite
	void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Practices\\Automation\\Drivers\\chromedriver.exe");
	}
	@BeforeClass
	void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
	}
	
	@Test(priority=0)
	public void uploadFile()
	{
		WebElement element = driver.findElement(By.xpath("//input[@name='upfile']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js =  (JavascriptExecutor)driver;
				//js.executeScript("document.getElementByName=('upfile').click()");
				js.executeScript("arguments[0].click();", element );
			 
		
		//wait.until(ExpectedConditions.elementToBeClickable(element));*/
		
		//System.out.println(element.isEnabled());
		
		//element.click();
	}
	/*@Test(dependsOnMethods="uploadFile")
	public void pressButton()
	{
		WebElement element = driver.findElement(By.cssSelector("input[value='Press']"));
		element.click();
		
	}*/
}
