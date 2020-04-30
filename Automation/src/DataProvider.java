import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProvider {
	@BeforeClass
	void setUpClass()
	{
		System.setProperty("webdriver.chrome.driver","F:\\Practices\\Automation\\Drivers\\chromedriver.exe");
	}
	
@org.testng.annotations.DataProvider(name="browsers", parallel=true)
	Object[][] testBrowser()
	{
		return new Object[][] {
			{"Selenium Driver"},
			{"TestNg"},
			{"Appium"}
		};
	
	}
	
	@Test(dataProvider="browsers")
	void searchTest(String search)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(search);
		element.submit();
		
		Assert.assertTrue(driver.getTitle().startsWith(search));
		
		System.out.println(search + ":" + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
		
	}
	

}
