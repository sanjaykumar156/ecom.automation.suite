package com.ecom.testcases;

import org.testng.annotations.Test;

import com.ecom.baseclass.BaseTest;
import com.ecom.pages.RegistrationPage;

import junit.framework.Assert;

public class RegistrationTest extends BaseTest{
	
	@Test(groups= {"smoke"})
	public void registrationtest() {
		
		RegistrationPage registration= new RegistrationPage(driver.get());
		registration.registerbutton();
		registration.genderbutton();
		registration.firstname();
		registration.lastname();
		registration.email();
		registration.comapanyname();
		registration.password();
		registration.cnfrmpassword();
		registration.signupbtn();
		Assert.assertTrue(registration.validatetext());
		System.out.println("registration succesfull");
		
		
	}

}
