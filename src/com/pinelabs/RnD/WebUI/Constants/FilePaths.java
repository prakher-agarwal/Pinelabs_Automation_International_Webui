package com.pinelabs.RnD.WebUI.Constants;

import java.io.File;

public class FilePaths {
    public static final String resourceFolderPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public static final String webUIUserConfig = resourceFolderPath + "CommonProperties" + File.separator + "WebUIUserConfig.properties";
    public static final String screenshotsPath = "test-output" + File.separator + "ExtentReportOutput" + File.separator + "Screenshots";
    public static final String googleDemoProperties = resourceFolderPath + "WebUILocatorsRepo" + File.separator + "GoogleDemo.properties";
    public static final String MerchantManagementProperties = resourceFolderPath + "WebUILocatorsRepo" + File.separator + "MerchantManagement.properties";
    public static final String PCUILoginProperties = resourceFolderPath + "WebUILocatorsRepo" + File.separator + "LoginPage.properties";
}
