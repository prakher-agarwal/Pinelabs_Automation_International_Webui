package AndroidUI.POM.IrisApp;

import AndroidUI.Base.BaseUtilsUI;
import CommonBase.CommonUtils;
import Constants.Paths;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class IrisHomePage extends BaseUtilsUI {
    static IrisHomePage irisHomePage;
    static Properties locatorProp, deviceProp;
    static Map<String, String> values;

    private IrisHomePage() {

        locatorProp = CommonUtils.readPropertyfile(Paths.irisHomePropertiesPath);
        deviceProp = CommonUtils.readPropertyfile(Paths.devicePropertiesPath);
        values = new HashMap<>();
    }

    public static IrisHomePage getInstance() {
        if (irisHomePage == null)
            irisHomePage = new IrisHomePage();
        return irisHomePage;
    }

    public void navigateToSettings() {
        clickOnElement(locatorProp.getProperty("settingsIcon"));
        System.out.println("Clicked on Settings icon");
    }


}
