package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utility.ExcelUtility;

public class LoginPageTest extends BaseClass{
	
	static WebDriver driver = null;
	LoginPage lp = null;
	public static DashboardPage dp;
	
	@BeforeSuite
	public void setup() {
		driver = initialization();
		reportInit();
		lp = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		String Uname = ExcelUtility.getCellData("C:\\Users\\61435\\Documents\\Selenium\\loginData2.xls", "Sheet1", 3, 2);
		String Pass = ExcelUtility.getCellData("C:\\Users\\61435\\Documents\\Selenium\\loginData2.xls", "Sheet1", 3, 3);
		lp.invalidLogin(Uname, Pass);
	}	
	
	@Test(priority=3)
	public void validLoginTest() {
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
