/*
package AndroidUI.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.tsystems.testfactory.constants.FilePaths;
import org.tsystems.testfactory.utils.DatabaseConnection;
import org.tsystems.testfactory.utils.PropertyFileReader;
import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PredefinedMethods {

	static WebDriver driver;
	public static WebDriverWait wait;
	static Logger log = Logger.getLogger(PredefinedMethods.class);
	static Properties userConfig;

	*/
/**
	 * Use this method to get the BrowserName set by the User in the
	 * config.properties file.
	 *
	 * @return A string representation of the BrowserName.
	 * @throws IOException
	 *
	 *//*


	public static String getCurrentDate(String format) {
		Date objDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(objDate);
	}

	private String browserName() throws IOException {
		userConfig = PropertyFileReader.propertyfileRead(FilePaths.userConfig);
		return userConfig.getProperty("Browser");
	}

	public static String getUserProperty(String propertyKey) throws IOException {
		return PropertyFileReader.propertyfileRead(FilePaths.userConfig).getProperty(propertyKey);
	}

	*/
/**
	 * Use this method to get the Test URL set by the User in the
	 * config.properties file.
	 *
	 * @return A string representation of the Test URL.
	 * @throws IOException
	 *
	 *//*

	private String getTestURL() throws IOException {
		if (userConfig == null) {
			userConfig = PropertyFileReader.propertyfileRead(FilePaths.userConfig);
			return userConfig.getProperty("TestURL");
		} else {
			return userConfig.getProperty("TestURL");
		}
	}

	*/
/**
	 * Use this method to get the Elastic Search DB URL set by the User in the
	 * config.properties file.
	 *
	 * @return A string representation of the Test URL.
	 * @throws IOException
	 *
	 *//*

	public static String getElasticURL() throws IOException {
		if (userConfig == null) {
			userConfig = PropertyFileReader.propertyfileRead(FilePaths.userConfig);
			return userConfig.getProperty("ES_URL");
		} else {
			return userConfig.getProperty("ES_URL");
		}
	}

	*/
/**
	 * Use this method to capture the screenshot of the browser window and save
	 * the .png file in the Screenshots folder. FileName Format : << >>
	 *
	 * @param result
	 *            The object containing the result of the test.
	 * @return A string representation of the file path to the captured
	 *         screenshot(.png) file
	 *
	 *         Pending 1. Rename the screenshot file. 2. Read the screenshot
	 *         filetype from config file and handle in the code.
	 *//*

	public static String getScreenshot(Scenario result) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-h-m-s");

		System.out.println("Date is " + dateFormat.format(date));
		// String methodName = result.getMethod().getMethodName() + "_";
		String name = result.getName() + dateFormat.format(date) + ".png";
		// System.out.println("Name of the string is " + name);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = FilePaths.screenshotsPath + File.separator + "Screenshots" + File.separator + name;
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			log.error("Could not capture screenshot" + e.getMessage());

		}
		return path;
	}

	*/
/**
	 * Use this method to capture the screenshot of the browser window and save
	 * the .png file in the Screenshots folder. FileName Format : << >>
	 *
	 * @param result
	 *            The object containing the result of the test.
	 * @return A string representation of the file path to the captured
	 *         screenshot(.png) file
	 *
	 *         Pending 1. Rename the screenshot file. 2. Read the screenshot
	 *         filetype from config file and handle in the code.
	 *//*

	public static String getAShot(Scenario scenario) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Date is " + dateFormat.format(date));

		String name = scenario.getId().replace(";", "_") + dateFormat.format(date) + ".png";

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);
		String path = FilePaths.screenshotsPath + File.separator + "Screenshots" + File.separator + name;
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(path));
		} catch (IOException e) {
			log.error("Could not capture screenshot" + e.getMessage());

		}
		return path;
	}

	public String getScreenshotOfElement(String locator) {

		WebElement ele = getElement(locator);
		if (verifyElementIsClickable(ele))

			ele.click();

		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, ele);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-h-m-s");

		System.out.println("Date is " + dateFormat.format(date));
		String name = dateFormat.format(date) + ".png";
		String path = FilePaths.screenshotsPath + File.separator + "Screenshots" + File.separator + name;

		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(path));
		} catch (IOException e) {
			System.out.println("Cannot capture the screenshot because: " + e.getMessage());
		}

		return path;
	}

	public static String getAShot() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-h-m-s");

		System.out.println("Date is " + dateFormat.format(date));
		// String methodName = result.getMethod().getMethodName() + "_";
		String name = dateFormat.format(date) + ".png";
		// System.out.println("Name of the string is " + name);
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);
		// File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = FilePaths.screenshotsPath + File.separator + "Screenshots" + File.separator + name;

		// File dest = new File(path);
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(path));
		} catch (IOException e) {
			log.error("Could not capture screenshot" + e.getMessage());

		}

		return path;
	}

	*/
