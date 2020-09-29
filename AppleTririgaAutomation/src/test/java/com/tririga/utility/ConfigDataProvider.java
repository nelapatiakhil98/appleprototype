package com.tririga.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	
	
	Properties pro;
	public ConfigDataProvider() {
		
		
		File src=new File("./Config/local.properties");
		try {
			FileInputStream  fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file >>"+e.getMessage());
		}
		
		
	}
//	public String getDataFromConfig() {
//		return pro.getProperty(ke);
//		
//	}
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	public String getURL()
	{
		return pro.getProperty("url");
	}

}
