package com.listeners;

import org.testng.ITestContext;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerEx extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		etest=report.createTest(result.getName());
		log.info("Test case started with name: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test case succeed with name: " + result.getName());
		etest.log(Status.PASS, "Test case passed successfully");
	}

	public void onTestFailure(ITestResult result) {
		log.info("Test case failed with name: " + result.getName());
		log.info(result.getThrowable());
		etest.log(Status.FAIL, "Test case failed");
		etest.log(Status.FAIL, result.getThrowable());
		String path = takeScreenshot(result.getName());
		etest.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test case skipped with name: " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		log.info("Test suite is started");
	}

	public void onFinish(ITestContext context) {
		log.info("Test suite is finished");
		report.flush(); //after flush, all test case results get stored into the report.
	}

}
