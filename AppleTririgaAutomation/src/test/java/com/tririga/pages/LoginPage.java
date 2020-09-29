package com.tririga.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{	
		this.driver=driver;		
	}
	
	public void login(String username,String password) throws InterruptedException
	{
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='IBM TRIRIGA Index Page']"))); 
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginMain\"]")));
		driver.findElement(By.id("USERNAME")).sendKeys("2320220342");
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
	
		
	}

}
