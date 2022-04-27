package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisGetParametersFromPineCloud;
import com.pinelabs.RnD.CommonUtils.CommonUtils;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IrisGetParametersFromPineCloudTest extends TestUtilAPI {

    IrisGetParametersFromPineCloud irisGetParametersFromPineCloud;
    Document dbValues;

    public void db() {
        Document dbValues = CommonUtils.findRowBasedOnColumn("PL_IRIS_APP_BASIC_PARAMETERS_COLLECTIONS", "HARDWARE_ID", "0820686904");

    }

    @BeforeClass
    public void initialise() {

    }

    @Test(description = "Validate the response when all the parameters are correct")
    public void getParamFromPineCloud_TC001() {
        irisGetParametersFromPineCloud = getIrisGetParametersFromPineCloud(IrisGetParametersFromPineCloud.defaultRequest);
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0820771204",  GetJWTToken.defaultrequest);
        irisGetParametersFromPineCloud.getRequestPojo().setHardwareid("0820771204");
        irisGetParametersFromPineCloud.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getBpclCloudUrl(), "https://bpcluatwap01.azurewebsites.net");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getPineCloudUrl(), "https://14.141.92.54:8202");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getAlpCloudUrl(), "http://122.160.150.44:9090");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getROid(), "180664");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getResMsg(), "Iris Basic Parameters Successfully feched from DB");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getVmsCloudUrl(), "https://api.vms.bpcl.in");
    }

    @Test(description = "Validate the response when hardwareID is empty")
    public void getParamFromPineCloud_TC002() {
        //   GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken();
        irisGetParametersFromPineCloud.getRequestPojo().setHardwareid("");
        irisGetParametersFromPineCloud.createAndExecute("eyJhbGciOiJIUzI1NiJ9.VTJGc2RHVmtYMS9ya00vMGMzdWtKQytCNE9QWEdnV2pjV0gvREpsaXhTZTUvSDVpYWhWV29zZE5lZW1MVFlFSjV1OGF2MDlCU2JJTS9LSDZlZ0hBbHN0LzA1V3RWN3MrcllsSXFyYmtGczg9.HKIXBN-H4WYeN__D-cRvDUWQkCEM2wZ7Bj_Rne_isds");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getResMsg(), "Client is blocked from PCUI end");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getErrCode(), "401");
    }

    @Test(description = "Validate the response when hardwareID is not sent")
    public void getParamFromPineCloud_TC003() {
        //    GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken();
        irisGetParametersFromPineCloud.getRequestPojo().setHardwareid(null);
        irisGetParametersFromPineCloud.createAndExecute("eyJhbGciOiJIUzI1NiJ9.VTJGc2RHVmtYMS9ya00vMGMzdWtKQytCNE9QWEdnV2pjV0gvREpsaXhTZTUvSDVpYWhWV29zZE5lZW1MVFlFSjV1OGF2MDlCU2JJTS9LSDZlZ0hBbHN0LzA1V3RWN3MrcllsSXFyYmtGczg9.HKIXBN-H4WYeN__D-cRvDUWQkCEM2wZ7Bj_Rne_isds");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getResMsg(), "Client is blocked from PCUI end");
        Assert.assertEquals(TestUtilAPI.getIrisGetParametersFromPineCloud.getResponsePojo().getErrCode(), "401");
    }


}
