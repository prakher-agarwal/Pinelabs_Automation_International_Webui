package TestBase;

import AndroidUI.Base.BaseUtilsUI;
import AndroidUI.POM.DeviceHomePage;
import AndroidUI.POM.IrisApp.IrisHomePage;
import AndroidUI.POM.IrisApp.IrisSettingsPage;
import AndroidUI.POM.PaymentsApp.CommonHelperPage;
import AndroidUI.POM.PaymentsApp.PaymentsAmazonPayValidationsPage;
import AndroidUI.POM.PaymentsApp.PaymentsUPIValidationsPage;
import CommonBase.CommonUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class TestUtils {

    public static IrisHomePage getIrisHomePageInstance;
    public static DeviceHomePage getDeviceHomePageInstance;
    public static IrisSettingsPage getIrisSettingsPage;

    public static PaymentsAmazonPayValidationsPage paymentsAmazonPayValidationsPage;

    public static PaymentsUPIValidationsPage paymentsHomePageInstance;

    @BeforeSuite
    public void getInstances() {
       // BaseUtilsUI.setUpConnection();

        getIrisHomePageInstance = getIrisHomePageInstance();
        getIrisSettingsPage = getIrisSettingsPageInstance();
        getDeviceHomePageInstance = getDeviceHomePageInstance();

    }



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
