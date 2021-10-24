package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement passwd;
	
	@FindBy(xpath="//button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void invalidLogin(String uName, String password) {
		uname.sendKeys(uName);
		passwd.sendKeys(password);
		loginButton.click();
	}
	
	public DashboardPage validLogin() {
		uname.clear();
		passwd.clear();
		uname.sendKeys("kiran@gmail.com");
		passwd.sendKeys("123456");
		loginButton.click();
		return new DashboardPage(driver);
	}
	

}
