package com.pinelabs.RnD.APITest;

import com.pinelabs.RnD.API.Builders.GetJWTToken;
import com.pinelabs.RnD.API.Builders.IrisBookClaimFuelStatus;
import com.pinelabs.RnD.API.Helpers.IrisAPIHelpers;
import com.pinelabs.RnD.API.PojoFiles.GetJWTResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IrisBookClaimFuelStatusTest {
    //Ready
    @Test(description = "Validate if bookClaimFuelStatus is working with valid params")
    public void bookClaimFuelStatus_TC001() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Transaction Updated Successfully");
    }

    @Test(description = "Validate if bookClaimFuelStatus if roid NOT related with hardware id is provided")
    public void bookClaimFuelStatus_TC002() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setROid("180664");
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Transaction Not Found");
    }
    @Test(description = "Validate if bookClaimFuelStatus if roid is not provided")
    public void bookClaimFuelStatus_TC003() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setROid("180664");
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Transaction Not Found");
    }
    @Test(description = "Validate if bookClaimFuelStatus if roid parameter is not provided")
    public void bookClaimFuelStatus_TC004() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setROid(null);
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Invalid Ro Id");
    }
    @Test(description = "Validate if bookClaimFuelStatus if randoum ROid is provided")
    public void bookClaimFuelStatus_TC005() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setROid("23467");
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Invalid Ro Id");
    }
    @Test(description = "Validate if bookClaimFuelStatus if TranId is empty")
    public void bookClaimFuelStatus_TC006() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setTranId("");
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Invalid Transaction Id");
    }
    @Test(description = "Validate if bookClaimFuelStatus if TranId parameter is not sent")
    public void bookClaimFuelStatus_TC007() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setTranId(null);
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Invalid Transaction Id");
    }
    @Test(description = "Validate if bookClaimFuelStatus if TranId parameter is not sent")
    public void bookClaimFuelStatus_TC008() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setTranId(null);
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Invalid Transaction Id");
    }
    @Test(description = "Validate if bookClaimFuelStatus if RedeemAmt parameter is not sent")
    public void bookClaimFuelStatus_TC009() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setRedeemAmt(null);
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Invalid Transction Id");
    }
//    @Test(description = "Validate if bookClaimFuelStatus if RedeemAmt parameter is set empty")
//    public void bookClaimFuelStatus_TC010() {
//        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
//        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
//        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
//        Integer a=null;
//        irisBookClaimFuelStatus.getRequestPojo().setRedeemAmt();
//        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
//        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Invalid Transction Id");
//    }
    @Test(description = "Validate if bookClaimFuelStatus if RedeemAmt parameter is set invalid")
    public void bookClaimFuelStatus_TC011() {
        GetJWTResponse getJWTResponse = IrisAPIHelpers.getTokenFromGetJWTToken("0821396591", GetJWTToken.defaultrequest);
        IrisBookClaimFuelStatus irisBookClaimFuelStatus = IrisBookClaimFuelStatus.getInstance(IrisBookClaimFuelStatus.defaultRequest);
        irisBookClaimFuelStatus.getRequestPojo().setHardwareId("0821396591");
        irisBookClaimFuelStatus.getRequestPojo().setRedeemAmt(-987);
        irisBookClaimFuelStatus.createAndExecute(getJWTResponse.getAccessToken().toString().toString());
        Assert.assertEquals(irisBookClaimFuelStatus.getResponsePojo().getResMsg(), "Transaction Updated Successfully");
    }

}
