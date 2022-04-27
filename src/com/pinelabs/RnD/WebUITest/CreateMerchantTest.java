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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateMerchantTest {

	static WebDriver driver;
	ManageMerchant ManageMerchantInstance;
	static String mainWindowHandle;
	static Set<String> currentWindowHandles;
	PCUILogin PCUILoginInstance;
	
	@BeforeClass
	public void applicationSetup()
	{	 ManageMerchantInstance= ManageMerchant.getInstance();
	  PCUILoginInstance = PCUILogin.getInstance();		  
			  ManageMerchantInstance.launchBrowser();
		    	PCUILoginInstance.login("prakheragarwal","Pinelabs@123");
		    	ManageMerchantInstance.navigateToCreateMerchant();
	}
	
	  
		
	  @DataProvider
		public Object[][] getTestData() throws EncryptedDocumentException, IOException
		{
			Object TestData[][] = ExcelUtility.readTestData("CreateMerchantTestData");
			return TestData;	}

	  @Test(dataProvider = "getTestData")
	  	public void CreateMerchant(String CM_MerchantNameField,String CM_MerchantTypeDropDown,
	  			String CM_SelfCurrencyDropDown,String CM_Addressfield,String CM_CountryDropDown,String CM_StateDropDown,
	  			String CM_CityDropDown,String CM_PostalCodeField,String CM_FirstContactNameField,
	  			String CM_FirstContactPhoneNumberField,String CM_FirstContactMobileNumber,String CM_FirstContactEmail,
	  			String Test_Scenario_Type) throws InterruptedException{
	    	
	    	ManageMerchantInstance.createMerchant(CM_MerchantNameField,CM_MerchantTypeDropDown,CM_SelfCurrencyDropDown,
	    			CM_Addressfield,CM_CountryDropDown,CM_StateDropDown,CM_CityDropDown,CM_PostalCodeField,
	    			CM_FirstContactNameField,CM_FirstContactPhoneNumberField,CM_FirstContactMobileNumber,
	    			CM_FirstContactEmail,Test_Scenario_Type);
	    	
			/*
			 * ManageMerchantInstance.launchBrowser(); PCUILoginInstance.Approverlogin();
			 * ManageMerchantInstance.ApproveMerchant();
			 */
	    	//ManageMerchantInstance.ApproveMerchant();
	    }
	    
		/*
		 * @Test (description = "Approve a merchant") public void ApproveMerchant()
		 * throws InterruptedException { ManageMerchantInstance.launchBrowser();
		 * PCUILoginInstance.Approverlogin(); ManageMerchantInstance.ApproveMerchant();
		 * SeleniumUtilities.tearDown();
		 * 
		 * }
		 */

	// static Properties MerchantManagementProperties;
	/*
	 * @BeforeTest public void getBrowser() {
	 * 
	 * //driver = new ChromeDriver(); suObj.initialization();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String currentUrl = driver.getCurrentUrl(); WebElement menu =
	 * driver.findElement(By.id("MerchantNodeLi"));
	 * if(currentUrl.equalsIgnoreCase("https://192.168.100.211:8053/LoginPage.aspx")
	 * ) { pcuiAppObj.applicationLogin(driver); }else if (menu.isDisplayed()) {
	 * 
	 * }else { System.out.println("Unexpected Landing"); }
	 * 
	 * }
	 * 
	 * @Test public static void createMerchant() throws InterruptedException {
	 * 
	 * 
	 * try { mainWindowHandle = driver.getWindowHandles().toString(); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * currentWindowHandles = driver.getWindowHandles();
	 * 
	 * pcuiAppObj.createMerchant(driver); driver.wait(4000); String submitMessage =
	 * "Merchant Created Successfully and Request has been sent for Approval.Lat Long could not be updated."
	 * ; String actualMessage =
	 * MerchantManagementProperties.getProperty("messageDisplayed");
	 * 
	 * 
	 * for (String handle : currentWindowHandles) { if
	 * (!mainWindowHandle.equals(handle)) {
	 * 
	 * WebDriver popup = driver.switchTo().window(handle); String messageDisplayed =
	 * driver.findElement(By.xpath("//span[@id='ContentPlaceHolder1_HubMessageID']")
	 * ) .getText(); System.out.print("Message which is dispayed is" +
	 * messageDisplayed); Assert.assertEquals(messageDisplayed, actualMessage);
	 * 
	 * if (messageDisplayed.equalsIgnoreCase(
	 * "Merchant Created Successfully and Request has been sent for Approval.Lat Long could not be updated."
	 * )) { System.out.print("Merchant is created and test is passed"); }
	 * 
	 * popup.close(); } }
	 * 
	 * 
	 * 
	 * }
	 * 
	 */
	  
	 
	
	  
	  @AfterClass
	public void VerifyMerchant() {
		PCUILoginInstance.logout();
	 	SeleniumUtilities.tearDown();
	}
}
