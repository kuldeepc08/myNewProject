import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Chrome {
	
	public static void main(String[] args)
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "F:\\Practices\\Automation\\Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		//driver.manage().window().maximize();
		driver.get("https://www.google.com");
	
		
		driver.quit();
	}

}
