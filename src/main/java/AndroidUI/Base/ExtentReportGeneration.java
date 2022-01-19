//
//package AndroidUI.Base;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Properties;
//
//import ch.qos.logback.core.status.Status;
//import org.testng.ITestResult;
////import org.tsystems.testfactory.base.PredefinedMethods;
////import org.tsystems.testfactory.constants.FilePaths;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentKlovReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//
///*
// * ExtentReportGeneration.java- This class Generates the Extent report with
// * appropriate metadata mentioned in config.properties by the user and capture
// * the screenshots on failure for each run of methods.
// *
// * @methods -getReportName() -getProjectName() -generateExtentReport()
// *          -captureScreenshotOnFailure(ITestResult)
// * @author Vanshika Chauhan
// * @version 1.0
// *
// */
//
//public class ExtentReportGeneration {
//	static ExtentReports extent;
//	static ExtentTest logger;
//	static String method;
//	static Properties userconfigProperties;
//
//
///*
//	 * Static block- Config.properties file is getting loaded in below static block.
//	 * Static block will executed every time when a class loads.
//	 *
//	 * @param -NA
//	 * @return -NA
//	 * @throws -IOException
//	 * @author -Vanshika Chauhan
//	 * @version -1.0
//	 */
//
//	static {
//		try {
//			userconfigProperties = PropertyFileReader.propertyfileRead(FilePaths.extentReportPath);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
///*
//	 * This method reads the key 'ExtentReportName' from config.properties and
//	 * returns it's value.The expected value of 'ExtentReportName' will be the name
//	 * of the .html report which will be concatenated with project name during
//	 * report generation.
//	 *
//	 * @param -None
//	 * @return -Value of ExtentReportName from config.properties
//	 * @throws -IOException
//	 * @author -Vanshika Chauhan
//	 * @version -1.0
//	 */
//
//	private static String getReportName() throws IOException {
//
//		return userconfigProperties.getProperty("ExtentReportName");
//
//	}
//
//
///*
//	 * This method reads the key 'ProjectName' from config.properties and returns
//	 * it's value.The expected value of 'ProjectName' will be the name of the .html
//	 * report which further gets concatenated with the 'ExtentReportName'.
//	 *
//	 * @param -None
//	 * @return -Value of ProjectName from config.properties
//	 * @throws -IOException
//	 * @author -Vanshika Chauhan
//	 * @version -1.0
//	 */
//
//
//	private static String getProjectName() {
//		return userconfigProperties.getProperty("ProjectName");
//	}
//
//
///*
//	 * This method reads the key 'TestType' from config.properties and returns it's
//	 * value.The expected value of 'TestType' will be the execution type say,
//	 * functional, regression, smoke sanity etc. which further gets concatenated
//	 * with the 'ExtentReportName'.
//	 *
//	 * @param -None
//	 * @return -NA
//	 * @throws -IOException
//	 * @author -Vanshika Chauhan
//	 * @version -1.0
//	 */
//
//	private static String getTestRunType() {
//		return userconfigProperties.getProperty("TestType");
//	}
//
//
///**
//	 * This method provides below functionalities: a)Fetch current date of the
//	 * system in 'dd-mm-yyyy h-m-s-ms' format. b)Generate ExtentHTMLReport and
//	 * concatenate the values returned by getProjectName() and getReportName()
//	 * methods with currentDate. c)Add the metadata(report's title, report's header
//	 * etc.) and Theme - Dark/Standard as per the values entered by user in
//	 * config.properties file.
//	 *
//	 * @param -None
//	 * @return -NA
//	 * @throws -IOException
//	 * @author -Vanshika Chauhan & Kaushal Potdar
//	 * @version -1.0
//	 */
//
//
//	public static void generateExtentReport() throws IOException {
//		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s-ms");
//		Date date = new Date();
//		ExtentKlovReporter klov = new ExtentKlovReporter();
//		klov.initMongoDbConnection(userconfigProperties.getProperty("MongoDBHost"), Integer.parseInt(userconfigProperties.getProperty("MongoDBPort")));
//		klov.setProjectName(userconfigProperties.getProperty("ProjectName"));
//		klov.setReportName(
//				userconfigProperties.getProperty("ProjectName") + "_" + userconfigProperties.getProperty("TestType")+"_"+userconfigProperties.getProperty("ApplicationVersion"));
//		klov.initKlovServerConnection("http://"+userconfigProperties.getProperty("KlovServerHost")+":"+userconfigProperties.getProperty("KlovServerPort"));
//		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
//				FilePaths.extentReportPath + File.separator + getProjectName() + "_" + getTestRunType() + "_"
//						+ getReportName() + "_" + dateFormat.format(date) + ".html");
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter, klov);
//		htmlReporter.config().setDocumentTitle(userconfigProperties.getProperty("ExtentReportTitle"));
//		// fetch the ReportTheme value from config.properties and apply the
//		// theme as per the below conditions.
//		if (userconfigProperties.getProperty("ReportTheme").equalsIgnoreCase("DARK"))
//			htmlReporter.config().setTheme(Theme.DARK);
//		else if (userconfigProperties.getProperty("ReportTheme").equalsIgnoreCase("STANDARD"))
//			htmlReporter.config().setTheme(Theme.STANDARD);
//		else
//			System.out.println("Report's theme is invalid in property file");
//		// This value is displayed at the top of the report
//
//		htmlReporter.config().setReportName(userconfigProperties.getProperty("ExtentReportHeader"));
//		setSystemInfo();
//
//	}
//
//	public static void setSystemInfo() {
//		extent.setSystemInfo("Browser", userconfigProperties.getProperty("Browser"));
//		extent.setSystemInfo("Browser Version", userconfigProperties.getProperty("BrowserVersion"));
//		extent.setSystemInfo("Driver Version", userconfigProperties.getProperty("DriverVersion"));
//		extent.setSystemInfo("OS", userconfigProperties.getProperty("Platform"));
//		extent.setSystemInfo("Test Type", userconfigProperties.getProperty("TestType"));
//		extent.setSystemInfo("Test Env", userconfigProperties.getProperty("TestEnvironment"));
//		extent.setSystemInfo("App. Version", userconfigProperties.getProperty("ApplicationVersion"));
//		extent.setSystemInfo("Executed", userconfigProperties.getProperty("Executed"));
//	}
//
//
///*
//	 generateExtentReport()- This method provides below functionalities: a)Fetch
//	  current method name using ITestResult Listener. b)capturescreenshot of the
//	  currently displayed page on failure by calling 'getScreenshot' method written
//	  in 'PredefinedMethods.java' in base package. c)Fetch the Exception occured on
//	  failure and display it in the .html report. d)Attach the screenshot in the
//	  report. e)Appends the HTML file with all the ended tests using
//	  extent.flush().
//
//	  @param -ITestResult listener
//	  @return -Nothing
//	  @throws -IOException
//	  @author -Vanshika Chauhan
//	  @version -1.0
//	 */
//
//
//	public static void captureScreenshotOnFailure(ITestResult result) throws IOException {
//		method = result.getMethod().getMethodName();
//		System.out.println("Method name is " + method);
//		logger = extent.createTest(result.getMethod().getMethodName());
//		System.out.println("In Logger" + logger);
//		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.log(Status.INFO, "Test case failed due to : " + result.getThrowable().fillInStackTrace());
//			String screenPath = PredefinedMethods.getScreenshot(result);
//			logger.fail(result.getThrowable().getMessage(),
//					MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
//		}
//		extent.flush();
//	}
//}
//
