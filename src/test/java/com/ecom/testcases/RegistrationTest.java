package com.ecom.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ecom.baseclass.BaseTest;
import com.ecom.pages.RegistrationPage;



public class RegistrationTest extends BaseTest{
	
	@Test(groups= {"smoke"})
	public void registrationtest() {
		
		RegistrationPage registration= new RegistrationPage();
		registration.registerbutton();
		registration.genderbutton();
		registration.firstname();
		registration.lastname();
		registration.email();
		registration.comapanyname();
		registration.password();
		registration.cnfrmpassword();
		registration.signupbtn();
		assertTrue(registration.validatetext());
		logger.info("registration successfull");
		staticwait();
		
		
	}

}
