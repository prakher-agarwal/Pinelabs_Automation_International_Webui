package com.pinelabs.RnD.AndroidTest;

import com.pinelabs.RnD.AndroidUI.POM.DeviceHomePage;
import com.pinelabs.RnD.AndroidUI.POM.IrisApp.IrisHomePage;
import com.pinelabs.RnD.AndroidUI.POM.IrisApp.IrisSettingsPage;
import com.pinelabs.RnD.AndroidUI.POM.PaymentsApp.CommonHelperPage;
import com.pinelabs.RnD.AndroidUI.POM.PaymentsApp.PaymentsAmazonPayValidationsPage;
import com.pinelabs.RnD.AndroidUI.POM.PaymentsApp.PaymentsUPIValidationsPage;
import com.pinelabs.RnD.CommonUtils.ExtentSparkReportUtility;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestUtils extends ExtentSparkReportUtility {

    public static IrisHomePage getIrisHomePageInstance;
    public static DeviceHomePage getDeviceHomePageInstance;
    public static IrisSettingsPage getIrisSettingsPage;

    public static PaymentsAmazonPayValidationsPage paymentsAmazonPayValidationsPage;

    public static PaymentsUPIValidationsPage paymentsHomePageInstance;

   // @BeforeSuite
    public void getInstances() {
        // BaseUtilsUI.setUpConnection();
        //ExtentSparkReport.initialise();
        getIrisHomePageInstance = getIrisHomePageInstance();
        getIrisSettingsPage = getIrisSettingsPageInstance();
        getDeviceHomePageInstance = getDeviceHomePageInstance();
    }
   // @BeforeMethod
    public void setmethodAndCurrentClass(Method method, ITestContext result) {
        Test test = method.getAnnotation(Test.class);
        setMethod(method, test);
    }
  //  @AfterMethod
    public void getResult(ITestResult result) {
        System.out.println("In after Method");
        ExtentSparkReportUtility.generateReport(result);
    }

//    @AfterMethod
//    public void getResult(ITestResult result) {
//        ExtentSparkReport.generateReport(result);
//    }
//

    public IrisHomePage getIrisHomePageInstance() {
        getIrisHomePageInstance = IrisHomePage.getInstance();
        return getIrisHomePageInstance;
    }

    public IrisSettingsPage getIrisSettingsPageInstance() {
        getIrisSettingsPage = IrisSettingsPage.getInstance();
        return getIrisSettingsPage;
    }

    public DeviceHomePage getDeviceHomePageInstance() {
        getDeviceHomePageInstance = DeviceHomePage.getInstance();
        return getDeviceHomePageInstance;
    }


    public PaymentsUPIValidationsPage getPaymentsUPIValidationInstance() {
        return PaymentsUPIValidationsPage.getInstance();
    }

    public CommonHelperPage getCommonHelperPageInstance() {
        return CommonHelperPage.getInstance();
    }

    public PaymentsAmazonPayValidationsPage getPaymentsAmazonPayValidationsPage() {
        return PaymentsAmazonPayValidationsPage.getInstance();
    }


    // @AfterClass
    public void closeDbConnection() {
        getCommonHelperPageInstance().closeDriver();
    }


}
