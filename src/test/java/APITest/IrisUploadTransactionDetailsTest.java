package APITest;

import API.Builders.GetJWTToken;
import API.Builders.IrisUploadTransactionDetails;
import API.Helpers.IrisAPIHelpers;
import API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadTransactionDetailsTest {
    //ready
    @Test
    public void uploadTransaction_TC001() {
        IrisUploadTransactionDetails irisUploadTransactionDetails = IrisUploadTransactionDetails.getInstance(IrisUploadTransactionDetails.defaultRequest);
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        irisUploadTransactionDetails.getRequest().setHardwareId("0822398347");
        irisUploadTransactionDetails.createAndExecute(getJWTResponse.getAccessToken());
        Assert.assertEquals(irisUploadTransactionDetails.getResponse().getResMsg(), "Successful! Iris Transaction recorded in Db");
    }
}
