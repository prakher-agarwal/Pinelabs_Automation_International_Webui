package AndroidUI.POM;

import AndroidUI.Base.BaseUtilsUI;
import Base.CommonUtils;

import java.util.Map;
import java.util.Properties;

public class DeviceHomePage extends BaseUtilsUI {
    static DeviceHomePage deviceHomePage;
    Properties locatorProp, deviceProp;
    Map<String, String> values;

    private DeviceHomePage() {

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
        } while (!isElementPresent(locatorProp.getProperty("IrisApp"),"checked"));
        clickOnElement(locatorProp.getProperty("IrisApp"));
    }

    public void openPaymentsApp() {
        setUpConnection();
        do {
            navigateBack();
            System.out.println("Navigating back to Payments");
        } while (!isElementPresent(locatorProp.getProperty("PaymentsApp"),"checked"));
        clickOnElement(locatorProp.getProperty("PaymentsApp"));
        System.out.println("Payment app is open");
    }
}
