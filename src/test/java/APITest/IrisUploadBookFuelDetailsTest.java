package APITest;

import API.Builders.GetJWTToken;
import API.Builders.IrisBookClaimFuelStatus;
import API.Builders.IrisUploadBookFuelDetails;
import API.Helpers.IrisAPIHelpers;
import API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisUploadBookFuelDetailsTest {
   //Ready
    @Test
    public void bookFuel_TC001() {
        IrisUploadBookFuelDetails irisUploadBookFuelDetails = IrisUploadBookFuelDetails.getInstance(IrisUploadBookFuelDetails.defaultRequest);
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0820686904",  GetJWTToken.defaultrequest);
        irisUploadBookFuelDetails.getRequestPojo().setHardwareId("0820686904");
        irisUploadBookFuelDetails.getRequestPojo().setRoid(180664);
        irisUploadBookFuelDetails.createAndExecute(getJWTResponse.getAccessToken());
        Assert.assertEquals(irisUploadBookFuelDetails.getResponsePojo().getResMsg(),"Transaction Successfully Booked");

    }
}