/**
	 * Use this method to capture the screenshot of the browser window and save
	 * the .png file in the Screenshots folder. FileName Format : << >>
	 *
	 * @param result
	 *            The object containing the result of the test.
	 * @return A string representation of the file path to the captured
	 *         screenshot(.png) file
	 *
	 *         Pending 1. Rename the screenshot file. 2. Read the screenshot
	 *         filetype from config file and handle in the code.
	 *//*

	public static String getScreenshot(ITestResult result) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-h-m-s");

		System.out.println("Date is " + dateFormat.format(date));
		String methodName = result.getMethod().getMethodName() + "_";
		String name = "FailedMethod" + methodName + dateFormat.format(date) + ".png";
		System.out.println("Name of the string is " + name);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String path = FilePaths.screenshotsPath + File.separator + "Screenshots" + File.separator + result.getName();
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			log.error("Could not capture screenshot" + e.getMessage());

		}
		return path;
	}

	*/
/****************************************************************************************************************
	 * Method name: launchBrowser() Description: It will launch chrome browser
	 * for now and will delete all the cookies
	 * @author: Sonam Gautam
	 * @param: null
	 * @return: void
	 *******************************************************************************************************************//*

	public void launchBrowser() throws IOException {

		String browser = browserName();
		String driverArchType = getUserProperty("DriverArchType");
		Capabilities cap;
		if (browser.equalsIgnoreCase("chrome") || browser.isEmpty()) {

			if (driverArchType.contains("32")) {
				WebDriverManager.chromedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch32().setup();
			} else if (driverArchType.contains("64")) {
				WebDriverManager.chromedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch64().setup();
			}
			ChromeOptions options = new ChromeOptions();
          	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(options);
			cap = ((RemoteWebDriver) driver).getCapabilities();
			PropertyFileReader.propertyfileWrite("BrowserVersion", cap.getVersion());
			@SuppressWarnings("unchecked")
			Map<String, String> a = (Map<String, String>) cap.getCapability("chrome");
			PropertyFileReader.propertyfileWrite("DriverVersion", a.get("chromedriverVersion"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 60);
		}

	}

	*/
/****************************************************************************************************************
	 * Method name: launchApplication() Description: It will open the
	 * application with url mentioned in config properties file
	 *
	 * @author: Sonam Gautam
	 * @param: null
	 * @return: void
	 * @throws InterruptedException
	 *******************************************************************************************************************//*

	public void launchApplication() throws IOException, InterruptedException {
		// ***--Below changes are done for Jenkins parameterized job while
		// running locally please comment below two lines and uncomment last
		// line but while pushing it to git do vice versa
		String testURL = System.getProperty("URL");

		if (testURL != null) {
			driver.get(testURL);
		} else {
			driver.get(getTestURL());
		}

	}

	*/
/****************************************************************************************************************
	 * Method name: launchApplication() Description: It will open the
	 * application with url mentioned in config properties file
	 *
	 * @author: Sonam Gautam
	 * @param: null
	 * @return: void
	 * @throws SQLException
	 * @throws InterruptedException
	 *******************************************************************************************************************//*

	public void launchResetPasswordWindow(String user) throws IOException, SQLException, InterruptedException {
		System.out.println("link opening for " + user);
		Thread.sleep(6000);
		System.out
				.println("Url Generated: " + getTestURL() + "/#/resetPassword/" + DatabaseConnection.fetchToken(user));
		driver.get(getTestURL() + "/#/resetPassword/" + DatabaseConnection.fetchToken(user));

	}

	public boolean verifyVideoFeed(String filepath) throws IOException {
		boolean videoFeedAvailable = imageComparison(new File(filepath), new File(FilePaths.imageHeadUnitNotAvailable));
		System.out.println("image comparison result: " + videoFeedAvailable);
		return videoFeedAvailable;
	}

	*/
