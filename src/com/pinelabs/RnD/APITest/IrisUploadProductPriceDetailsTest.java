package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisUploadProductPriceDetails;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadProductPriceDetailsTest {
    @Test
    public void uploadProductPriceDetail() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        IrisUploadProductPriceDetails irisUploadProductPriceDetails = IrisUploadProductPriceDetails.getInstance(IrisUploadProductPriceDetails.defaultRequest);
        irisUploadProductPriceDetails.getRequest().setHardwareId("0822398347");
        irisUploadProductPriceDetails.createAndExecute(getJWTResponse.getAccessToken().toString());
        Assert.assertEquals(irisUploadProductPriceDetails.getResponse().getResMsg(), "Successfully uploaded the product price details in DB");
    }
}
