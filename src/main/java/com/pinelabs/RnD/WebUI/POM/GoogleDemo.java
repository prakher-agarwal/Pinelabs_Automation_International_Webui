package com.pinelabs.RnD.WebUI.POM;

import com.pinelabs.RnD.CommonUtils.CommonUtils;
import com.pinelabs.RnD.WebUI.Base.SeleniumUtilities;
import com.pinelabs.RnD.WebUI.Constants.FilePaths;

import java.util.Properties;

public class GoogleDemo extends SeleniumUtilities {
    static GoogleDemo webUIDemoInstance;
    Properties googleDemoProperties;

    private GoogleDemo() {
        googleDemoProperties = CommonUtils.readPropertyfile(FilePaths.googleDemoProperties);
    }

    public static GoogleDemo getInstance() {
        if (webUIDemoInstance == null)
            webUIDemoInstance = new GoogleDemo();
        return webUIDemoInstance;
    }

    public void launchBrowser(){
        initialization();
    }
    public void searchText(String text) {
        clickOnElement(googleDemoProperties.getProperty("searchBox"));
        setElementText(googleDemoProperties.getProperty("searchBox"),text);
    }
}
