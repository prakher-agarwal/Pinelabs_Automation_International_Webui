package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.*;
import Constants.EnumsRepo;
import Constants.URI;
import io.restassured.response.Response;

public class IrisUploadLubeSaleDetails extends BaseUtilsAPI {
    static IrisUploadLubeSaleDetails irisUploadLubeSaleDetails;
    IrisUploadLubeSaleDetailsRequest irisUploadLubeSaleDetailsRequest;
    IrisUploadLubeSaleDetailsResponse irisUploadLubeSaleDetailsResponse;
    public static String defaultRequest = "{\"HardwareId\":\"0822398347\",\"LubeCode\":\"OIL1234567\",\"Quantity\":1000,\"VoucherId\":\"12345678\",\"TotalAmount\":50000,\"Paymode\":\"CASH\",\"LubeSaleDateTime\":\"2021-11-14 20:35:41\",\"ROid\":\"180664\"}";
    String request;

    private IrisUploadLubeSaleDetails(String request) {
        this.request = request;
        irisUploadLubeSaleDetailsRequest = stringToJavaObject(this.request, IrisUploadLubeSaleDetailsRequest.class);
    }

    public static IrisUploadLubeSaleDetails getInstance(String request) {
        if (irisUploadLubeSaleDetails == null)
            irisUploadLubeSaleDetails = new IrisUploadLubeSaleDetails(request);
        return irisUploadLubeSaleDetails;
    }


    public IrisUploadLubeSaleDetailsResponse createAndExecute(String token) {
        request = javaObjectToString(irisUploadLubeSaleDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, URI.irisUploadLubeSaleDetails, URI.baseURL,token);
        irisUploadLubeSaleDetailsResponse = stringToJavaObject(response.asString(), IrisUploadLubeSaleDetailsResponse.class);
        return irisUploadLubeSaleDetailsResponse;
    }

    public IrisUploadLubeSaleDetailsResponse getResponse() {
        return irisUploadLubeSaleDetailsResponse;
    }

    public IrisUploadLubeSaleDetailsRequest getRequest() {
        return irisUploadLubeSaleDetailsRequest;
    }
}

