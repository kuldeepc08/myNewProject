import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;

public class IE {
	
	public static void main(String[] args)
	{
		WebDriver driver;
		
		// 2. For IE browser Zoom level need to be 100%
		// 1.  Same protected mode setting for all security zones is needed on browser 
		
		System.setProperty("webdriver.ie.driver", "F:\\Practices\\Automation\\Drivers\\IEDriverServer.exe");
		InternetExplorerOptions option = new InternetExplorerOptions(); // 1. option is resolve using programmatically
		option.introduceFlakinessByIgnoringSecurityDomains();
	
		driver=new InternetExplorerDriver(option);
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	
		
		driver.quit();
	}

}
