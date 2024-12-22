package com.ubix.testcases.signin;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ubix.base.TestBase;
import com.ubix.pages.dashboard.DashboardPage;
import com.ubix.pages.modelSpace.AddSolutionPage;
import com.ubix.pages.modelSpace.AddSolutionSpaceAppBuilderPage;
import com.ubix.pages.modelSpace.AddWorkSpacePage;
import com.ubix.pages.modelSpace.DatasetPage;
import com.ubix.pages.modelSpace.WorkSpaceListPage;
import com.ubix.pages.modelSpace.WorkSpaceSchemaPage;
import com.ubix.pages.modelSpaceLibrary.CreateModelSpaceLibraryPage;
import com.ubix.pages.modelSpaceLibrary.ModelSpaceLibraryListPage;
import com.ubix.pages.signin.SigninPage;
import com.ubix.utilities.TestUtil;

public class SigninTest extends TestBase {
	SigninPage signin;

	@BeforeMethod
	public void pageInit() {
		signin = new SigninPage();
	}

	@Test()
	public void signinTest() throws InterruptedException, IOException {

		// SigninPage 
		signin = new SigninPage();

		// enter the email address
		signin.enterEmail(testData.getProperty("signinTest_email"));

		// enter the password
		signin.enterPassword(testData.getProperty("signinTest_password"));

		// click on the signin button
		signin.clickSubmit();

		// wait for the element
		Thread.sleep(3000);

		// validate the dashboard screen
		verifyTrue("dd_moduleNavigator_CSS", "The module navigator dropdown is not displayed.");

	}
}
