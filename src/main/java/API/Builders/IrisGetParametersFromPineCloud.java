package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisGetParametersFromPineCloudRequest;
import API.PojoFiles.IrisGetParametersFromPineCloudResponse;
import Constants.EnumsRepo;
import io.restassured.response.Response;

public class IrisGetParametersFromPineCloud extends BaseUtilsAPI {
    static IrisGetParametersFromPineCloud irisGetParametersFromPineCloud;
    IrisGetParametersFromPineCloudRequest irisGetParametersFromPineCloudRequest;
    IrisGetParametersFromPineCloudResponse irisGetParametersFromPineCloudResponse;
    String request = "{\"hardwareid\":\"0821397985\"}";

    private IrisGetParametersFromPineCloud() {
        if (irisGetParametersFromPineCloudRequest == null)
            irisGetParametersFromPineCloudRequest = new IrisGetParametersFromPineCloudRequest();
    }

    public static IrisGetParametersFromPineCloud getInstance() {
        if (irisGetParametersFromPineCloud == null)
            irisGetParametersFromPineCloud = new IrisGetParametersFromPineCloud();
        return irisGetParametersFromPineCloud;
    }


    public void createAndExecute(String token) {
        request = javaObjectToString(irisGetParametersFromPineCloudRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, "/sync/IrisGetParametersFromPineCloud",token);
        irisGetParametersFromPineCloudResponse = stringToJavaObject(response.asString(), IrisGetParametersFromPineCloudResponse.class);

    }

    public IrisGetParametersFromPineCloudResponse getResponsePojo() {
        return irisGetParametersFromPineCloudResponse;
    }

    public IrisGetParametersFromPineCloudRequest getRequestPojo() {
        return irisGetParametersFromPineCloudRequest;
    }
}
