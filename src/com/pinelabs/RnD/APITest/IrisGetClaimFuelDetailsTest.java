package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisGetClaimFuelDetails;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import com.pinelabs.RnD.API.PojoFiles.IrisUploadBookFuelDetailsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisGetClaimFuelDetailsTest {
    //Need fix
    @Test(description = "Validate if fuel status is fetched successfully when all the params are passed correctly")
    public void getClaimFuel_TC001() {
        IrisGetClaimFuelDetails irisGetClaimFuelDetails = IrisGetClaimFuelDetails.getInstance(IrisGetClaimFuelDetails.defaultRequest);
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0820686904", GetJWTToken.defaultrequest);
        IrisUploadBookFuelDetailsResponse irisUploadBookFuelDetailsResponse = IrisAPIHelpers.uploadBookFuelDetails("0820686904", getJWTResponse.getAccessToken().toString());
        irisGetClaimFuelDetails.getRequestPojo().setHardwareId("0820686904");
        irisGetClaimFuelDetails.getRequestPojo().setROid(180664);
        irisGetClaimFuelDetails.getRequestPojo().setQrStr(irisUploadBookFuelDetailsResponse.getQrStr());
        irisGetClaimFuelDetails.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(irisGetClaimFuelDetails.getResponsePojo().getResMsg(), "Claimed Successfully");

    }
}
