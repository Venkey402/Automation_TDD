package com.venkat.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") +"\\Configuration\\Global.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro = new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	public String getBaseUrl()
	{
		return pro.getProperty("url");
	}

}
