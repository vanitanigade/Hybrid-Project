package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class UsersPageTest extends BaseClass{
	
	@Test(priority=6)
	public void verifyTableRows() {
		Assert.assertEquals(DashboardPageTest.up.verifyRows(), 5);
	}

}
