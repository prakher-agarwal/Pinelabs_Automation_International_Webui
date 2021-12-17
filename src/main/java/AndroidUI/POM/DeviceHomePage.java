package AndroidUI.POM;

import AndroidUI.Base.BaseUtilsUI;
import Base.CommonUtils;

import java.util.Map;
import java.util.Properties;

public class DeviceHomePage extends BaseUtilsUI {
    static DeviceHomePage deviceHomePage;
    Properties locatorProp, deviceProp;
    static Properties deviceHome;

    private DeviceHomePage() {
        deviceHome = CommonUtils.readPropertyfile("LocatorsRepo", "DeviceHome.properties");
        locatorProp = CommonUtils.readPropertyfile("LocatorsRepo", "DeviceHome.properties");
        deviceProp = CommonUtils.readPropertyfile("CommonProperties", "Device.properties");

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
        } while (!isElementPresent(locatorProp.getProperty("IrisApp"), "checked"));
        clickOnElement(locatorProp.getProperty("IrisApp"));
    }

    public void openPaymentsApp() {
//        if (isElementDisplayed(deviceHome.getProperty("imageView"))) {
//            clickOnElement(deviceHome.getProperty("imageView"));
//            clickOnElement(deviceHome.getProperty("homeAppPayments"));
//        } else if (isElementDisplayed(locatorProp.getProperty("PaymentsApp"))) {
            clickOnElement(locatorProp.getProperty("PaymentsApp"));
            System.out.println("Payment app is open");
        }
   // }
}
