package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisGetParametersFromPineCloudRequest;
import API.PojoFiles.IrisGetParametersFromPineCloudResponse;
import API.PojoFiles.IrisUpdateLubeStockDetailsRequest;
import API.PojoFiles.UpiCallbackIciciResponse;
import Constants.EnumsRepo;
import Constants.URI;
import io.restassured.response.Response;

public class IrisGetParametersFromPineCloud extends BaseUtilsAPI {
    static IrisGetParametersFromPineCloud irisGetParametersFromPineCloud;
    IrisGetParametersFromPineCloudRequest irisGetParametersFromPineCloudRequest;
    IrisGetParametersFromPineCloudResponse irisGetParametersFromPineCloudResponse;
    public static String defaultRequest = "{\"hardwareid\":\"0821397985\"}";
    String request;

    private IrisGetParametersFromPineCloud(String request) {
        this.request = request;
        irisGetParametersFromPineCloudRequest = stringToJavaObject(this.request, IrisGetParametersFromPineCloudRequest.class);
    }

    public static IrisGetParametersFromPineCloud getInstance(String request) {
        if (irisGetParametersFromPineCloud == null)
            irisGetParametersFromPineCloud = new IrisGetParametersFromPineCloud(request);
        return irisGetParametersFromPineCloud;
    }


    public void createAndExecute(String token) {
        request = javaObjectToString(irisGetParametersFromPineCloudRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, URI.irisGetParametersFromPineCloud, URI.baseURL, token);
        irisGetParametersFromPineCloudResponse = stringToJavaObject(response.asString(), IrisGetParametersFromPineCloudResponse.class);
    }

    public IrisGetParametersFromPineCloudResponse getResponsePojo() {
        return irisGetParametersFromPineCloudResponse;
    }

    public IrisGetParametersFromPineCloudRequest getRequestPojo() {
        return irisGetParametersFromPineCloudRequest;
    }
}