/**
	 * Use this method to launch browser with the specific capabilities and
	 * options as defined in the config.properties file.
	 *
	 * @throws IOException
	 *             -Pending Add the config file property BrowserName along with
	 *             the possible values.
	 *
	 *             Pending 1. Reading the waitTime from Config file. 2. Adding
	 *             the headless chrome and headless firefox code 3.
	 *             WebDriverManager class
	 *//*

	public void initialization() throws IOException {
		String url = getTestURL();
		String browser = browserName();
		String driverArchType = getUserProperty("DriverArchType");
		Capabilities cap;
		PropertyFileReader.propertyfileWrite("Platform", System.getProperty("os.name").toLowerCase());
		if (browser.equalsIgnoreCase("chrome") || browser.isEmpty()) {
			*/
/*
			 * System.setProperty("webdriver.chrome.driver",
			 * FilePaths.browserdriverPath + File.separator +
			 * "chromedriver.exe");
			 *//*

			// https://chromedriver.storage.googleapis.com/
			if (driverArchType.contains("32")) {
				WebDriverManager.chromedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch32().setup();
			} else if (driverArchType.contains("64")) {
				WebDriverManager.chromedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch64().setup();
			}
			driver = new ChromeDriver();
			cap = ((RemoteWebDriver) driver).getCapabilities();
			PropertyFileReader.propertyfileWrite("BrowserVersion", cap.getVersion());
			@SuppressWarnings("unchecked")
			Map<String, String> a = (Map<String, String>) cap.getCapability("chrome");
			PropertyFileReader.propertyfileWrite("DriverVersion", a.get("chromedriverVersion"));
			try {
				driver.get(url);

			} catch (Exception e) {
				System.out.println("Please enter the URL in config file ");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 500);
		} else if (browser.equalsIgnoreCase("Internet Explorer") || browser.equalsIgnoreCase("IE")
				|| browser.equalsIgnoreCase("InternetExplorer")) {

			if (driverArchType.contains("32")) {
				WebDriverManager.iedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch32().setup();
			} else if (driverArchType.contains("64")) {
				WebDriverManager.iedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch64().setup();
			}
			driver = new InternetExplorerDriver();// http://selenium-release.storage.googleapis.com/index.html
			cap = ((RemoteWebDriver) driver).getCapabilities();
			PropertyFileReader.propertyfileWrite("BrowserVersion", cap.getVersion());
			PropertyFileReader.propertyfileWrite("DriverVersion", WebDriverManager.iedriver().getDownloadedVersion());
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 10);
		} else if (browser.equalsIgnoreCase("FireFox") || browser.equalsIgnoreCase("FF")) {
			if (driverArchType.contains("32")) {
				WebDriverManager.firefoxdriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch32().setup();
			} else if (driverArchType.contains("64")) {
				WebDriverManager.firefoxdriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch64().setup();
			}
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			// To prevent the driver logs to appear on the console.
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			driver = new FirefoxDriver();
			cap = ((RemoteWebDriver) driver).getCapabilities();
			PropertyFileReader.propertyfileWrite("BrowserVersion", cap.getVersion());
			PropertyFileReader.propertyfileWrite("DriverVersion",
					WebDriverManager.firefoxdriver().getDownloadedVersion());
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 10);
		} else if (browser.equalsIgnoreCase("headless chrome")) {
			if (driverArchType.contains("32")) {
				WebDriverManager.chromedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch32().setup();
			} else if (driverArchType.contains("64")) {
				WebDriverManager.chromedriver().version(getUserProperty("WebDriverVersion"))
						.proxy(getUserProperty("ProxyHost") + ":" + getUserProperty("ProxyPort")).arch64().setup();
			}
			// Add options to Google Chrome. The window-size is important for
			// responsive
			// sites
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			driver = new ChromeDriver();
			cap = ((RemoteWebDriver) driver).getCapabilities();
			PropertyFileReader.propertyfileWrite("BrowserVersion", cap.getVersion());
          	ChromeDriverService service = new ChromeDriverService.Builder()
		            .usingAnyFreePort()
		            .withVerbose(true)
		            .build();
		        service.start();
			@SuppressWarnings("unchecked")
			Map<String, String> a = (Map<String, String>) cap.getCapability("chrome");
			PropertyFileReader.propertyfileWrite("DriverVersion", a.get("chromedriverVersion"));
			try {
				driver.get(url);
			} catch (Exception e) {
				System.out.println("Please enter the URL in config file ");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 10);
		}

	}

	*/
