package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUpdateLubeStockDetailsRequest;
import API.PojoFiles.IrisUpdateLubeStockDetailsResponse;
import Constants.EnumsRepo;
import io.restassured.response.Response;

public class IrisUpdateLubeStockDetails extends BaseUtilsAPI {
    static IrisUpdateLubeStockDetails irisUpdateLubeStockDetails;
    IrisUpdateLubeStockDetailsRequest irisUpdateLubeStockDetailsRequest;
    IrisUpdateLubeStockDetailsResponse irisUpdateLubeStockDetailsResponse;
    String request = "{\"hardwareid\":\"0821397985\",\"Devicesubtype\":\"82\"}";

    private IrisUpdateLubeStockDetails() {
        if (irisUpdateLubeStockDetailsRequest == null)
            irisUpdateLubeStockDetailsRequest = new IrisUpdateLubeStockDetailsRequest();
    }

    public static IrisUpdateLubeStockDetails getInstance() {
        if (irisUpdateLubeStockDetails == null)
            irisUpdateLubeStockDetails = new IrisUpdateLubeStockDetails();
        return irisUpdateLubeStockDetails;
    }


    public IrisUpdateLubeStockDetailsResponse createAndExecute() {
        request = javaObjectToString(irisUpdateLubeStockDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, "/records/IrisUploadShiftDetails");
        irisUpdateLubeStockDetailsResponse = stringToJavaObject(response.asString(), IrisUpdateLubeStockDetailsResponse.class);
        return irisUpdateLubeStockDetailsResponse;
    }

    public IrisUpdateLubeStockDetailsResponse getResponse() {
        return irisUpdateLubeStockDetailsResponse;
    }

    public IrisUpdateLubeStockDetailsRequest getRequest() {
        return irisUpdateLubeStockDetailsRequest;
    }
}
