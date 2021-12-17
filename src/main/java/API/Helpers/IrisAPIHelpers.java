package API.Helpers;

import API.Builders.GetJWTToken;
import API.Builders.IrisUploadBookFuelDetails;
import API.PojoFiles.GetJWTResponse;
import API.PojoFiles.IrisUploadBookFuelDetailsResponse;

public class IrisAPIHelpers {

    public static GetJWTResponse getTokenFromGetJWTToken(String hardwareID, String request) {
        GetJWTToken getJWTToken = GetJWTToken.getInstance(request);
        getJWTToken.getRequest().setHardwareid(hardwareID);
        getJWTToken.getRequest().setDevicesubtype("82");
        getJWTToken.createAndExecute();
        return getJWTToken.getResponse();
    }

    public static IrisUploadBookFuelDetailsResponse uploadBookFuelDetails(String hardwareID, String accessToken){
        IrisUploadBookFuelDetails irisUploadBookFuelDetails = IrisUploadBookFuelDetails.getInstance(IrisUploadBookFuelDetails.defaultRequest);
        irisUploadBookFuelDetails.getRequestPojo().setHardwareId(hardwareID);
        irisUploadBookFuelDetails.getRequestPojo().setRoid(180664);
        irisUploadBookFuelDetails.createAndExecute(accessToken);
        return irisUploadBookFuelDetails.getResponsePojo();
    }
}
