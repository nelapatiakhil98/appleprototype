package com.tririga.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	//Screenshot ,alerts,frames,windows,sync issue,Javascript executor
	
	
 public static String captureScreenshot(WebDriver driver)
 {
	 String path=System.getProperty("user.dir")+"/Screenshots/Tririga_"+getCurrentDateTime()+".png";
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 try {
		FileHandler.copy(src, new File(path));
		System.out.println("screenshot captured");
	} catch (IOException e) {
	System.out.println("Unable to capture screenshot >>"+e.getMessage());
	}
	 return path;
 }
 
 
 public static String getCurrentDateTime()
 {
	 DateFormat  customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	 Date currentDate=new Date();
	 return customFormat.format(currentDate);
	  
 }
}
