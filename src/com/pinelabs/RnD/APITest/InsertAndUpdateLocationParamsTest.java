package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.InsertAndUpdateLocationParams;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InsertAndUpdateLocationParamsTest {
    @Test(description = "Validate is user is able to insert data in database")
    public void insertAndUpdateLocationParam_TC001() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("0822398347");
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Successfully inserted locations params in DB");

    }


    @Test(description = "Validate is user is able to update existing data in database")
    public void insertAndUpdateLocationParam_TC002() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("0822398347");
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Hardware location details already saved");

    }

    @Test(description = "Validate the response when no hardware ID is sent")
    public void insertAndUpdateLocationParam_TC003() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("");
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Client is blocked from PCUI end");

    }

    @Test(description = "Validate if hardware ID paramter is not sent")
    public void insertAndUpdateLocationParam_TC004() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid(null);
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Client is blocked from PCUI end");

    }

    @Test(description = "Validate the response when no latitude is sent")
    public void insertAndUpdateLocationParam_TC005() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("0822398347");
        insertAndUpdateLocationParams.getRequestPojo().setLatitude("");
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Invalid Parameter request");

    }

    @Test(description = "Validate the response when no longitude is sent")
    public void insertAndUpdateLocationParam_TC006() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("0822398347");
        insertAndUpdateLocationParams.getRequestPojo().setLongitude("");
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Invalid Parameter request");

    }

    @Test(description = "Validate if only hardware id is sent")
    public void insertAndUpdateLocationParam_TC007() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("0822398347");
        insertAndUpdateLocationParams.getRequestPojo().setLatitude(null);
        insertAndUpdateLocationParams.getRequestPojo().setLongitude(null);
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Invalid Parameter request");

    }

    @Test(description = "validate if invalid latitude is sent")
    public void insertAndUpdateLocationParam_TC008() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("0822398347");
        insertAndUpdateLocationParams.getRequestPojo().setLatitude("abcd");
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Invalid Parameter request");

    }

    @Test(description = "Validate if invalid longitude is sent")
    public void insertAndUpdateLocationParam_TC009() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        InsertAndUpdateLocationParams insertAndUpdateLocationParams = InsertAndUpdateLocationParams.getInstance(InsertAndUpdateLocationParams.defaultRequest);
        insertAndUpdateLocationParams.getRequestPojo().setHardwareid("0822398347");
        insertAndUpdateLocationParams.getRequestPojo().setLongitude("bshsk2");
        insertAndUpdateLocationParams.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(insertAndUpdateLocationParams.getResponsePojo().getResMsg(), "Invalid Parameter request");

    }
}
