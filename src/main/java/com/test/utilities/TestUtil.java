package com.ubix.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.ubix.base.TestBase;


public class TestUtil extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;

	public static String captureScreenshot() throws IOException {

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File ssFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\UBIX\\" + screenshotName;

		FileUtils.copyFile(ssFile, new File(screenshotPath));
		return screenshotPath;		

	}

	


}