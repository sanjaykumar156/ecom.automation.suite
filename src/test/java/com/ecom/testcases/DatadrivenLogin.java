package com.ecom.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ecom.baseclass.BaseTest;
import com.ecom.pages.LoginPage;
import com.ecom.pages.RegistrationPage;

import utilities.DataDriven;

public class DatadrivenLogin extends BaseTest {
	
	
	@Test(dataProvider ="logindata", dataProviderClass=DataDriven.class)
	public void DatadrivenLoginTest(String email, String Password) {
		
		LoginPage login = new LoginPage();
		login.loginbutton();
		login.emailtext(email);
		login.passwordtext(Password);
		login.signinbutton();
		assertTrue(login.homepagevalidation());
	}
		
	}


