package facebook;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FB {
	
	WebDriver driver;
	WebDriverWait wait;
	
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
		wait = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void newAccount()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
		
		WebElement fName = driver.findElement(By.name("firstname"));
		fName.sendKeys("KC");
		
		WebElement lName = driver.findElement(By.name("lastname"));
		lName.sendKeys("Last");
		
		WebElement email = driver.findElement(By.name("reg_email__"));
		email.sendKeys("kuldeep.chaple@gmail.com");
		
		WebElement pass = driver.findElement(By.name("reg_passwd__"));
		pass.sendKeys("Test123##");
		
		Select dob = new Select(driver.findElement(By.id("day")));
		dob.selectByValue("8");
		
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("10");
		
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1985");
		
		WebElement radio = driver.findElement(By.cssSelector("input#u_0_a"));
		radio.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("u_0_13")));
		driver.findElement(By.id("u_0_13")).click();
		
		
		
		
		
		
		
		
	}

}
