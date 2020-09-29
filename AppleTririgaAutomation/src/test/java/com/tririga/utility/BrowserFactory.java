package com.tririga.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	
	
	public static WebDriver launchBrowser(WebDriver driver,String browsername,String url)
	{
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("safari"))
		{
			driver=new SafariDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("we do not support this driver");
		}
		driver.manage().window().maximize();
		
		driver.get(url);
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);	
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
