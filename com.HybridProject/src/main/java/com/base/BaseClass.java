package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtility;
import com.utility.WaitUtility;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(BaseClass.class);
	public static ExtentReports report;
	public static ExtentTest etest;
	public static ExtentSparkReporter spark;
		
	public static PropertiesUtility pu = null;
	public static WaitUtility wu = null;
	
	//if user enters browser name as IE, edge --> code is not satisfied
	public static WebDriver initialization() {
		pu = new PropertiesUtility();
		wu = new WaitUtility();
		
		log.info("initializing browser");//file
		if(pu.readProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pu.readProperty("chromeDriverFilePath"));
			driver = new ChromeDriver();
		}
		
		if(pu.readProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", pu.readProperty("geckoDriverFilePath"));
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(pu.readProperty("url"));
		log.info("applying common waits over a browser");
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pu.readProperty("pageload")), TimeUnit.SECONDS);//readPropert return type is String
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(pu.readProperty("pageload")), TimeUnit.SECONDS);		//OR
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public void reportInit() {
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/Reports/ExtentReport.html");
		report = new ExtentReports();
		report.setSystemInfo("Host Name", "Vanita-Emerson");
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("Environment", "Test Automation");
		report.attachReporter(spark);
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot ts = (TakesScreenshot)driver; //interface
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/"+name+".jpg";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}

}
