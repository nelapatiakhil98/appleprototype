package com.tririga.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tririga.utility.BrowserFactory;
import com.tririga.utility.ConfigDataProvider;
import com.tririga.utility.ExcelDataProvider;
import com.tririga.utility.Helper;


public class BaseClass {
	
	public  WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentTest logger;
	public ExtentReports report;
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		   ExtentHtmlReporter extent=new ExtentHtmlReporter("./Reports/testcase.html");
		  report = new ExtentReports();
		  report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.launchBrowser(driver, config.getBrowser(), config.getURL());
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
				
					logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
				
			 
		}
		report.flush();
	}
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);
	}

}
