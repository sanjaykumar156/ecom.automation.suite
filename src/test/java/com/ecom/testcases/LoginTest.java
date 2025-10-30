package com.ecom.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ecom.baseclass.BaseTest;
import com.ecom.pages.LoginPage;


public class LoginTest extends BaseTest{
	
	
	@Test(groups= {"smoke"})
	public void logintest() {
		
		LoginPage login = new LoginPage();
		login.loginbutton();
		login.emailtext();
		login.passwordtext();
		login.signinbutton();
		assertTrue(login.homepagevalidation());
		
	}

}
