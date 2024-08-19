package com.venkat.testcases;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.venkat.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static Logger logger;
	ReadConfig rc;
	public String url;

	@Parameters("browser")
	@BeforeTest
	public void setup(String br) {
		logger = Logger.getLogger("Automation");
		rc = new ReadConfig();
		if (br.isEmpty()) {
			br = rc.getBrowser();
		}
		url = rc.getBaseUrl();
		PropertyConfigurator.configure("log4j.properties");
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome driver instance is created");
		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox driver instance is created");
		} else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge driver instance is created");
		} else {
			logger.info("invalid browser passed");
		}

		driver.manage().window().maximize();
		logger.info("Browser window got maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Implicitly wait is set to 10 seconds");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		logger.info("Pageload time out wait is set to 10 seconds");
		driver.get(url);
		logger.info("Url is opened");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		logger.info("Browser closed");
	}

}
