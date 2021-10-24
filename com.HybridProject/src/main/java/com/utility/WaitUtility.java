package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class WaitUtility extends BaseClass{
	
	//1. Why we need utility --> to apply waits
	//2. what are inputs --> webElements
	//3. what are outputs --> null
	
	public void explicitWait(WebElement element, long timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	
	
}
