package actionExamples;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;	
import org.testng.annotations.Test;

public class ActionClass {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions actionBuilder;
	
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
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		//driver.get("https://www.edureka.co/");
		driver.get("https://www.amazon.in/");
	}
	@Test
	public void browseCategories() throws InterruptedException
	{
		actionBuilder = new Actions(driver);
		actionBuilder.moveToElement(driver.findElement(By.cssSelector("a#nav-link-accountList"))).build().perform();
		
		driver.findElement(By.xpath("//a[starts-with(@class, \"nav-action-button\")]/child::span")).click();
		
		WebElement element = driver.findElement(By.id("ap_email"));
		//element.sendKeys("kuldeep.chaple@gmail.com");
		actionBuilder.moveToElement(element)
		.click()
		.keyDown(element,Keys.SHIFT)
		.sendKeys(element, "kuldeep.chapl@gmail.com")
		.keyUp(element, Keys.SHIFT)
		.build();
		
		
		//driver.findElement(By.xpath("//a[starts-with(@href, \"/gp/css/homepage.html?ie=UTF8&ref_=nav_youraccount_ya\")]/child::span")).click();
	}
		
		/*WebElement element = driver.findElement(By.cssSelector("#software-testing-certification-courses"));
		actionBuilder.moveToElement(element).build().perform();
		//element.click();
		
		WebElement element1 = driver.findElement(By.linkText("Mobile App Testing Using Appium"));
		actionBuilder.moveToElement(element1).build().perform();
		element1.click();

	}
	@Test
	public void sendSearchKeys() 
	{
	WebElement element = driver.findElement( By.name("user_v1[query]"));
	}*/
	@AfterSuite
	void tearDown()
	{
		//driver.close();
	}
}
