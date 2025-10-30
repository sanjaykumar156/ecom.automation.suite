package com.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecom.baseclass.BasePage;
import com.ecom.baseclass.BaseTest;

import utilities.ConfigReader;

public class LoginPage extends BasePage{

	public LoginPage() {
		super(BaseTest.getdriver());
	}
	private By Loginbtn=By.xpath("//a[@class='ico-login']");
	private By Emailtext=By.id("Email");
	private By passwordtxt=By.id("Password");
	private By login=By.xpath("//button[@class='button-1 login-button']");
	private By textvalidate= By.xpath("//a[@class='ico-account']");
	
	
	
	public void loginbutton() {
		click(Loginbtn);
	}
	public void emailtext() {
		sendkeys(Emailtext,ConfigReader.getproperty("loginmail"));
	}
	public void passwordtext() {
		sendkeys(passwordtxt,ConfigReader.getproperty("loginpassword"));
	}
	public void signinbutton() {
		click(login);
	}
	public boolean homepagevalidation() {
		return isDisplayed(textvalidate);
		
	}

}
