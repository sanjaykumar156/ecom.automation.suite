package com.ecom.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ecom.baseclass.BaseTest;
import com.ecom.pages.LoginPage;

import utilities.ConfigReader;


public class LoginTest extends BaseTest{
	
	
	@Test(groups= {"smoke"})
	public void logintest() {
		
		LoginPage login = new LoginPage();
		login.loginbutton();
		logger.info("clicked on login button");
		login.emailtext(ConfigReader.getproperty("email"));
		logger.info("email entrered successfully");
		login.passwordtext(ConfigReader.getproperty("password"));
		logger.info("password entered successfully");
		login.signinbutton();
		logger.info("clicked on sigin button");
		try {
		    assertTrue(login.homepagevalidation());
		    logger.info("Homepage validation successful");
		} catch (AssertionError e) {
		    logger.error("Homepage validation FAILED!");
		    logger.error("Reason: " + e.getMessage());
		    throw e;
		}

		
	}

}
