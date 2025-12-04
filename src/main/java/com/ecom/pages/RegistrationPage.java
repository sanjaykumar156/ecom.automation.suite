package com.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecom.baseclass.BasePage;
import com.ecom.baseclass.BaseTest;

import utilities.ConfigReader;

public class RegistrationPage extends BasePage {

	public RegistrationPage() {
		super(BaseTest.getdriver());
	
	}
	private By registerbtn=By.xpath("//a[text()='Register']");
	private By genderbtn=By.xpath("//label[text()='Male']");
	private By firstname=By.id("FirstName");
	private By lastname=By.id("LastName");
	private By email=By.id("Email");
	private By company=By.id("Company");
	private By password=By.id("Password");
	private By retypepassword=By.id("ConfirmPassword"); 
	private By singnup =By.id("register-button");
	private By textcheck =By.xpath("//div[@class='result']");
	
	
	public void registerbutton() {
		if(
		isDisplayed(registerbtn)) {
			waitforelementclickable(registerbtn);
			click(registerbtn);
			
		}
	}
	public void genderbutton() {
		click(genderbtn);
	}
	public void firstname() {
		sendkeys(firstname, ConfigReader.getproperty("firstname"));
	}
	public void lastname() {
		sendkeys(lastname, ConfigReader.getproperty("lastname"));
		applyBorder(lastname, "red");
	}
	public void email() {
		sendkeys(email, getRandomEmail());
	}
	public void comapanyname() {
		sendkeys(company, ConfigReader.getproperty("company"));
	}
	public void password() {
		sendkeys(password, ConfigReader.getproperty("password"));
	}
	public void cnfrmpassword() {
		sendkeys(retypepassword, ConfigReader.getproperty("confrmpassword"));
	}
	public void signupbtn() {
		click(singnup);
	}
	public boolean validatetext() {
		return isDisplayed(textcheck);		
	}
}

