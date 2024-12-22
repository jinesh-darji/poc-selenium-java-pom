package com.ubix.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ubix.utilities.ExtentManager;
import com.ubix.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.mitm.CertificateAndKeySource;
import net.lightbody.bmp.mitm.KeyStoreFileCertificateSource;
import net.lightbody.bmp.mitm.keys.ECKeyGenerator;
import net.lightbody.bmp.mitm.manager.ImpersonatingMitmManager;
import net.lightbody.bmp.proxy.CaptureType;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static Properties testData = new Properties();
	public static FileInputStream fis;
	public static Logger log = LogManager.getLogger(TestBase.class);
	public static WebDriverWait wait;
	private static WebDriverWait waitForElement;
	public ExtentReports extentReport = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

//	public static BrowserMobProxy proxy;
//	public static List<String> failedAPIs;

	@BeforeSuite
	@Parameters({ "headless" })
	public void setUp(String headless) throws InterruptedException {

		// Initialize the config and OR Properties file
		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/com/ubix/properties/Config.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
				System.out.println("Config file loaded !!!");
			} catch (IOException e) {

				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/com/ubix/properties/OR.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
				System.out.println("OR file loaded !!!");
			} catch (IOException e) {

				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/com/ubix/properties/testData.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				testData.load(fis);
				log.debug("testData file loaded !!!");
				System.out.println("testData file loaded !!!");
			} catch (IOException e) {

				e.printStackTrace();
			}

			// Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
				browser = System.getenv("browser");
			} else {
				browser = config.getProperty("browser");
			}

			// Initialize the browsers
			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {
				boolean headlessMode = Boolean.parseBoolean(headless);

				if (headlessMode) {

					WebDriverManager.chromedriver().setup();

//					// Start the proxy
//					proxy = new BrowserMobProxyServer();
//					proxy.start(0);
//
//					// Configure MITM for HTTPS
//					proxy.setMitmManager(ImpersonatingMitmManager.builder().trustAllServers(true).build());
//
//					// Enable more detailed HAR capture
//					proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//
//					// Get the Selenium proxy object
//					Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//
					// Configure Chrome options
					ChromeOptions options = new ChromeOptions();
					options.setHeadless(true);
					options.addArguments("--headless", "--disable-gpu");
					options.addArguments("--no-sandbox");
					options.addArguments("--disable-dev-shm-usage");
					options.addArguments("--window-size=1920x1080");
					// options.setCapability("proxy", seleniumProxy);
					options.setAcceptInsecureCerts(true);
					options.addArguments("--ignore-certificate-errors");
					options.addArguments("--ignore-ssl-errors");

					// Create a new ChromeDriver with the proxy settings
					driver = new ChromeDriver(options);

					// failedAPIs = new ArrayList<>();
				} else {

					WebDriverManager.chromedriver().setup();

//					// Start the proxy
//					proxy = new BrowserMobProxyServer();
//					proxy.start(0);
//
//					// Configure MITM for HTTPS
//					proxy.setMitmManager(ImpersonatingMitmManager.builder().trustAllServers(true).build());
//
//					// Enable more detailed HAR capture
//					proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//
//					// Get the Selenium proxy object
//					Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

					// Configure Chrome options
					ChromeOptions options = new ChromeOptions();
//					options.setCapability("proxy", seleniumProxy);
					options.setAcceptInsecureCerts(true);
					options.addArguments("--ignore-certificate-errors");
					options.addArguments("--ignore-ssl-errors");

					// Create a new ChromeDriver with the proxy settings
					driver = new ChromeDriver(options);

					// failedAPIs = new ArrayList<>();
				}
			}

			// Enable HAR capture
//			proxy.newHar("test");

			// Initialize the Application URL
			driver.get(config.getProperty("testsiteurl"));

			log.info("Test site launched successfully!!! " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			log.info("The window maximize successfully!!!");
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 340);

		}
	}

	// For click on the particular element
	public void click(String locator) {
		// fluentWait(locator);
		// explicitWait(locator);
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}

		log.info("Clicking on an Element : " + locator);
		test.log(Status.INFO, "Clicking on : " + locator);

