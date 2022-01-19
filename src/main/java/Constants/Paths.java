package Constants;

import java.io.File;

public class Paths {
    public static final String resourceFolderPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public static final String devicePropertiesPath= resourceFolderPath + "CommonProperties" + File.separator+ "Device.properties";
    public static final String apiPropertiesPath= resourceFolderPath + "CommonProperties" + File.separator+ "API.properties";
    public static final String dbPropertiesPath= resourceFolderPath + "Database" + File.separator+ "db.properties";
    public static final String commonLocPropertiesPath= resourceFolderPath + "LocatorsRepo" + File.separator+ "CommonLocators.properties";
    public static final String deviceHomePropertiesPath= resourceFolderPath + "LocatorsRepo" + File.separator+ "DeviceHome.properties";
    public static final String irisHomePropertiesPath= resourceFolderPath + "LocatorsRepo" + File.separator+ "IrisHome.properties";
    public static final String irisSettingsPropertiesPath= resourceFolderPath + "LocatorsRepo" + File.separator+ "IrisSettings.properties";
    public static final String amazonPayPropertiesPath= resourceFolderPath + "LocatorsRepo" + File.separator+ "Payments_AmazonPay.properties";
    public static final String upiPayPropertiesPath= resourceFolderPath + "LocatorsRepo" + File.separator+ "Payments_UPIPay.properties";
    public static final String extentReportPath="C:\\Users\\vanshika.chauhan\\IdeaProjects\\Alp_Automation_Testing\\target\\extentReportsOutput\\";
public static final String extentReportScreenshot="C:\\Users\\vanshika.chauhan\\IdeaProjects\\Alp_Automation_Testing\\target\\extentReportsOutput\\screenshot\\";
}
