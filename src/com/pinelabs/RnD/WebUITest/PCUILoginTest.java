package com.pinelabs.RnD.WebUITest;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.pinelabs.RnD.CommonUtils.ExcelUtility;
import com.pinelabs.RnD.WebUI.Base.SeleniumUtilities;
import com.pinelabs.RnD.WebUI.POM.GoogleDemo;
import com.pinelabs.RnD.WebUI.POM.ManageMerchant;
import com.pinelabs.RnD.WebUI.POM.PCUILogin;
import com.pinelabs.RnD.WebUI.POM.PcuiApplication;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PCUILoginTest {

	static WebDriver driver;
	static String mainWindowHandle;
	static Set<String> currentWindowHandles;
	PCUILogin PCUILoginInstance;
	
	@BeforeMethod
    public void getInstances(){
	  PCUILoginInstance = PCUILogin.getInstance();
	  PCUILoginInstance.launchBrowser();
    }
	@DataProvider
	public Object[][] getTestData() throws EncryptedDocumentException, IOException
	{
		Object TestData[][] = ExcelUtility.readTestData("LoginTestData");
		return TestData;	}
	
	
	@Test(dataProvider = "getTestData")
	public void login(String userName, String password, String scenario)
	{
		PCUILoginInstance.login(userName,password);
		PCUILoginInstance.login_validation(scenario);
	}
	@AfterMethod
	public void tear()
	{
		SeleniumUtilities.tearDown();	
	}

}
