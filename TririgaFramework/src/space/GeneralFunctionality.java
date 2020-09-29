package space;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import classMethods.GeneralClass;


public class GeneralFunctionality {
	protected static WebDriver driver;
public static void main(String[] args) throws InterruptedException  {
		
	
	//driver Initialization 
	
		//System.setProperty("webdriver.chrome.driver", "/Users/ne20084802/Downloads/Webdrivers/chromedriver");
	    driver=new SafariDriver();

    //maximizing the screen
	    
		driver.manage().window().maximize();
		
	//Launching URL
		
		driver.get("https://tririga-uat.apple.com/");
		driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		
		
	//title checking
		
		System.out.println(driver.getTitle());
		
   //login functionality 
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='IBM TRIRIGA Index Page']"))); 
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginMain\"]")));
		driver.findElement(By.id("USERNAME")).sendKeys("1947044843");
		driver.findElement(By.id("PASSWORD")).sendKeys("password");
		driver.findElement(By.xpath("//input[@class='loginButton']")).click();
		Thread.sleep(15000);
		if(!(driver.getTitle().contentEquals("Home - IBM TRIRIGA")))
		{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"iframeWrapper\"]/iframe")));
		Thread.sleep(5000);
		driver.findElement(By.id("msgButtonAffirm")).click();
		Thread.sleep(10000);
		}
		Thread.sleep(10000);
		String parentwindow=driver.getWindowHandle();
		
	// Menu Verifications
		 Thread.sleep(5000);
		GeneralClass.isDisplayed("Space");
		 driver.findElement(By.xpath("//a[text()='Space']")).click();
		 Thread.sleep(5000);
		 GeneralClass.isDisplayed("Plan Space");
		 GeneralClass.isDisplayed("Find Space");
		 GeneralClass.isDisplayed("Assess Space");
		 GeneralClass.isDisplayed("Manage Space");
		 GeneralClass.isDisplayed("Plan Moves");
		 GeneralClass.isDisplayed("Manage Moves");
		 GeneralClass. isDisplayed("Space Set Up");
		 
    // Navigating to spaces
		 
		 GeneralClass.goTo("Portfolio","Locations","Spaces");		 
		 Thread.sleep(5000);
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='data-auto-parent-content-frame']")));
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='objectsFrame']")));
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='listFrame']")));
		 
	// Filtering the data with given values
		 
		 GeneralClass.searchFor("Space Class","workstation");
		 GeneralClass.clickOn("Apply Filters");
		 GeneralClass.select(0);
		 Set<String> AllWindows=driver.getWindowHandles();
			for(String child:AllWindows)
			{
				if(!child.equalsIgnoreCase(parentwindow))
				driver.switchTo().window(child);			
			}
			System.out.println(driver.getTitle());
		 Thread.sleep(10000);
		 
	// Click on revise and check activation status
		 
		 GeneralClass.checkActivation();
			 
			 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentFrame']")));
			 driver.findElement(By.xpath("//*[@id='attr_seq_1083']")).clear();
			 driver.findElement(By.xpath("//*[@id='attr_seq_1083']")).sendKeys("auto test");
			 
	// click on activation	
			 
			 driver.findElement(By.xpath("//*[@id='Activate']/span")).click();
		
	// close the browser	
			 
			 driver.quit();
}


}