/**
	 * Use this method to click on an element on the current page.
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 *
	 *//*

	public void click(String locator) {
		WebElement ele = getElement(locator);
		if (verifyElementIsClickable(ele))
			ele.click();
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public void navigateInBrowser(String navigation) throws Exception {
		switch (navigation.toLowerCase()) {
		case "backward":
		case "back":
			driver.navigate().back();
			Thread.sleep(1000);
			System.out.println("navigated backwards");
			break;
		case "forward":
			driver.navigate().forward();
			Thread.sleep(1000);
			System.out.println("navigated forward");
			break;
		}
	}

	public void pageRefresh() {
		driver.navigate().refresh();
		System.out.println("Page refreshed");
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	*/
/**
	 * Use this method to verify whether the element is clickable
	 *
	 * @param element
	 *            The web element of the current page
	 * @return A boolean value True, if the element is clickable else False.
	 *//*

	public boolean verifyElementIsClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("Element is clickable");
		} catch (Exception e) {
			log.info("Element is not clickable");
			return false;
		}
		return true;
	}

	*/
/**
	 * Use this method to simulate typing text into an element which may set its
	 * value
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 * @param value
	 *            Character sequence to be send to the element
	 *//*

	public void setText(String locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void clear(String locator) {
		getElement(locator).clear();
	}

	public String getTitle() {
		return driver.getCurrentUrl();
	}

	public String getAttribute(String locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}

	public String getTextOfElement(String element) {
		return getElement(element).getText();
	}

	public String getAttributeValue(String element) {
		return getElement(element).getAttribute("outerText");
	}

	public boolean elementDisplayed(String locator) {
		try {
			if (getElement(locator).isDisplayed()) {
				System.out.println("Element " + locator + " is  displayed");
				highlightElement(getElement(locator));

			}

		} catch (Exception nse) {
			System.out.println("Element " + locator + " is not displayed");
			return false;
		}
		return true;

	}

	public boolean elementEnabled(String locator) {
		if (getElement(locator).isEnabled())
			return true;
		else
			return false;

	}

	public boolean elementDisplayedByJS(String locator) {
		try {
			if (getElementByJS(locator).isDisplayed()) {
				System.out.println("Element " + locator + " is  displayed");

			}
		} catch (Exception nse) {
			System.out.println("Element " + locator + " is not displayed");
			return false;
		}
		return true;

	}

	public boolean elementDisplayedold(String locator) {
		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);
		boolean flag = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");
		switch (locatorType) {
		case "XPATH":
			if (driver.findElement(By.xpath(locatorValue)).isDisplayed() == true)
				highlightElement(driver.findElement(By.xpath(locatorValue)));
			return driver.findElement(By.xpath(locatorValue)).isDisplayed();
		case "CSS":
		case "CSSSELECTOR":
			if (driver.findElement(By.cssSelector(locatorValue)).isDisplayed() == true)
				highlightElement(driver.findElement(By.cssSelector(locatorValue)));
			return driver.findElement(By.cssSelector(locatorValue)).isDisplayed();
		case "NAME":
			if (driver.findElement(By.name(locatorValue)).isDisplayed() == true)
				highlightElement(driver.findElement(By.name(locatorValue)));
			return driver.findElement(By.name(locatorValue)).isDisplayed();
		case "CLASSNAME":
			if (driver.findElement(By.className(locatorValue)).isDisplayed() == true)
				highlightElement(driver.findElement(By.className(locatorValue)));
			return driver.findElement(By.className(locatorValue)).isDisplayed();
		case "LINKTEXT":
			System.out.println("locator type: " + driver.findElement(By.linkText(locatorValue)).isDisplayed());
			// if(driver.findElement(By.linkText(locatorValue)).isDisplayed())
			// highlightElement(driver.findElement(By.linkText(locatorValue)));
			return driver.findElement(By.linkText(locatorValue)).isDisplayed();
		case "PARTIALLINKTEXT":
			if (driver.findElement(By.partialLinkText(locatorValue)).isDisplayed() == true)
				highlightElement(driver.findElement(By.partialLinkText(locatorValue)));
			return driver.findElement(By.partialLinkText(locatorValue)).isDisplayed();
		case "TAGNAME":
			if (driver.findElement(By.tagName(locatorValue)).isDisplayed() == true)
				highlightElement(driver.findElement(By.tagName(locatorValue)));
			return driver.findElement(By.tagName(locatorValue)).isDisplayed();
		case "ID":
			if (driver.findElement(By.id(locatorValue)).isDisplayed() == true)
				highlightElement(driver.findElement(By.id(locatorValue)));
			return driver.findElement(By.id(locatorValue)).isDisplayed();
		}
		return flag;

	}

	*/
