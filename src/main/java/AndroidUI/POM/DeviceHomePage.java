package AndroidUI.POM;

import AndroidUI.Base.BaseUtilsUI;
import CommonBase.CommonUtils;
import Constants.Paths;
import org.testng.Assert;

import java.util.Properties;

public class DeviceHomePage extends BaseUtilsUI {
    static DeviceHomePage deviceHomePage;

    Properties commonLocatorProp, deviceProp;
    static Properties deviceHome;

    private DeviceHomePage() {
        deviceHome = CommonUtils.readPropertyfile(Paths.deviceHomePropertiesPath);
        commonLocatorProp = CommonUtils.readPropertyfile(Paths.commonLocPropertiesPath);
        deviceProp = CommonUtils.readPropertyfile(Paths.devicePropertiesPath);

    }

    public static DeviceHomePage getInstance() {
        if (deviceHomePage == null)
            deviceHomePage = new DeviceHomePage();
        return deviceHomePage;
    }

    public void openIrisApp() {
        setUpConnection();
        do {
            navigateBack();
            System.out.println("Navigating back to Iris");
        } while (!isElementPresent(deviceHome.getProperty("IrisApp"), "checked"));
        clickOnElement(deviceHome.getProperty("IrisApp"));
    }

    private void paymentsFromHomeApp() {
        if (isElementDisplayed(deviceHome.getProperty("imageView"))) {
            clickOnElement(deviceHome.getProperty("imageView"));
            clickOnElement(deviceHome.getProperty("homeAppPayments"));
        } else if (isElementDisplayed(deviceHome.getProperty("homeAppPayments")))
            clickOnElement(deviceHome.getProperty("homeAppPayments"));
    }

    private void paymentsFromDeviceHome() {
        if (isElementDisplayed(deviceHome.getProperty("PaymentsApp"))) {
            clickOnElement(deviceHome.getProperty("PaymentsApp"));
            System.out.println("Payment app is open from device app");
        }
    }

    public void openPaymentsApp() {

        if (isElementDisplayed(deviceHome.getProperty("imageView"))) {
            clickOnElement(deviceHome.getProperty("imageView"));
            clickOnElement(deviceHome.getProperty("homeAppPayments"));
//            if (checkTransactionPopUP())
//                clickOnElement(deviceHome.getProperty("homeAppPayments"));
        } else if (isElementDisplayed(deviceHome.getProperty("PaymentsApp"))) {
            clickOnElement(deviceHome.getProperty("PaymentsApp"));
            System.out.println("Payment app is open");
        }
        else
            clickOnElement(deviceHome.getProperty("homeAppPayments"));
    }

    private boolean checkTransactionPopUP() {
        if (isElementDisplayed(commonLocatorProp.getProperty("tansactionAreadyInProgress"))) {
            Assert.assertEquals(getElementText(commonLocatorProp.getProperty("proceedToActiveText")), "Do you want to go to the active transaction?");
            clickOnElement(commonLocatorProp.getProperty("noButton"));
            return true;
        } else
            return false;


    }


}
