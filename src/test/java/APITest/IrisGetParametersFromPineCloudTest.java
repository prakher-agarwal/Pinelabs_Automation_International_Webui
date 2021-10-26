package APITest;

import Base.CommonUtils;
import API.Helpers.IrisAPIHelpers;
import API.PojoFiles.GetJWTResponse;
import TestBase.TestUtils;
import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisGetParametersFromPineCloudTest extends TestUtils {
    Document dbValues;

    public void db() {
        Document dbValues = CommonUtils.findRowBasedOnColumn("PL_IRIS_APP_BASIC_PARAMETERS_COLLECTIONS", "HARDWARE_ID", "0820686904");

    }

    @Test(description = "Validate the response when all the parameters are correct")
    public void getParamFromPineCloud_TC001() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken();
        TestUtils.getIrisGetParametersFromPineCloud.getRequestPojo().setHardwareid("0822398347");
        TestUtils.getIrisGetParametersFromPineCloud.createAndExecute(getJWTResponse.getAccessToken());
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getBpclCloudUrl(), "https://bpcluatwap01.azurewebsites.net");
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getPineCloudUrl(), "https://14.141.92.54:8202");
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getAlpCloudUrl(), "http://122.160.150.44:9090");
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getROid(), "180664");
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getResMsg(), "Iris Basic Parameters Successfully feched from DB");
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getVmsCloudUrl(), "https://api.vms.bpcl.in");
    }

    @Test(description = "Validate the response when hardwareID is empty")
    public void getParamFromPineCloud_TC002() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken();
        TestUtils.getIrisGetParametersFromPineCloud.getRequestPojo().setHardwareid("");
        TestUtils.getIrisGetParametersFromPineCloud.createAndExecute(getJWTResponse.getAccessToken());
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getResMsg(), "Client is blocked from PCUI end");
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getErrCode(), "401");
    }

    @Test(description = "Validate the response when hardwareID is not sent")
    public void getParamFromPineCloud_TC003() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken();
        TestUtils.getIrisGetParametersFromPineCloud.getRequestPojo().setHardwareid(null);
        TestUtils.getIrisGetParametersFromPineCloud.createAndExecute(getJWTResponse.getAccessToken());
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getResMsg(), "Client is blocked from PCUI end");
        Assert.assertEquals(TestUtils.getIrisGetParametersFromPineCloud.getResponsePojo().getErrCode(), "401");
    }


}
