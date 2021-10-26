package TestBase;

import API.Builders.UpiCallbackIcici;
import AndroidUI.POM.PaymentsApp.PaymentsHomePage;
import Base.CommonUtils;
import API.Builders.GetJWTToken;
import API.Builders.IrisGetParametersFromPineCloud;
import AndroidUI.POM.DeviceHomePage;
import AndroidUI.POM.IrisApp.IrisHomePage;
import AndroidUI.POM.IrisApp.IrisSettingsPage;
import org.testng.annotations.BeforeSuite;

public class TestUtils {
    public static GetJWTToken getJwtTokenInstance;
    public static IrisHomePage getIrisHomePageInstance;
    public static DeviceHomePage getDeviceHomePageInstance;
    public static IrisSettingsPage getIrisSettingsPage;
    public static IrisGetParametersFromPineCloud getIrisGetParametersFromPineCloud;

    public static PaymentsHomePage paymentsHomePageInstance;

    @BeforeSuite
    public void getInstances() {

       // getJwtTokenInstance = getJwtTokenInstance();
        getIrisHomePageInstance = getIrisHomePageInstance();
        getIrisSettingsPage = getIrisSettingsPageInstance();
        getDeviceHomePageInstance = getDeviceHomePageInstance();
        getIrisGetParametersFromPineCloud = getIrisGetParametersFromPineCloud();

    }

    public static GetJWTToken getJwtTokenInstance(String request) {
        getJwtTokenInstance= GetJWTToken.getInstance(request);
        return getJwtTokenInstance;
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

    public IrisGetParametersFromPineCloud getIrisGetParametersFromPineCloud() {
        getIrisGetParametersFromPineCloud = IrisGetParametersFromPineCloud.getInstance();
        return getIrisGetParametersFromPineCloud;
    }

    public PaymentsHomePage getPaymentsHomePageInstance() {
        return PaymentsHomePage.getInstance();
    }

    //
//    public UpiCallbackIcici getUpicallbackIciciInstance(){
//        return UpiCallbackIcici.getInstance();
//    }
    // @AfterClass
    public void closeDbConnection() {
        CommonUtils.closeConnection();
    }


}
