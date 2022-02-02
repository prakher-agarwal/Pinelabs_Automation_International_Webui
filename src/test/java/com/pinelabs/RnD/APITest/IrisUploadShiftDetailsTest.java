package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisUploadShiftDetails;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadShiftDetailsTest {
//ready
    @Test
    public void uploadShiftDetails_TC001(){
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        IrisUploadShiftDetails irisUploadShiftDetails= IrisUploadShiftDetails.getInstance(IrisUploadShiftDetails.defaultRequest);
        irisUploadShiftDetails.getRequest().setHardwareId("0822398347");
        irisUploadShiftDetails.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(irisUploadShiftDetails.getResponse().getResMsg(),"Successfully Uploaded the shift change details in DB");
    }
}
