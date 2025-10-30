package com.ecom.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;
	protected JavascriptExecutor js;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		this.action=new Actions(driver);
		this.js=(JavascriptExecutor) driver;
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
	public void mouseaction(By locator, String actionType) {
		WebElement acc=driver.findElement(locator);
		
		switch(actionType.toLowerCase()) {
		case "hover":
			action.moveToElement(acc).perform();
			break;
		case "doubleclick":
			action.doubleClick(acc).perform();
			break;
		case "contextclick":
			action.contextClick(acc).perform();
			break;
		case "click":
			action.click(acc);
			break;
		default:
			logger.error("invalid mouse action tepe!");
		}
		
	}
	
	public void waitforelementclickable(By element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitforelementtobeVisiable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void elementaction(By locator) {
		String script="arguments[0].scrollIntoView(true)";
		js.executeScript(script, locator);
		logger.info("scrolled into view"+locator);
		
	}
	
	public void applyBorder(By locator,String colour) {
		 WebElement element = driver.findElement(locator); 
		String ele="arguments[0].style.border='3px solid"+colour+"!important;'"; 
		js.executeScript(ele, element);
		logger.info("applied the border with colour- "+colour+" to element" +locator);
		
	}

}
