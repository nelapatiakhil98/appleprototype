package com.tririga.space;

import org.testng.annotations.Test;

import com.tririga.pages.BaseClass;
import com.tririga.pages.LoginPage;

public class Testcase extends BaseClass{
	
	@Test(priority = 1)
	public void testcase1() throws InterruptedException
	{
		logger=report
				.createTest("LoginTest functionality");
		LoginPage l=new LoginPage(driver);
		logger.info("starting application");
		l.login(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		logger.pass("Login Sucess");
		
	}
	

}
