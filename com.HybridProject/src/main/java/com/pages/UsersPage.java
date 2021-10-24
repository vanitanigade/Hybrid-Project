package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

	WebDriver driver;
	
	@FindBy(xpath="//tr")
	List<WebElement> tableRows;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void usersTable() {
		for(WebElement row: tableRows) {
			System.out.println(row.getText());
		}
	}
	
	public int verifyRows() {
		return tableRows.size();
	}

}
