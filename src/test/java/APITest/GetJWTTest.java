package APITest;

import API.Builders.GetJWTToken;
import TestBase.TestUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetJWTTest extends TestUtils {
    GetJWTToken getJWTToken;
    @BeforeClass
    public void getInstances(){
       getJWTToken=  GetJWTToken.getInstance(GetJWTToken.defaultrequest);
    }

    @Test(description = "Validate the response when all the parameters are correct")
    public void getJWTToke_TC001() {

        getJWTToken.getJwtRequest().setHardwareid("0822398347");
        getJWTToken.getJwtRequest().setDevicesubtype("82");
        getJWTToken.createAndExecute();
        String token = getJWTToken.getJWTResponse().getAccessToken();
        System.out.println(token);

    }

    @Test(description = "Validate the response when hardwareID is not sent")
    public void getJWTToke_TC002() {
        getJWTToken.getJwtRequest().setHardwareid(null);
        getJWTToken.getJwtRequest().setDevicesubtype("82");
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getJWTResponse().getAccessToken(), "null");
        Assert.assertEquals(getJWTToken.getJWTResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertEquals(getJWTToken.getJWTResponse().getErrCode(), "6");

    }

    @Test(description = "Validate the response when hardwareID is sent empty")
    public void getJWTToke_TC003() {
        getJWTToken.getJwtRequest().setHardwareid("");
        getJWTToken.getJwtRequest().setDevicesubtype("82");
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getJWTResponse().getAccessToken(), "null");
        Assert.assertEquals(getJWTToken.getJWTResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertEquals(getJWTToken.getJWTResponse().getErrCode(), "6");


    }

    @Test(description = "Validate the response when deviceSubType is sent empty")
    public void getJWTToke_TC004() {
        getJWTToken.getJwtRequest().setHardwareid("0822398347");
        getJWTToken.getJwtRequest().setDevicesubtype("");
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getJWTResponse().getAccessToken(), "null");
        Assert.assertEquals(getJWTToken.getJWTResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertEquals(getJWTToken.getJWTResponse().getErrCode(), "6");

    }

    @Test(description = "Validate the response when deviceSubType is not sent ")
    public void getJWTToke_TC005() {
        getJWTToken.getJwtRequest().setHardwareid("0822398347");
        getJWTToken.getJwtRequest().setDevicesubtype(null);
        getJWTToken.createAndExecute();
        Assert.assertEquals(getJWTToken.getJWTResponse().getAccessToken(), "null");
        Assert.assertEquals(getJWTToken.getJWTResponse().getResMsg(), "Invalid Parameter request");
        Assert.assertEquals(getJWTToken.getJWTResponse().getErrCode(), "6");

    }


}
