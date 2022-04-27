package com.pinelabs.RnD.WebUITest;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pinelabs.RnD.CommonUtils.ExcelUtility;
import com.pinelabs.RnD.WebUI.Base.SeleniumUtilities;
import com.pinelabs.RnD.WebUI.POM.ManageMerchant;
import com.pinelabs.RnD.WebUI.POM.PCUILogin;

public class ApproveMerchantTest {

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
		    	ManageMerchantInstance.NavigateToApproveMerchant();
	}
	  
	  @DataProvider
		public Object[][] getTestData() throws EncryptedDocumentException, IOException
		{
			Object TestData[][] = ExcelUtility.readTestData("ApproveMerchantTestData");
			return TestData;	
		}

	  @Test(dataProvider = "getTestData")
	  	public void ApproveMerchant(String AM_MerchantNameField,String Test_Scenario_Type) throws InterruptedException
	   { 	
	    	ManageMerchantInstance.ApproveMerchant(AM_MerchantNameField);
	    	ManageMerchantInstance.MerchantApprovalMessageValidation(Test_Scenario_Type);
	    	ManageMerchantInstance.openMerchantApprovalUrl();
	    }
	    
		@Test(dataProvider="getTestData")
		public void rejectMerchant(String AM_MerchantNameField,String Test_Scenario_Type)
		{
			ManageMerchantInstance.RejectMerchant(AM_MerchantNameField);
		}
	  
	 
	@AfterClass
	public void closeInstance() {
		PCUILoginInstance.logout();
	 	SeleniumUtilities.tearDown();
	}

}
