import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FF {
	
	public static void main(String[] args)
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "F:\\Practices\\Automation\\Drivers\\geckodriver.exe");
		
	    driver = new FirefoxDriver();
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//driver.findElement(By.className("nav-a nav-a-2")).click();	
	    driver.findElement(By.id("nav-link-accountList")).click();
	    
	    driver.findElement(By.cssSelector("span.nav-action-inner")).click();
	  
	    String name = driver.findElement(By.cssSelector("h1.a-spacing-small")).getText();
	   System.out.println(name);
	 
	   String lab1 = driver.findElement(By.cssSelector("label.a-form-label")).getText();
	   System.out.println(lab1);
	   
	  System.out.println(driver.findElement(By.cssSelector("label.a-form-label")).isDisplayed());
	   
	    
	    
	    
	    driver.findElement(By.id("ap_email")).sendKeys("9823863597");
	    
	    driver.findElement(By.id("continue")).click();
	    
	    driver.findElement(By.id("ap_password")).sendKeys("Test123$$");
	    
	    driver.findElement(By.id("signInSubmit")).click();
		
		//driver.quit();	
	}

}
