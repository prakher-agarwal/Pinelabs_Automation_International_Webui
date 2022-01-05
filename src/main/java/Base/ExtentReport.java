package Base;


import AndroidUI.Base.BaseUtilsUI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {
    static ExtentReports report;
    public static ExtentTest logger;
    static String method;
    static ExtentHtmlReporter htmlReporter;

    public static String generateDynamicName() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s-ms");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void initialiseReport() {
        report = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter(".\\Reports\\"+ generateDynamicName()+".html");
        report.attachReporter(htmlReporter);
    }

    public static void generateReport(ITestResult result) {

        method = result.getMethod().getMethodName();
        System.out.println("Method name is " + method);
        logger = report.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.INFO, "Test case failed due to : " + result.getThrowable().fillInStackTrace());
            String screenPath = BaseUtilsUI.getScreenshot(result);
            try {
                logger.fail(result.getThrowable().getMessage(),
                        MediaEntityBuilder.createScreenCaptureFromPath(screenPath).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.flush();
    }
}
