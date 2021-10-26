package AndroidUI.POM.IrisApp;

import AndroidUI.Base.BaseUtilsUI;
import Base.CommonUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class IrisHomePage extends BaseUtilsUI {
    static IrisHomePage irisHomePage;
    static Properties locatorProp, deviceProp;
    static Map<String, String> values;

    private IrisHomePage() {

        locatorProp = CommonUtils.readPropertyfile("LocatorsRepo", "IrisHome.properties");
        deviceProp = CommonUtils.readPropertyfile("CommonProperties", "Device.properties");
        values = new HashMap<>();
    }

    public static IrisHomePage getInstance() {
        if (irisHomePage == null)
            irisHomePage = new IrisHomePage();
        return irisHomePage;
    }

    public void navigateToSettings() {
        clickOnElement(locatorProp.getProperty("SettingsIcon"));
        System.out.println("Clicked on Settings icon");
    }


}
