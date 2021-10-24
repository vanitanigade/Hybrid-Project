package com.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.listeners.ListenerEx;
import com.pages.UsersPage;

@Listeners(ListenerEx.class)

public class DashboardPageTest extends BaseClass{
	
	public static UsersPage up;

	@Test(priority=4)
	public void verifyCourses() {
		ArrayList<String> expectedCourses = new ArrayList<String>();
		expectedCourses.add("Selenium");
		expectedCourses.add("Java / J2EE");
		expectedCourses.add("Python");
		expectedCourses.add("Php");
		Assert.assertEquals(LoginPageTest.dp.verifyCourses(), expectedCourses);
	}

	@Test(priority=5)
	public void usersLinkClick() {
		up = LoginPageTest.dp.clickUsersLink();
		Assert.assertEquals(LoginPageTest.driver.getTitle(), "JavaByKiran | User");
	}

}
