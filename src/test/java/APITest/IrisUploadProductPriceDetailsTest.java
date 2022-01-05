package APITest;

import API.Builders.GetJWTToken;
import API.Builders.IrisUploadProductPriceDetails;
import API.Helpers.IrisAPIHelpers;
import API.PojoFiles.GetJWTResponse;
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