/**
	 * Use this method to scroll into view the element on the browser window
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 * @return
	 *//*

	public WebElement scrollToElement(String locator) {
		WebElement ele = getElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		if (ele.isDisplayed()) {
			log.info("Element is visible after scrolling down");
			// System.out.println("Element is visible after scrolling down");
			return ele;
		} else {
			log.info("Element is not visible after scrolling down");
			// System.out.println("Element is not visible after scrolling
			// down");
		}
		return ele;
	}

	public void clickjs(String locator)
	{
		WebElement ele = getElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
			}

	public boolean verifyElementToBeClickable(WebElement ele) {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
		System.out.println(ele + " is not clickable");
		return false;
		}
		return true;
		}

	public void doubleClick(String button) {
	WebElement ele = getElement(button);
	Actions actions = new Actions(driver);
	if (verifyElementToBeClickable(ele))
	actions.doubleClick(ele).perform();
	else
	System.out.println("Element " + ele + " is not clickable");
	}

	public void handelBrowserPopUp() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyPress(KeyEvent.VK_ENTER);
			}
	*/
/**
	 * Use this method to get all the elements by using Javascript executor
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 * @return
	 *//*

	public List<WebElement> getElementsByJS(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String locatorValue = getLocatorValue(locator);
		@SuppressWarnings("unchecked")
		List<WebElement> eles = (ArrayList<WebElement>) js
				.executeScript("var results = new Array();" + "var element = document.evaluate(\"" + locatorValue
						+ "\", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);"
						+ "for ( var i = 0 ; i < element.snapshotLength ; i++ )" + "{"
						+ "results.push(element.snapshotItem(i));" + "}" + "return results;", "");

		return eles;
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	*/
/**
	 * Use this method to get the element by using Javascript executor
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 * @return
	 *//*

	public WebElement getElementByJS(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String locatorValue = getLocatorValue(locator);
		WebElement eles = (WebElement) js.executeScript("var a = document.evaluate(\"" + locatorValue
				+ "\", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0) { return a.snapshotItem(0); };");

		System.out.println("In get element by JS method: " + eles);
		return eles;
	}

	*/
/**
	 * Use this method to scroll into view the element and click on that
	 * element.
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 *//*

	public void scrollAndClick(String locator) {
		scrollToElement(locator).click();
	}

	*/
/**
	 * A method to split the locator string containing locator type and locator
	 * value and return the locator value.
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 * @return A string containing the locator type like xpath, css, id,
	 *         linktext as defined in the page's property file.
	 *//*

	private String getLocatorType(String locator) {
		String type = splitString(locator, "]: ", 0);
		return type.substring(1).toUpperCase();
	}

	*/
/*
	 * -?- Why have created a repeated function for split string? The index is
	 * not being used.
	 *//*

	public String splitString(String locator, String regEx, int index) {
		String[] inputSpilt = locator.split(regEx);
		return inputSpilt[index];
	}

	*/
/**
	 * A method to split the locator string containing locator type and locator
	 * value and return the locator value.
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 * @return A string containing the locator value
	 *//*

	private String getLocatorValue(String locator) {
		return splitString(locator, "]: ", 1);
	}

	*/
