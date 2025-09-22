package com.ecom.baseclass;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class BaseTest {
	protected static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver> ();
	public static String browserName;
    public static String browserVersion;
    public static String platforminfo;
	 @Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) {
		 if(driver.get()==null) {
			 if(browser.equals("chrome")) {
				 driver.set(new ChromeDriver());
			 }else if(browser.equals("edge")) {
				 driver.set(new EdgeDriver());
			 }else {
				 throw new IllegalArgumentException("no browser matching" +browser);
			 }
			 Capabilities caps = ((RemoteWebDriver) driver.get()).getCapabilities();
			 
		 }

		 if(driver.get()!=null) {
			 driver.get().manage().window().maximize();
			 driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get().get(ConfigReader.getproperty("baseurl"));
			 Capabilities caps = ((RemoteWebDriver) driver.get()).getCapabilities();
		      browserName = caps.getBrowserName();
		      browserVersion = caps.getBrowserVersion();
		      platforminfo=caps.getPlatformName().toString();
	}
	 }
	 @AfterClass
	 public void teardown() {
		 driver.get().quit();
	 }
	
}
