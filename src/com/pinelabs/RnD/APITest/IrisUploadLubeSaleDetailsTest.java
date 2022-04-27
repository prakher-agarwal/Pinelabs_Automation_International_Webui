package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisUploadLubeSaleDetails;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadLubeSaleDetailsTest {
//ready
    @Test
    public void uploadLubeSaleDetails_TC001() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisUploadLubeSaleDetails irisUploadLubeSaleDetails = IrisUploadLubeSaleDetails.getInstance(IrisUploadLubeSaleDetails.defaultRequest);
        irisUploadLubeSaleDetails.getRequest().setHardwareId("0821396591");
        irisUploadLubeSaleDetails.createAndExecute(getJWTResponse.getResMsg());
        Assert.assertEquals(irisUploadLubeSaleDetails.getResponse().getResMsg(), "Successfully Uploaded the dry stock details in DB");

    }
}