/**
	 * Find the first WebElement using the given method. This method is affected
	 * by the 'explicit wait' times in force at the time of execution. The
	 * getElement(..) invocation will return a matching row, or try again
	 * repeatedly until the configured timeout is reached. getElement should not
	 * be used to look for non-present elements, use getElements(..) and assert
	 * zero length response instead.
	 *
	 * @param locator
	 *            The locating mechanism.The property value for the element from
	 *            the respective page's property file.
	 * @return The first matching element on the current page.
	 *//*

	public WebElement getElement(String locator) {
		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);
		WebElement element = null;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		switch (locatorType) {
		case "XPATH":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			break;
		case "CSS":
		case "CSSSELECTOR":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			break;
		case "NAME":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			break;
		case "CLASSNAME":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			break;
		case "LINKTEXT":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			break;
		case "PARTIALLINKTEXT":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			break;
		case "TAGNAME":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			break;
		case "ID":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			break;
		}

		jse.executeScript("arguments[0].style.border='cyan solid 3px' ", element);
		return element;

	}

	public void highlightElement(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='cyan solid 3px' ", ele);

	}

	public void highlightElementError(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='red solid 3px' ", ele);

	}

	public WebElement selectingElementByQuerySelector(String locator) {
		String locatorValue = getLocatorValue(locator);
		WebElement elements;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		elements = (WebElement) (js.executeScript("return document.querySelector('" + locatorValue + "');"));
		return elements;
	}

	public List<WebElement> selectingElementsByQuerySelector(String locator) {
		String locatorValue = getLocatorValue(locator);
		List<WebElement> elements = new ArrayList<WebElement>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		elements = (List<WebElement>) (js.executeScript("return document.querySelectorAll('" + locatorValue + "');"));
		return elements;
	}

	public String getSelectorValue(String locator) {
		return getLocatorValue(locator);
	}

	public List<WebElement> getElements(String locator) {
		String locatorType = getLocatorType(locator);
		String locatorValue = getLocatorValue(locator);
		List<WebElement> rows = null;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		switch (locatorType) {
		case "XPATH":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
			break;
		case "CSS":
		case "CSSSELECTOR":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locatorValue)));
			break;
		case "NAME":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorValue)));
			break;
		case "CLASSNAME":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locatorValue)));
			break;
		case "LINKTEXT":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locatorValue)));
			break;
		case "PARTIALLINKTEXT":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(locatorValue)));
			break;
		case "TAGNAME":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(locatorValue)));
			break;
		case "ID":
			rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));
			break;
		}

		for (WebElement ele : rows) {
			// jse.executeScript("arguments[0].style.border='cyan solid 3px' ",
			// ele);
			// ele.sendKeys(Keys.SHIFT);
			// jse.executeScript("ele.focus();", ele);
		}

		return rows;

	}

	public static void tearDown() {
      	driver.close();
		driver.quit();
	}

	public static void closeBrowser() throws Exception {
		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;
	}

	public static String captureScreenshotOnCompletion(Scenario scenario) throws IOException {

		System.out.println("Status of the scenario:" + scenario.getName() + " is : " + scenario.getStatus());

		//if (scenario.getStatus().startsWith("fail"))
			//return getAShot(scenario);
		//else
			return null;

	}

	public static String captureScreenshotOnCompletion() throws IOException {
		System.out.println("Status of the scenario: is : ");

		// String screenPath = getScreenshot(result);
		String screenPath = getAShot();
		return screenPath;

		// return getScreenshot(result);
		*/
/*
		 * method = result.getMethod().getMethodName();
		 * System.out.println("Method name is " + method); logger =
		 * extent.createTest(result.getMethod().getMethodName());
		 * System.out.println("In Logger" + logger); if (result.getStatus() ==
		 * ITestResult.FAILURE) { logger.log(Status.INFO,
		 * "Test case failed due to : " +
		 * result.getThrowable().fillInStackTrace()); String screenPath =
		 * PredefinedMethods.getScreenshot(result);
		 * logger.fail(result.getThrowable().getMessage(),
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
		 * }
		 *
		 * extent.flush();
		 *//*


	}

	public static String imageToBase64Coversion(String imagePath) throws IOException {
		byte[] fileContent = FileUtils.readFileToByteArray(new File(imagePath));
		return Base64.getEncoder().encodeToString(fileContent);
	}

	*/
/*
	 * This method returns the random alphabetic string of length in param
	 *//*

	public String getRandomString(int length) {

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < length) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public boolean imageComparison(File capturedImage, File expectedImage) throws IOException {

		BufferedImage actualBufferedImage = ImageIO.read(capturedImage);
		BufferedImage expectedBufferedImage = ImageIO.read(expectedImage);
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualBufferedImage, expectedBufferedImage);
		return diff.hasDiff();

	}
	*/
/*
	 * This method used to do right click
	 *//*

	public void rightClick(String locator) {
		WebElement ele = getElement(locator);
		Actions actions = new Actions(driver);
		actions.contextClick(ele).perform();
	}

	public void select(String locator, String Value){
		WebElement ele = getElement(locator);
		Select obj = new Select(ele);
		obj.selectByVisibleText(Value);

	}
}
*/
