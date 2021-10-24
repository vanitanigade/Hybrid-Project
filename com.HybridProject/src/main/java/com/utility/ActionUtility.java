package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

public class ActionUtility extends BaseClass{
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		element.click();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	
	public void moveAndClickElement(WebElement element) {
		Actions action = new Actions(driver); //Class  Action-> is Interface
		action.moveToElement(element).click().build().perform();
	}
	
	public WebElement getElement(String locType, String locValue) {
		
		if(locType.equals("xpath"))
			return driver.findElement(By.xpath(locValue));
		if(locType.equals("id"))
			return driver.findElement(By.id(locValue));
		
		return null;
	}
	
}
