package com.pinelabs.RnD.WebUI.POM;

import com.pinelabs.RnD.CommonUtils.CommonUtils;
import com.pinelabs.RnD.WebUI.Base.SeleniumUtilities;
import com.pinelabs.RnD.WebUI.Constants.FilePaths;
//import com.pinelabs.RnD.WebUITest.Select;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class PcuiApplication {
	Properties loginPageProperties;
	Properties MerchantManagementProperties;
	SeleniumUtilities suObj = new SeleniumUtilities(); 
	public void applicationLogin(WebDriver driver)
	{
		String usernameField = loginPageProperties.getProperty("usernamefield"); 
		String passwordfield = loginPageProperties.getProperty("passwordfield"); 
		String loginButton = loginPageProperties.getProperty("loginButton"); 
		suObj.setElementText(usernameField,"prakher.agarwal");
		suObj.setElementText(passwordfield,"Pinelabs@123");
		suObj.clickOnElement(loginButton);
	}
	
	public void createMerchant(WebDriver driver)
	{
		suObj.setElementText("MerchantManagementProperties.getProperty('MerchantNameField')","MerchantName1");
		suObj.select("MerchantManagementProperties.getProperty('MerchantTypeDropDown')","CIMB");
		//driver.findElement(MerchantNameField).sendKeys(MerchantNameFieldValue);
		//Select MTDropDown = new Select(driver.findElement(MerchantTypeDropDown));
		//MTDropDown.selectByVisibleText(MerchantTypeFieldValue);
		suObj.select("MerchantManagementProperties.getProperty('SelfCurrencyDropDown')","RM");
		//Select SCDropDown = new Select(driver.findElement(SelfCurrencyDropDown));
		// dlObj.waitUntilElementClickable(driver, "selectByVisibleText",
		// SelfCurrencyDropDownValue);

		//SCDropDown.selectByVisibleText(SelfCurrencyDropDownValue);
		suObj.setElementText("MerchantManagementProperties.getProperty('Addressfield')","Address Auto Filled");
		//driver.findElement(Addressfield).sendKeys(AddressfieldValue);
		suObj.select("MerchantManagementProperties.getProperty('CountryDropDownValue')","Malaysia");
		//Select CoDropDown = new Select(driver.findElement(CountryDropDown));
		//CoDropDown.selectByVisibleText(CountryDropDownValue);
		suObj.select("MerchantManagementProperties.getProperty('StateDropDown')","Johor");
		//Select SDropDown = new Select(driver.findElement(StateDropDown));
		//SDropDown.selectByVisibleText(StateDropDownValue);
		suObj.select("MerchantManagementProperties.getProperty('CityDropDown')","MUAR");
		//Select CiDropDown = new Select(driver.findElement(CityDropDown));
		//CiDropDown.selectByVisibleText(CityDropDownValue);
		suObj.setElementText("MerchantManagementProperties.getProperty('PostalCodeField')","201001");

		//driver.findElement(PostalCodeField).sendKeys(PostalCodeFieldValue);
		suObj.setElementText("MerchantManagementProperties.getProperty('FirstContactNameField')","Automated");
		//driver.findElement(FirstContactNameField).sendKeys(FirstContactNameFieldValue);
		suObj.setElementText("MerchantManagementProperties.getProperty('FirstContactPhoneNumberField')","9999999998");
		//driver.findElement(FirstContactPhoneNumberField).sendKeys(FirstContactPhoneNumberFieldValue);
		suObj.setElementText("MerchantManagementProperties.getProperty('FirstContactMobileNumber')","9999999998");
		//driver.findElement(FirstContactMobileNumber).sendKeys(FirstContactMobileNumberValue);
		suObj.setElementText("MerchantManagementProperties.getProperty('FirstContactEmail')","a@d.com");
		//driver.findElement(FirstContactEmail).sendKeys(FirstContactEmailValue);
		suObj.clickOnElement("MerchantManagementProperties.getProperty('ButtonCreateMerchant')");
		//driver.findElement(By.id("ButtonCreateMerchant")).click();


	}
}
