package com.pinelabs.RnD.WebUI.POM;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pinelabs.RnD.CommonUtils.CommonUtils;
import com.pinelabs.RnD.WebUI.Base.SeleniumUtilities;
import com.pinelabs.RnD.WebUI.Constants.FilePaths;

import junit.framework.Assert;

public class PCUILogin extends SeleniumUtilities{
	
	static PCUILogin webUInstance;

	//static PCUILogin ManageMerchantObj;
 	Properties PCUILoginProperties;
 	String mainWindowHandle;
	
 	  private PCUILogin() {
 		 PCUILoginProperties = CommonUtils.readPropertyfile(FilePaths.PCUILoginProperties);
 	    }

 
	
	   public static PCUILogin getInstance() {
	        if (webUInstance == null)
	            webUInstance = new PCUILogin();
	        return webUInstance;
	    }

	   
	   public void launchBrowser(){
	        initialization();
	    }
	   public void logout()
	   {
		   clickOnElement(PCUILoginProperties.getProperty("Welcome_User"));
		   clickOnElement(PCUILoginProperties.getProperty("logoutButton"));
		   
	   }

		/*
		 * public void enterCredentials() {
		 * clickOnElement(PCUILoginProperties.getProperty("usernamefield"));
		 * setElementText(PCUILoginProperties.getProperty("usernamefield"),
		 * "prakher.agarwal");
		 * clickOnElement(PCUILoginProperties.getProperty("passwordfield"));
		 * setElementText(PCUILoginProperties.getProperty("passwordfield"),
		 * "Pinelabs@123");
		 * 
		 * }
		 */
	   
	   public void enterCredentials(String username, String password)
	    {
	        clickOnElement(PCUILoginProperties.getProperty("usernamefield"));
	        setElementText(PCUILoginProperties.getProperty("usernamefield"), username);
	        clickOnElement(PCUILoginProperties.getProperty("passwordfield"));
	        setElementText(PCUILoginProperties.getProperty("passwordfield"), password);
	        
	    }
		
		  public void login(String username, String password) {
			  enterCredentials(username,password);
		  clickOnElement(PCUILoginProperties.getProperty("loginButton")); }
		 
	   

		  
		public void login_validation(String scenario){
	
				String expectedMessage;
				String messageDisplayed;
				
		 	if(scenario.equalsIgnoreCase("blocked"))
			 {driver.switchTo().activeElement();
					 expectedMessage = "Your Account Is Blocked by System, Please Contact System Administrator.";
					 messageDisplayed = getTextOfElement(PCUILoginProperties.getProperty("Alert_Login_Message"));
						System.out.print(messageDisplayed);
						Assert.assertEquals(expectedMessage, messageDisplayed);
						System.out.print("Account is blocked");
		 }else if(scenario.equalsIgnoreCase("Invalid Credentials"))
		 {driver.switchTo().activeElement();
		 expectedMessage = "Invalid UserName/Password.";
		 messageDisplayed = getTextOfElement(PCUILoginProperties.getProperty("Alert_Login_Message"));
		 System.out.print(messageDisplayed);
			Assert.assertEquals(expectedMessage, messageDisplayed);
			System.out.print("Invalid Credentials");

		 }else if(scenario.equalsIgnoreCase("Valid Credentials"))
		 {	
				Assert.assertEquals("https://192.168.100.211:8053/WelcomePageUI.aspx", driver.getCurrentUrl());
				 System.out.print("User logs in successfully");
				 logout();
		 }else {
			 System.out.print("Need to add scenario");
		 }
		   //clickOnElement(PCUILoginProperties.getProperty("loginButton")); 
		  
		  }
		 
	   
	   public void ApproverCredentials()
	    {
	        clickOnElement(PCUILoginProperties.getProperty("usernamefield"));
	        setElementText(PCUILoginProperties.getProperty("usernamefield"), "prakheragarwal");
	        clickOnElement(PCUILoginProperties.getProperty("passwordfield"));
	        setElementText(PCUILoginProperties.getProperty("passwordfield"),  "Pinelabs@123");
	        
	    }
	  
	   
	   public void Approverlogin()
	   { 
		   ApproverCredentials();
		   clickOnElement(PCUILoginProperties.getProperty("loginButton"));
	   }
	   
	   public String getCaptchaText() {
	        String captchatext = null;
	        try {
	            WebElement imageelement=getElement(PCUILoginProperties.getProperty("captcha"));
	            File src = new File(captureScreenshot(imageelement));
	            ITesseract tess = new Tesseract();
	            String path=System.getProperty("user.dir")+"/captchaimages/captcha.png";
	            FileUtils.copyFile(src, new File(path));
	            System.out.println("Tesseract");
	            captchatext = tess.doOCR(new File(path));
	            System.out.println(captchatext);
	            String finaltext = captchatext.replaceAll("[^a-zA-Z0-9]","");
	            System.out.println(finaltext);
	            Thread.sleep(5000);
	            System.out.println("CaptchaText: " + finaltext);
	        } catch (Exception e) {
	            System.out.println(e.getMessage().toString());
	            e.printStackTrace();
	        }
	        return captchatext;

	    }
	    public void enterCaptcha() {
	        String captchaValue= getCaptchaText();
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        clickOnElement(PCUILoginProperties.getProperty("enterText"));
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        setElementText(PCUILoginProperties.getProperty("enterText"), captchaValue);
	        

	    }
	    
	    public String captureScreenshot(WebElement element) throws IOException
	    {
	        WebElement imageelement=getElement(PCUILoginProperties.getProperty("captcha"));
	        //TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File src = imageelement.getScreenshotAs(OutputType.FILE);
	        String path=System.getProperty("user.dir")+"/captchascreenshots/captcha.png";
	        File dest = new File(path);
	            FileUtils.copyFile(src, dest);
	        return path;

	    }
	   
}
