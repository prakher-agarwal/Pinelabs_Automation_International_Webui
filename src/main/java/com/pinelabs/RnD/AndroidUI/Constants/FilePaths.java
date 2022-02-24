package com.pinelabs.RnD.AndroidUI.Constants;

import java.io.File;

public class FilePaths {
    public static final String resourceFolderPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public static final String devicePropertiesPath = resourceFolderPath + "CommonProperties" + File.separator + "AndroidDevice.properties";
    public static final String apiPropertiesPath = resourceFolderPath + "CommonProperties" + File.separator + "API.properties";
    public static final String dbPropertiesPath = resourceFolderPath + "Database" + File.separator + "db.properties";
    public static final String commonLocPropertiesPath = resourceFolderPath + "AndroidLocatorsRepo" + File.separator + "CommonLocators.properties";
    public static final String deviceHomePropertiesPath = resourceFolderPath + "AndroidLocatorsRepo" + File.separator + "DeviceHome.properties";
    public static final String irisHomePropertiesPath = resourceFolderPath + "AndroidLocatorsRepo" + File.separator + "IrisHome.properties";
    public static final String irisSettingsPropertiesPath = resourceFolderPath + "AndroidLocatorsRepo" + File.separator + "IrisSettings.properties";
    public static final String amazonPayPropertiesPath = resourceFolderPath + "AndroidLocatorsRepo" + File.separator + "Payments_AmazonPay.properties";
    public static final String upiPayPropertiesPath = resourceFolderPath + "AndroidLocatorsRepo" + File.separator + "Payments_UPIPay.properties";
    public static final String extenthtmlReportPath = System.getProperty("user.dir") + File.separator + "extentReportsOutput" + File.separator + "htmlReports" + File.separator;
    public static final String extentReportProperties = resourceFolderPath + "CommonProperties" + File.separator + "ExtentReports.properties";
    public static final String screenshotsPath = System.getProperty("user.dir") + File.separator + "extentReportsOutput" + File.separator + "screenshots" + File.separator;
    public static final String jsonFilePath = resourceFolderPath + File.separator + "TestData" + File.separator + "JSONData.json";
    public static final String excelDataProperties = resourceFolderPath + "CommonProperties" + File.separator + "ExcelSheet.properties";
    public static final String excelDataFile = "D:\\Projects\\ParagonAutomationFramework\\ParagonAutomationFramework\\src\\main\\resources\\TestData";

}
