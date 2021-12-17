package APITest;

import API.Builders.GetJWTToken;
import API.Builders.IrisUploadLocalAccPaymentDetails;
import API.Helpers.IrisAPIHelpers;
import API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadLocalAccPaymentDetailsTest {

    @Test
    public void uploadLocalAccPaymentDetails_TC001() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821397407", GetJWTToken.defaultrequest);
        IrisUploadLocalAccPaymentDetails irisUploadLocalAccPaymentDetails = IrisUploadLocalAccPaymentDetails.getInstance(IrisUploadLocalAccPaymentDetails.defaultRequest);
        irisUploadLocalAccPaymentDetails.getRequest().setHardwareId("0821397407");
        irisUploadLocalAccPaymentDetails.createAndExecute(getJWTResponse.getAccessToken());
        Assert.assertEquals(irisUploadLocalAccPaymentDetails.getResponse().getResMsg(), "Successfully Updated the local account payment details in DB");
    }

}
