package driverFactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	private static final DriverFactory instance = new DriverFactory();
	
	private DriverFactory(){
		
	}
	
	public static DriverFactory getInstance()
	{
		return instance;
	}
	
	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver(BrowserType type)
	{
		if(threadLocal.get()==null)
		{
		switch (type)
		{
		case CHROME:
			 threadLocal.set(new ChromeDriver());
		break;
        case FIREFOX:
		     threadLocal.set(new FirefoxDriver());
		break;
        case IE:
        	threadLocal.set(new InternetExplorerDriver());
		
	    default:
	    	break;	
		}
		
		}
		return threadLocal.get();
	}

}
