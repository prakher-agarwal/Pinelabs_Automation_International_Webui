package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.AndroidTest.TestUtils;
import com.pinelabs.RnD.CommonUtils.ExtentSparkReport;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.StringWriter;

public class GetJWTTest extends TestUtils {
    GetJWTToken getJWTToken;

    @BeforeClass
    public void getInstances() {
        getJWTToken = GetJWTToken.getInstance(GetJWTToken.defaultrequest);

    }
    @BeforeSuite
    public void launch() {
        ExtentSparkReport.initialise();
    }
    @Test(description = "Validate the response when all the parameters are correct")
    public void getJWTToke_TC001() {

        getJWTToken.getRequest().setHardwareid("0822398347");
        getJWTToken.getRequest().setDevicesubtype("82");
        getJWTToken.createAndExecute();
        String token = getJWTToken.getResponse().getAccessToken().toString();
        System.out.println(token);
    }

    @Test(description = "Validate the response when hardwareID is not sent")
    public void getJWTToke_TC002() {
        getJWTToken.getRequest().setHardwareid(null);
        getJWTToken.getRequest().setDevicesubtype("82");
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertTrue(getJWTToken.getResponse().getErrCode() == 6);
    }

    @Test(description = "Validate the response when hardwareID is sent empty")
    public void getJWTToke_TC003() {
        getJWTToken.getRequest().setHardwareid("");
        getJWTToken.getRequest().setDevicesubtype("82");
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getResponse().getAccessToken(), "null");
        Assert.assertEquals(getJWTToken.getResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertEquals(getJWTToken.getResponse().getErrCode(), "6");
    }

    @Test(description = "Validate the response when deviceSubType is sent empty")
    public void getJWTToke_TC004() {
        getJWTToken.getRequest().setHardwareid("0822398347");
        getJWTToken.getRequest().setDevicesubtype("");
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getResponse().getAccessToken(), "null");
        Assert.assertEquals(getJWTToken.getResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertEquals(getJWTToken.getResponse().getErrCode(), "6");

    }

    @Test(description = "Validate the response when deviceSubType is not sent ")
    public void getJWTToke_TC005() {
        getJWTToken.getRequest().setHardwareid("0822398347");
        getJWTToken.getRequest().setDevicesubtype(null);
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getResponse().getAccessToken(), "null");
        Assert.assertEquals(getJWTToken.getResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertEquals(getJWTToken.getResponse().getErrCode(), "6");

    }


}
