package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisUploadLocalAccPaymentDetails;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadLocalAccPaymentDetailsTest {

    @Test
    public void uploadLocalAccPaymentDetails_TC001() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821397407", GetJWTToken.defaultrequest);
        IrisUploadLocalAccPaymentDetails irisUploadLocalAccPaymentDetails = IrisUploadLocalAccPaymentDetails.getInstance(IrisUploadLocalAccPaymentDetails.defaultRequest);
        irisUploadLocalAccPaymentDetails.getRequest().setHardwareId("0821397407");
        irisUploadLocalAccPaymentDetails.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(irisUploadLocalAccPaymentDetails.getResponse().getResMsg(), "Successfully Updated the local account payment details in DB");
    }

}
