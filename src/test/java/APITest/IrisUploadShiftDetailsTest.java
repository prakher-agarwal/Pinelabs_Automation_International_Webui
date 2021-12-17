package APITest;

import API.Builders.GetJWTToken;
import API.Builders.IrisUploadShiftDetails;
import API.Helpers.IrisAPIHelpers;
import API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadShiftDetailsTest {
//ready
    @Test
    public void uploadShiftDetails_TC001(){
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0822398347", GetJWTToken.defaultrequest);
        IrisUploadShiftDetails irisUploadShiftDetails= IrisUploadShiftDetails.getInstance(IrisUploadShiftDetails.defaultRequest);
        irisUploadShiftDetails.getRequest().setHardwareId("0822398347");
        irisUploadShiftDetails.createAndExecute(getJWTResponse.getAccessToken());
        Assert.assertEquals(irisUploadShiftDetails.getResponse().getResMsg(),"Successfully Uploaded the shift change details in DB");
    }
}
