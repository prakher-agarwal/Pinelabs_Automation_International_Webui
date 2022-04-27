package com.pinelabs.RnD.WebUI.POM;

import com.pinelabs.RnD.CommonUtils.CommonUtils;
import com.pinelabs.RnD.WebUI.Base.SeleniumUtilities;
import com.pinelabs.RnD.WebUI.Constants.FilePaths;
import java.util.Properties;
import java.util.Set;
import com.pinelabs.RnD.CommonUtils.ExtentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class ManageMerchant extends SeleniumUtilities {
    static ManageMerchant webUInstance;
    String mainWindowHandle;
	Set<String> currentWindowHandles;
	static ManageMerchant ManageMerchantObj;
 	Properties ManageMerchantProperties;
	
 	  private ManageMerchant() {
 		 ManageMerchantProperties = CommonUtils.readPropertyfile(FilePaths.MerchantManagementProperties);
 	    }

 
	
	   public static ManageMerchant getInstance() {
	        if (webUInstance == null)
	            webUInstance = new ManageMerchant();
	        return webUInstance;
	    }

	   
	   public void launchBrowser(){
	        initialization();
	    }
	   
	   public void openMerchantCreationUrl()
	   {
		   driver.get("https://192.168.100.211:8053/CreateMerchantPage.aspx");
	   }
	   public void navigateToCreateMerchant()
	   {
		   clickOnElement(ManageMerchantProperties.getProperty("SideMenuMerchantManagement"));
		   clickOnElement(ManageMerchantProperties.getProperty("SideMenuMerchant"));
		   clickOnElement(ManageMerchantProperties.getProperty("CreateMerchant"));
	   }
	   public void createMerchant(String CM_MerchantNameField,String CM_MerchantTypeDropDown,
	  			String CM_SelfCurrencyDropDown,String CM_Addressfield,String CM_CountryDropDown,String CM_StateDropDown,
	  			String CM_CityDropDown,String CM_PostalCodeField,String CM_FirstContactNameField,
	  			String CM_FirstContactPhoneNumberField,String CM_FirstContactMobileNumber,String CM_FirstContactEmail
	  			,String Test_Scenario_Type) 
	  					throws InterruptedException	  
	   	{
		  // driver.wait(2000);
		   setElementText(ManageMerchantProperties.getProperty("CM_MerchantNameField"),CM_MerchantNameField);
		   select(ManageMerchantProperties.getProperty("CM_MerchantTypeDropDown"),CM_MerchantTypeDropDown);
		   select(ManageMerchantProperties.getProperty("CM_SelfCurrencyDropDown"),CM_SelfCurrencyDropDown);
		   setElementText(ManageMerchantProperties.getProperty("CM_Addressfield"),CM_Addressfield);
		   select(ManageMerchantProperties.getProperty("CM_CountryDropDown"),CM_CountryDropDown);
		   select(ManageMerchantProperties.getProperty("CM_StateDropDown"),CM_StateDropDown);
		   select(ManageMerchantProperties.getProperty("CM_CityDropDown"),CM_CityDropDown);
		   setElementText(ManageMerchantProperties.getProperty("CM_PostalCodeField"),CM_PostalCodeField);
		   setElementText(ManageMerchantProperties.getProperty("CM_FirstContactNameField"),CM_FirstContactNameField);
		   setElementText(ManageMerchantProperties.getProperty("CM_FirstContactPhoneNumberField"),CM_FirstContactPhoneNumberField);
		   setElementText(ManageMerchantProperties.getProperty("CM_FirstContactMobileNumber"),CM_FirstContactMobileNumber);
		   setElementText(ManageMerchantProperties.getProperty("CM_FirstContactEmail"),CM_FirstContactEmail);
			mainWindowHandle = driver.getWindowHandles().toString();
		   clickOnElement(ManageMerchantProperties.getProperty("CM_Button"));
			MerchantCreationSuccessMessage(Test_Scenario_Type);
			openMerchantCreationUrl();


	   }
	   
	   public void MerchantCreationSuccessMessage(String Test_Scenario_Type) throws InterruptedException {
		
			String SuccessMessage = "Merchant Created Successfully and Request has been sent for Approval.Lat Long could not be updated.";
			String merchant_status = null;
			currentWindowHandles = driver.getWindowHandles();
			driver.switchTo().activeElement();
					String messageDisplayed = getTextOfElement(ManageMerchantProperties.getProperty("CM_messageDisplayed"));
					System.out.print("Message which is dispayed is" + messageDisplayed);
					if(messageDisplayed.equalsIgnoreCase(SuccessMessage))		
					{
						merchant_status = "success";
						Assert.assertEquals(merchant_status,Test_Scenario_Type.toLowerCase());
						System.out.print("MerchantCreatedSuccessfully");
						if(getElement(ManageMerchantProperties.getProperty("CM_messageDisplayed")).isDisplayed())
						{
						   clickOnElement(ManageMerchantProperties.getProperty("CM_CloseMessagePopup"));
						}else if(getElement(ManageMerchantProperties.getProperty("Alert_Message")).isDisplayed())
						{
							clickOnElement(ManageMerchantProperties.getProperty("Alert_OkButton"));
						}					
					}else
					{
						merchant_status = "fail";
						Assert.assertEquals(merchant_status,Test_Scenario_Type.toLowerCase());
						System.out.print("Merchant creation unsccessfull");	
						if(getElement(ManageMerchantProperties.getProperty("CM_messageDisplayed")).isDisplayed())
						{
						   clickOnElement(ManageMerchantProperties.getProperty("CM_CloseMessagePopup"));
						}else if(getElement(ManageMerchantProperties.getProperty("Alert_Message")).isDisplayed())
						{
							clickOnElement(ManageMerchantProperties.getProperty("Alert_OkButton"));
						}
					}
					//driver.wait(1000);

				}
	   public void NavigateToApproveMerchant()
	   {
		   clickOnElement(ManageMerchantProperties.getProperty("SideMenuMerchantManagement"));
		   clickOnElement(ManageMerchantProperties.getProperty("SideMenuMerchant"));
		   clickOnElement(ManageMerchantProperties.getProperty("ApproveMerchant"));   
	   }
	   public void ApproveMerchant(String AM_MerchantNameField) throws InterruptedException
	   {	
		   mainWindowHandle = driver.getWindowHandle().toString();
		   setElementText(ManageMerchantProperties.getProperty("AM_MerchantNameField"),AM_MerchantNameField);
		   clickOnElement(ManageMerchantProperties.getProperty("AM_SearchButton"));
		   if(elementDisplayed(ManageMerchantProperties.getProperty("AM_ApproveButton")))
		   {
			   System.out.print("Merchant Found");
			   clickOnElement(ManageMerchantProperties.getProperty("AM_ApproveButton"));
			   	  currentWindowHandles = driver.getWindowHandles();
			   	  for (String handle : currentWindowHandles) { 
			   		if(!mainWindowHandle.equals(handle)) {
			   			driver.switchTo().window(handle);
				clickOnElement(ManageMerchantProperties.getProperty("AM_PopUp_ApproveButton"));
				driver.switchTo().activeElement();
				clickOnElement(ManageMerchantProperties.getProperty("AM_ApprovalConfirmationSaveButton"));
		   }
			   	  }
		   }else
		   {
			   System.out.print("No Merchant Found");
		   }
	   }
	   
	   
	   public void MerchantApprovalMessageValidation(String Test_Scenario_Type) throws InterruptedException 
	   {
	
				String Approval_Status = null;
				driver.switchTo().activeElement();
					String messageDisplayed = getTextOfElement(ManageMerchantProperties.getProperty("AM_messageDisplayed"));
					System.out.print("Message which is dispayed is" + messageDisplayed);
					if((messageDisplayed.toLowerCase()).startsWith("Merchant Approved Successfully with MerchantID"))		
					{
						Approval_Status = "success";
						Assert.assertEquals(Approval_Status,Test_Scenario_Type.toLowerCase());
						System.out.print("Merchant Approved Successfully");
						   clickOnElement(ManageMerchantProperties.getProperty("AM_PopUp_SaveButton"));
					}else if((messageDisplayed.toLowerCase()).startsWith("Same User can not Approve Merchant Creation or Updation Request."))
					{
						Approval_Status = "fail";
						Assert.assertEquals(Approval_Status,Test_Scenario_Type.toLowerCase());
						System.out.print("Merchant creation unsuccessfull");	
						   clickOnElement(ManageMerchantProperties.getProperty("AM_PopUp_SaveButton"));
					}else if((messageDisplayed.toLowerCase()).startsWith("No Merchant Found"));
					{
						Approval_Status = "fail";
						Assert.assertEquals(Approval_Status,Test_Scenario_Type.toLowerCase());
						System.out.print("Merchant creation unsuccessfull");	
						   clickOnElement(ManageMerchantProperties.getProperty("AM_Alert_OKButton"));
					}
					
		}

	   public void openMerchantApprovalUrl()
	   {
		   driver.get("https://192.168.100.211:8053/MerchantApprovalMasterPage.aspx");
	   }
	   
	   public void RejectMerchant(String AM_MerchantNameField)
	   {

		   mainWindowHandle = driver.getWindowHandle().toString();
		   setElementText(ManageMerchantProperties.getProperty("AM_MerchantNameField"),AM_MerchantNameField);
		   clickOnElement(ManageMerchantProperties.getProperty("AM_SearchButton"));
		   if(elementDisplayed(ManageMerchantProperties.getProperty("AM_ApproveButton")))
		   {
			   System.out.print("Merchant Found");
			   clickOnElement(ManageMerchantProperties.getProperty("AM_ApproveButton"));
			   	  currentWindowHandles = driver.getWindowHandles();
			   	  for (String handle : currentWindowHandles) { 
			   		if(!mainWindowHandle.equals(handle)) {
			   			driver.switchTo().window(handle);
				clickOnElement(ManageMerchantProperties.getProperty("AM_PopUp_RejectButton"));
				driver.switchTo().activeElement();
				setElementText(ManageMerchantProperties.getProperty("AM_RejectReason"),"Automated");
				clickOnElement(ManageMerchantProperties.getProperty("AM_SaveRejectReason"));
				if(getElement(ManageMerchantProperties.getProperty("Alert_Message")).getText().equalsIgnoreCase("Merchant Creation or Updation Request is successfully Rejected."))
				{
					clickOnElement(ManageMerchantProperties.getProperty("Alert_OkButton"));
				}else
				{
					System.out.print("Merchant Rejection Failed");
				}
		   }
			   	  }
		   }else
		   {
			   System.out.print("No Merchant Found");
		   }
	   }
}
