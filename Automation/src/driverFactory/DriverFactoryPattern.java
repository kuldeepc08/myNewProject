package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactoryPattern {
	
	/*what is singletone design pattern
	 * Ensure that only one instance of the singleton class ever exist
	 * provide global access to that instance
	 * 
	 * what is a factory design pattern
	 * Define a separate operation (factory method) for creating an object
	 * create an object by calling a factory method
	 * */
	
	/*1. is a single factory which could produce multiple driver object that we need*/
	
	//Singleton design pattern
	private static final DriverFactoryPattern instance = new DriverFactoryPattern();
	
	/*with in the class we have DriverFactoryPattern instance that create the factory object
	 * it is defined as static so only one copy of the instance for the class
	 * and static so no class can override the method*/
	
	private DriverFactoryPattern() /*thats why we made constructor as private so no other external class can create
	another factory object
	*/
	{}
	
	public static DriverFactoryPattern getInstance() /**/
	{
		return instance;	
	}
	
	//Factory Design pattern
	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>() {
		/*this is reference of threadlocal class - threadlocal can contain any kind object, Object that we initialize
		 Advantage of Threadlocal is that - it gives each thread a separate instance of the given object
		 when running parallel test each of the thread will have a separate copy of the thread local variable
		 and we don't have to worry about thread synchronization issue, cause thread local separately handles it.  
		 */
	
	@Override
	protected WebDriver initialValue()  /**/
	{
		return new ChromeDriver(); /**/
	}
    };
    
    public WebDriver getDriver() /*our test is going to call this method that going to return new webdriber
	object every time , getdriver method is a part of DriverFactoryPattern , so need to a reference of DriverFactoryPattern
	first in order to call the getDriver method*/
    {
    return threadLocal.get(); /*getDriver is internally calling get method to return the driver object	
    */
    }
}
