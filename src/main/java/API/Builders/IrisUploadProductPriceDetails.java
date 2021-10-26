package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUploadProductPriceDetailsRequest;
import API.PojoFiles.IrisUploadProductPriceDetailsResponse;
import Constants.EnumsRepo;
import io.restassured.response.Response;

public class IrisUploadProductPriceDetails extends BaseUtilsAPI {
    static IrisUploadProductPriceDetails irisUploadProductPriceDetails;
    IrisUploadProductPriceDetailsRequest irisUploadProductPriceDetailsRequest;
    IrisUploadProductPriceDetailsResponse irisUploadProductPriceDetailsResponse;
    String request = "{\"hardwareid\":\"0821397985\",\"Devicesubtype\":\"82\"}";

    private IrisUploadProductPriceDetails() {
        if (irisUploadProductPriceDetailsRequest == null)
            irisUploadProductPriceDetailsRequest = new IrisUploadProductPriceDetailsRequest();
    }

    public static IrisUploadProductPriceDetails getInstance() {
        if (irisUploadProductPriceDetails == null)
            irisUploadProductPriceDetails = new IrisUploadProductPriceDetails();
        return irisUploadProductPriceDetails;
    }


    public IrisUploadProductPriceDetailsResponse createAndExecute() {
        request = javaObjectToString(irisUploadProductPriceDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, "/auth/irisUploadProductPriceDetails");
        irisUploadProductPriceDetailsResponse = stringToJavaObject(response.asString(), IrisUploadProductPriceDetailsResponse.class);
        return irisUploadProductPriceDetailsResponse;
    }

    public IrisUploadProductPriceDetailsResponse irisUploadProductPriceDetailsResponse() {
        return irisUploadProductPriceDetailsResponse;
    }

    public IrisUploadProductPriceDetailsRequest irisUploadProductPriceDetailsRequest() {
        return irisUploadProductPriceDetailsRequest;
    }
}
