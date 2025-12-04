package com.ecom.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ecom.baseclass.BasePage;
import com.ecom.baseclass.BaseTest;
import com.ecom.pages.RegistrationPage;



public class RegistrationTest extends BaseTest{
	
	@Test(groups= {"smoke"})
	public void registrationtest() throws InterruptedException {
		
		RegistrationPage registration= new RegistrationPage();
		registration.genderbutton();
		logger.info("clicked on gender button");;
		registration.firstname();
		logger.info("entered first name");
		registration.lastname();
		logger.info("entered lastname");
		registration.email();
		logger.info("entered email");
		registration.comapanyname();
		logger.info("Entered company name");
		registration.password();
		logger.info("entered password");
		registration.cnfrmpassword();
		logger.info("entered conform password");
		registration.signupbtn();
		logger.info("clicked on signup button");
		try {
		assertTrue(registration.validatetext());
		logger.info("registration successfull");
	} catch (AssertionError e) {
	    logger.error("Registration FAILED!");
	    logger.error("Reason: " + e.getMessage());
	    throw e;
	}
		
	}

}
