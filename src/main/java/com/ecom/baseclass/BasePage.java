package com.ecom.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		this.action=new Actions(driver);
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public void sendkeys(By locator, String text) {
	WebElement keys=driver.findElement(locator);
	keys.clear();
	keys.sendKeys(text);
	}
	public String gettext(By locator) {
	String text=driver.findElement(locator).getText();
	return text;
	}
	public void hoveron(By locator) {
		WebElement element=driver.findElement(locator);
		action.moveToElement(element).build().perform();
	}
	public boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
