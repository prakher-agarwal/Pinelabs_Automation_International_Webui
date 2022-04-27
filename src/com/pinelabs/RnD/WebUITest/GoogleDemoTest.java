package com.pinelabs.RnD.WebUITest;

import com.pinelabs.RnD.WebUI.Base.SeleniumUtilities;
import com.pinelabs.RnD.WebUI.POM.GoogleDemo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleDemoTest {
    GoogleDemo googleDemoInstance;
    @BeforeClass
    public void getInstances(){
     googleDemoInstance= GoogleDemo.getInstance();

    }

    @Test
    public void start(){
       googleDemoInstance.launchBrowser();
       googleDemoInstance.searchText("Stephan Hawkins");
    }
}
