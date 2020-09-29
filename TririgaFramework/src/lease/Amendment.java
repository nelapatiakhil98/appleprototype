package lease;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Amendment {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "/Users/ne20084802/Downloads/Webdrivers/chromedriver");
		WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://tririga-uat.apple.com/");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"iframeWrapper\"]/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginMain\"]")));
		driver.findElement(By.id("USERNAME")).sendKeys("973806661");
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
		driver.findElement(By.xpath("//*[text()='Real Estate Leases']")).click();
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='data-auto-parent-content-frame']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='objectsFrame']")));
		
		driver.findElement(By.xpath("//*[text()='Add']")).click();
		Thread.sleep(10000);
		Set<String> AllWindows=driver.getWindowHandles();
		for(String child:AllWindows)
		{
			if(!child.equalsIgnoreCase(parentwindow))
			driver.switchTo().window(child);			
		}
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);
		driver.quit();
		

	}

}
