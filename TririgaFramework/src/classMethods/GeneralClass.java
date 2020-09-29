package classMethods;

import org.openqa.selenium.By;

import space.GeneralFunctionality;

public class GeneralClass extends GeneralFunctionality{

	
		
		public static void isDisplayed(String name) throws InterruptedException
		{
			if(driver.findElement(By.xpath("//a[text()='"+name+"']")).getText().contentEquals(name))
			{
				System.out.println(name+" is diplayed");
				Thread.sleep(5000);
			}	
			
		}
		public static void goTo(String name1,String name2,String name3) throws InterruptedException
		{
			driver.findElement(By.xpath("//a[text()='"+name1+"']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@aria-label='"+name2+" dropdown menu']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[text()='"+name3+"']")).click();
			Thread.sleep(5000);
			
		}
		public static void searchFor(String name,String value) throws InterruptedException
		{
			driver.findElement(By.xpath("//input[@title='"+name+" (Contains)']")).sendKeys(value);
			Thread.sleep(5000);		
		}
		public static void clickOn(String name) throws InterruptedException
		{
			driver.findElement(By.xpath("//*[text()='"+name+"']")).click();
			Thread.sleep(5000);		
		}
		public static void select(int value) throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id='queryResultRow_"+value+"']/td[3]/span/a")).click();
			Thread.sleep(5000);		
		}
		public static void checkActivation() throws InterruptedException
		{
			if(driver.findElement(By.xpath("//*[text()='Revise']")).isDisplayed())
				driver.findElement(By.xpath("//*[text()='Revise']")).click();
			Thread.sleep(5000);
		}

	}


