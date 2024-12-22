package com.ubix.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.ubix.base.TestBase;
import com.ubix.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	String testName;
	// ANSI escape codes for colored output
	private static final String RESET = "\u001B[0m";
	private static final String RED_BOLD = "\u001B[1;31m";
	private static final String GREEN_BOLD = "\u001B[1;32m";
	private static final String BLUE_BOLD = "\u001B[1;34m";

	public void onTestStart(ITestResult result) {

		test = extentReport.createTest(result.getName().toUpperCase()).assignAuthor("Jinesh").assignCategory("Smoke")
				.assignDevice("Chrome");
		testName = result.getMethod().getMethodName().toUpperCase();
		test.log(Status.INFO, " ************ " + testName + " STARTED ************" );
		log.info(BLUE_BOLD + " ************ " + testName + " STARTED ************" + RESET);
	}

	//
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {

			test.fail(result.getName().toUpperCase() + "Failed with exception:" + result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
			test.log(Status.FAIL, " ************ " + testName + " FAILED ************");
			log.info(RED_BOLD + "************ " + testName + " FAILED ************" + RED_BOLD);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log("Capturing SS");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");

		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");

		extentReport.flush();

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getName().toUpperCase() + " Skipped the test cases");
		extentReport.flush();

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.INFO, " ************ " + testName + " FINISHED SUCCESSFULLY ************");
		log.info(GREEN_BOLD + "************ " + testName + " FINISHED SUCCESSFULLY ************" + RESET);
		extentReport.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ISuite arg0) {

	}

	public void onStart(ISuite arg0) {

	}

	public void onFinish(ITestContext context) {

	}

}