package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisBookClaimFuelStatusRequest;
import API.PojoFiles.IrisBookClaimFuelStatusResponse;
import API.PojoFiles.IrisGetClaimFuelDetailsRequest;
import Constants.EnumsRepo;
import Constants.URI;
import io.restassured.response.Response;

public class IrisBookClaimFuelStatus extends BaseUtilsAPI {
    static IrisBookClaimFuelStatus irisBookClaimFuelStatus;
    IrisBookClaimFuelStatusRequest irisBookClaimFuelStatusRequest;
    IrisBookClaimFuelStatusResponse irisBookClaimFuelStatusResponse;
   public static  String defaultRequest = "{\"HardwareId\":\"0821397407\",\"ROid\":\"333000\",\"TranId\":243,\"RedeemAmt\":1400}";
    String request;

    private IrisBookClaimFuelStatus(String request) {
        this.request = request;
        irisBookClaimFuelStatusRequest = stringToJavaObject(this.request, IrisBookClaimFuelStatusRequest.class);
    }

    public static IrisBookClaimFuelStatus getInstance(String request) {
        if (irisBookClaimFuelStatus == null)
            irisBookClaimFuelStatus = new IrisBookClaimFuelStatus(request);
        return irisBookClaimFuelStatus;
    }


    public void createAndExecute(String token) {
        request = javaObjectToString(irisBookClaimFuelStatusRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, URI.irisBookClaimFuelStatus, URI.baseURL, token);
        irisBookClaimFuelStatusResponse = stringToJavaObject(response.asString(), IrisBookClaimFuelStatusResponse.class);

    }

    public IrisBookClaimFuelStatusResponse getResponsePojo() {
        return irisBookClaimFuelStatusResponse;
    }

    public IrisBookClaimFuelStatusRequest getRequestPojo() {
        return irisBookClaimFuelStatusRequest;
    }
}
