package com.ubix.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (Objects.isNull(extent)) {

			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_yyyy");
			String formattedDateTime = currentDateTime.format(formatter);

			ExtentSparkReporter spark = new ExtentSparkReporter(
					"AutomationReport/Automation_Report_" + formattedDateTime + ".html").viewConfigurer().viewOrder()
					.as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY }).apply();
			final File config = new File("ReportsConfig.xml");

			extent = new ExtentReports();

			extent.attachReporter(spark);

			try {

				spark.loadXMLConfig(config);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return extent;
	}

	public static void flushReport() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
	}

}