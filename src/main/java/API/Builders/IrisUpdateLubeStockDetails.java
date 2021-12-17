package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUpdateLubeStockDetailsRequest;
import API.PojoFiles.IrisUpdateLubeStockDetailsResponse;
import API.PojoFiles.IrisUploadBookFuelDetailsRequest;
import API.PojoFiles.IrisUploadBookFuelDetailsResponse;
import Constants.EnumsRepo;
import Constants.URI;
import io.restassured.response.Response;

public class IrisUpdateLubeStockDetails extends BaseUtilsAPI {
    static IrisUpdateLubeStockDetails irisUpdateLubeStockDetails;
    IrisUpdateLubeStockDetailsRequest irisUpdateLubeStockDetailsRequest;
    IrisUpdateLubeStockDetailsResponse irisUpdateLubeStockDetailsResponse;
    public static String defaultRequest = "{\"HardwareId\":\"0821397407\",\"LubeCode\":\"OIL1234567\",\"Quantity\":100,\"TotalQuantity\":200,\"StockUpdationDateTime\":\"2021-04-22 20:35:41\",\"ROid\":\"180664\"}";
    String request;

    private IrisUpdateLubeStockDetails(String request) {
        this.request = request;
        irisUpdateLubeStockDetailsRequest = stringToJavaObject(this.request, IrisUpdateLubeStockDetailsRequest.class);
    }

    public static IrisUpdateLubeStockDetails getInstance(String request) {
        if (irisUpdateLubeStockDetails == null)
            irisUpdateLubeStockDetails = new IrisUpdateLubeStockDetails(request);
        return irisUpdateLubeStockDetails;
    }


    public IrisUpdateLubeStockDetailsResponse createAndExecute(String token) {
        request = javaObjectToString(irisUpdateLubeStockDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, URI.irisUpdateLubeStockDetails, URI.baseURL,token);
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
