package com.ecom.baseclass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ecom.pages.LoggerManager;

import utilities.ConfigReader;

public class BaseTest {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	protected static Logger logger= LoggerManager.getlogger(BaseTest.class);
	@BeforeClass
	public void setup() {
		 if(driver.get()==null) {
			 String browser= ConfigReader.getproperty("browser");
			 logger.info("conig.properties file loadded successfully");
			 if(browser.equals("chrome")) {
				 ChromeOptions options= new ChromeOptions();	
//				 options.addArguments("--headless");
				 options.addArguments("--disable-gpu");
				 options.addArguments("--disable-notifications");
				 options.addArguments("--no-sandbox");
				 options.addArguments("--disable-dev-shm-usage");
				 driver.set(new ChromeDriver(options));
				 logger.info(browser+" driver instance created");
			 }else if(browser.equals("edge")) {
				 driver.set(new EdgeDriver());
				 logger.info(browser+" driver instance created");
			 }else {
				 throw new IllegalArgumentException("no browser matching" +browser);  
			 }
		 }

		 if(driver.get()!=null) {
			 driver.get().manage().window().maximize();
			 logger.info("window maximized");
			 driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get().get(ConfigReader.getproperty("baseurl"));
			 driver.get().manage().deleteAllCookies();
			 driver.get().navigate().refresh();
			 logger.info("opens the App URL");
	}
		
	 }
	public static WebDriver getdriver() {
		return driver.get();
	}

	 @AfterClass
	 public void teardown() {
		 driver.get().quit();
		 logger.info("webdriver closed successfully");
	 }
	 
	 //satatic wait to pause
	 public void staticwait() {
		 LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
	 }
	
}