//		// Get the HAR data
//		Har har = proxy.getHar();
//
//		// Process and analyze the HAR data to find API calls
//		for (HarEntry entry : har.getLog().getEntries()) {
//			String url = entry.getRequest().getUrl();
//			int statusCode = entry.getResponse().getStatus();
//
//			if (url.contains("/api/") || url.contains("/service/")) {
//
//				if (statusCode >= 400) {
//				failedAPIs.add(url + " (Status Code: " + statusCode + ")");
//
//					test.fail(url + " (Status Code: " + statusCode + ")");
//					log.info(url + " (Status Code: " + statusCode + ")");
//				}
//			}
//		}
//
//		// Assert and warn about failed APIs
//		if (!failedAPIs.isEmpty()) {
//			String warningMessage = "The following APIs failed:\n" + String.join("\n", failedAPIs);
//			log.info("WARNING: " + warningMessage);
//			test.fail(warningMessage);
//		}

	}

	// For double click on the particular element
	static WebElement dblclk;

	public void doubleClick(String locator) {
		// fluentWait(locator);
		// explicitWait(locator);

		// instantiating actions class
		Actions act = new Actions(driver);

		// locate webElement to perform double click
		if (locator.endsWith("_CSS")) {
			dblclk = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dblclk = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dblclk = driver.findElement(By.id(OR.getProperty(locator)));
		}

		// double click the button
		act.doubleClick(dblclk).perform();

		log.info("Double click on : " + locator);
		test.log(Status.INFO, "Double click on : " + locator);

//		// Get the HAR data
//		// Har har = proxy.getHar();
//
//		// Process and analyze the HAR data to find API calls
//		for (HarEntry entry : har.getLog().getEntries()) {
//			String url = entry.getRequest().getUrl();
//			int statusCode = entry.getResponse().getStatus();
//
//			if (url.contains("/api/") || url.contains("/service/")) {
//
//				if (statusCode >= 400) {
//					failedAPIs.add(url + " (Status Code: " + statusCode + ")");
//					test.fail(url + " (Status Code: " + statusCode + ")");
//					log.info(url + " (Status Code: " + statusCode + ")");
//				}
//			}
//		}
//
//		// Assert and warn about failed APIs
//		if (!failedAPIs.isEmpty()) {
//			String warningMessage = "The following APIs failed:\n" + String.join("\n", failedAPIs);
//			log.info("WARNING: " + warningMessage);
//			test.fail(warningMessage);
//		}
	}

	// context click - right click
	static WebElement contextclk;

	public void contextClick(String locator) {
		// instantiating actions class
		Actions act = new Actions(driver);

		// locate webElement to perform double click
		if (locator.endsWith("_CSS")) {
			contextclk = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			contextclk = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			contextclk = driver.findElement(By.id(OR.getProperty(locator)));
		}

		// double click the button
		act.contextClick(contextclk).perform();

		log.info("Right click on : " + locator);
		test.log(Status.INFO, "Right click on : " + locator);
	}

	// For typing the text into the text field
	public void type(String locator, String value) {
		// fluentWait(locator);
		// explicitWait(locator);
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).clear();
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).clear();
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		log.info("Typing in an Element : " + locator + " entered value as : " + value);
		test.log(Status.INFO, "Typing in : " + locator + " entered value as " + value);

	}

	public void pressEnter(String locator) {
		// fluentWait(locator);
		// explicitWait(locator);
		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(Keys.ENTER);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(Keys.ENTER);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(Keys.ENTER);
		}

		log.info("Pressing Enter Key for " + locator + "element");
		test.log(Status.INFO, "Pressing Enter Key for " + locator + "element");

	}

	// Select value from the dropdown
	static WebElement dropdown;

	public void select(String locator, String value) {
		// fluentWait(locator);
		// explicitWait(locator);
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.info("Selecting from an element : " + locator + " value as : " + value);
		test.log(Status.INFO, "Selecting from dropdown : " + locator + " value as " + value);
	}

	// Select random value from the dropdown
	static WebElement dropdownRandom;

	public void selectRandom(String locator) {
		// fluentWait(locator);
		// explicitWait(locator);
		if (locator.endsWith("_CSS")) {
			dropdownRandom = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdownRandom = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdownRandom = driver.findElement(By.id(OR.getProperty(locator)));
		}

		// Using Select Class to fetch the count
		Select select = new Select(dropdown);
		List<WebElement> weblist = select.getOptions();

		// Taking the count of items
		int iCnt = weblist.size();

		// Using Random class to generate random values
		Random num = new Random();
		int iSelect = num.nextInt(iCnt);

		// Selecting value from DropDownList
		select.selectByIndex(iSelect);

		// Selected Value
		String finalValue = dropdownRandom.getAttribute("value");
		System.out.println(finalValue);

		test.log(Status.INFO, "Selecting from dropdown : " + locator + " value as " + "\"" + finalValue + "\"");
		log.info("Selecting from dropdown : " + locator + " value as " + "\"" + finalValue + "\"");

	}

	// For clear the text in the field
	public void clear(String locator) {
		// fluentWait(locator);
		// explicitWait(locator);
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).clear();
		}

		test.log(Status.INFO, "Clear the data of : " + locator);
		log.info("Clear the data of : " + locator);
	}

	// For drag and drop action
	static WebElement sourceElement;
	static WebElement targetElement;

	public void dragAndDrop(String source, String target) throws InterruptedException {
		Thread.sleep(4000);
		// instantiating actions class
		Actions act = new Actions(driver);
		// fluentWait(source);
		// WebElement on which drag and drop operation needs to be performed
		if (source.endsWith("_CSS")) {
			sourceElement = driver.findElement(By.cssSelector(OR.getProperty(source)));
		} else if (source.endsWith("_XPATH")) {
			sourceElement = driver.findElement(By.xpath(OR.getProperty(source)));
		} else if (source.endsWith("_ID")) {
			sourceElement = driver.findElement(By.id(OR.getProperty(source)));
		}
		// fluentWait(target);

		// WebElement to which the above object is dropped
		if (target.endsWith("_CSS")) {
			targetElement = driver.findElement(By.cssSelector(OR.getProperty(target)));
		} else if (source.endsWith("_XPATH")) {
			targetElement = driver.findElement(By.xpath(OR.getProperty(target)));
		} else if (source.endsWith("_ID")) {
			targetElement = driver.findElement(By.id(OR.getProperty(target)));
		}

		// Performing the drag and drop action
		act.dragAndDrop(sourceElement, targetElement).build().perform();

		log.info("Performed drag and drop action from: " + source + " to " + target);
		test.log(Status.INFO, "Performed drag and drop action from: " + source + " to " + target);
	}

	// For validate the particular element is displayed
	static boolean isdisplay;

	public boolean isDisplay(String locator) {
		// explicitWait(locator);
		try {
			if (locator.endsWith("_CSS")) {
				isdisplay = driver.findElement(By.cssSelector(OR.getProperty(locator))).isDisplayed();
			} else if (locator.endsWith("_XPATH")) {
				isdisplay = driver.findElement(By.xpath(OR.getProperty(locator))).isDisplayed();
			} else if (locator.endsWith("_ID")) {
				isdisplay = driver.findElement(By.id(OR.getProperty(locator))).isDisplayed();
			}

			return isdisplay;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// For validate the particular element is selected
	static boolean isselect;

	public boolean isSelect(String locator) {
		// explicitWait(locator);
		if (locator.endsWith("_CSS")) {
			isselect = driver.findElement(By.cssSelector(OR.getProperty(locator))).isSelected();
		} else if (locator.endsWith("_XPATH")) {
			isselect = driver.findElement(By.xpath(OR.getProperty(locator))).isSelected();
		} else if (locator.endsWith("_ID")) {
			isselect = driver.findElement(By.id(OR.getProperty(locator))).isSelected();
		}

		return isselect;
	}

	// For Explicit Wait - visibilityOfElementLocated
	public void explicitWait(String locator) {
		waitForElement = new WebDriverWait(driver, 5);
		if (locator.endsWith("_CSS")) {
			waitForElement
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty(locator))));
		} else if (locator.endsWith("_XPATH")) {
			waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(locator))));
		} else if (locator.endsWith("_ID")) {
			waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty(locator))));
		}
		test.log(Status.INFO, "Waiting for : " + locator);
		log.info("Waiting for : " + locator);
	}

	// For Explicit Wait - visibilityOfElementLocated
	public void fluentWait(String locator) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		waitForElement = new WebDriverWait(driver, 5);
		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty(locator))));
		} else if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty(locator))));
		} else if (locator.endsWith("_ID")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OR.getProperty(locator))));
		}
		test.log(Status.INFO, "Waiting for : " + locator);
		log.info("Waiting for : " + locator);
	}

	// For Explicit Wait - elementToBeClickable
	public void explicitWaitClickable(String locator) throws InterruptedException {

		if (locator.endsWith("_CSS")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(locator))));
		} else if (locator.endsWith("_XPATH")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(locator))));
		} else if (locator.endsWith("_ID")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(OR.getProperty(locator))));
		}
		test.log(Status.INFO, "Waiting for : " + locator);
		log.info("Waiting for : " + locator);
	}

	// Verify the element is present or not on the screen
	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Verify the actual result with expected result. -- Soft Assertion
	public void verifyEquals(String locator, String expected) throws IOException {

		// fluentWait(locator);
		// explicitWait(locator);
		try {
			if (locator.endsWith("_CSS")) {
				String msg = driver.findElement(By.cssSelector(OR.getProperty(locator))).getText();
				Assert.assertEquals(msg, expected);
			} else if (locator.endsWith("_XPATH")) {
				String msg = driver.findElement(By.xpath(OR.getProperty(locator))).getText();
				Assert.assertEquals(msg, expected);
			} else if (locator.endsWith("_ID")) {
				String msg = driver.findElement(By.id(OR.getProperty(locator))).getText();
				Assert.assertEquals(msg, expected);
			}
			test.log(Status.PASS, "Verifing : " + locator + " value as " + "\"" + expected + "\"");
			log.info("Verifing : " + locator + " value as " + "\"" + expected + "\"");

		} catch (Throwable t) {

			TestUtil.captureScreenshot();

			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report
			test.log(Status.FAIL, " Verification failed with exception : " + t.getMessage());
			// test.fail("Test Failed",
			// MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
		}
	}

	public static void verifyEqualsModified(String actualWP, String expectedScript) throws IOException {

		try {

			Assert.assertEquals(actualWP, expectedScript);

			test.log(Status.PASS, "Verification: Available value on webpage is " + "<b>" + actualWP + "</b>"
					+ " and we are expecting this value: " + "<b>" + expectedScript + "</b>");

		} catch (Throwable t) {
			test.log(Status.WARNING, "Verification failure : " + t.getMessage());
			System.out.println("Verification failure :- We are getting value from web page: " + actualWP
					+ "and we are getting this value from Scrip: " + expectedScript);
		}
	}

	// Verify the test is pass or not using AssertTrue
	public void verifyTrue(String locator, String description) throws IOException {
		// fluentWait(locator);
		// explicitWait(locator);
		try {
			if (locator.endsWith("_CSS")) {
				Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty(locator))), description);
			} else if (locator.endsWith("_XPATH")) {
				Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty(locator))), description);
			} else if (locator.endsWith("_ID")) {
				Assert.assertTrue(isElementPresent(By.id(OR.getProperty(locator))), description);
			}
			System.out.println("The verified of the " + locator + " is done successfully.");
			test.pass("The verified of the " + locator + " is done successfully.");
			Reporter.log("The verified of the " + locator + " is done successfully.");
			log.info("The verified of the " + locator + " is done successfully.");

		} catch (Throwable t) {

			TestUtil.captureScreenshot();

			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report
			test.fail(" Verification failed with exception : " + t.getMessage());
			// test.fail(
			// MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
		}
	}

	public String getAttribute(String locator, String attribute) {
		// fluentWait(locator);
		// explicitWait(locator);
		// Get the value of an attribute
		String value = driver.findElement(By.xpath(OR.getProperty(locator))).getAttribute(attribute);

		return value;
	}

	public void scrollToElement(String locator) {
		// fluentWait(locator);
		WebElement element = driver.findElement(By.xpath(OR.getProperty(locator)));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(arguments[0], arguments[1]);", element.getLocation().getX(),
				element.getLocation().getY());

		test.info("Scrolling to this " + locator + " element");
	}

	public void selectOptionFromDropDown(int selectValue, String dropDown, String dropDownOptionList)

			throws IOException, InterruptedException {
		Random randomDropDownOption = new Random();
		// explicitWait(dropDown);
		// fluentWait(dropDown);
		click(dropDown);

		List<WebElement> dropdownOptionsSize = driver.findElements(By.xpath(OR.getProperty(dropDownOptionList)));

		test.log(Status.INFO,
				"Available Option size is " + dropdownOptionsSize.size() + " for the dropdown: " + dropDown);

		if (dropdownOptionsSize.size() > 0) {
			if (dropdownOptionsSize.size() > selectValue) {

				test.log(Status.INFO, "Selecting the " + selectValue + " option from the dropdown: " + dropDown);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(arguments[0], arguments[1]);",
						dropdownOptionsSize.get(selectValue).getLocation().getX(),
						dropdownOptionsSize.get(selectValue).getLocation().getY());

				test.info("Scrolling to this " + dropdownOptionsSize.get(selectValue) + " element");
				Thread.sleep(3000);
				dropdownOptionsSize.get(selectValue).click();
			}
		} else if (dropdownOptionsSize.size() > 0) {

			test.log(Status.INFO, "Selecting the random option from the dropdown: " + dropDown);
			int randomOption = randomDropDownOption.nextInt(dropdownOptionsSize.size());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(arguments[0], arguments[1]);",
					dropdownOptionsSize.get(randomOption).getLocation().getX(),
					dropdownOptionsSize.get(randomOption).getLocation().getY());

			test.info("Scrolling to this " + dropdownOptionsSize.get(selectValue) + " element");
			Thread.sleep(3000);
			dropdownOptionsSize.get(randomOption).click();

		} else {
			test.log(Status.WARNING, "The dropdown is empty.");
			log.info("The dropdown is empty.");
		}

	}

	public String currentDateTime() {
		// type name of the workspace
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			// driver.quit();
		}

		log.info("Test execution completed!!!");
		System.out.println("Test execution completed!!!");
		/*
		 * if (proxy != null) { proxy.stop(); }
		 */
	}
}
