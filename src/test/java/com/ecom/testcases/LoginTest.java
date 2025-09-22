package com.ecom.testcases;

import org.testng.annotations.Test;

import com.ecom.baseclass.BaseTest;
import com.ecom.pages.LoginPage;

import junit.framework.Assert;

public class LoginTest extends BaseTest{
	
	
	@Test(groups= {"smoke"})
	public void logintest() {
		
		LoginPage login = new LoginPage(driver.get());
		login.loginbutton();
		login.emailtext();
		login.passwordtext();
		login.signinbutton();
		Assert.assertTrue(login.homepagevalidation());
		
	}

}
