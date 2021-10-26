package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUploadLocalAccPaymentDetailsRequest;
import API.PojoFiles.IrisUploadLocalAccPaymentDetailsResponse;
import Constants.EnumsRepo;
import io.restassured.response.Response;

public class IrisUploadLocalAccPaymentDetails extends BaseUtilsAPI {
    static IrisUploadLocalAccPaymentDetails irisUploadLocalAccPaymentDetails;
    IrisUploadLocalAccPaymentDetailsRequest irisUploadLocalAccPaymentDetailsRequest;
    IrisUploadLocalAccPaymentDetailsResponse irisUploadLocalAccPaymentDetailsResponse;
    String request = "{\"hardwareid\":\"0821397985\",\"Devicesubtype\":\"82\"}";

    private IrisUploadLocalAccPaymentDetails() {
        if (irisUploadLocalAccPaymentDetailsRequest == null)
            irisUploadLocalAccPaymentDetailsRequest = new IrisUploadLocalAccPaymentDetailsRequest();
    }

    public static IrisUploadLocalAccPaymentDetails getInstance() {
        if (irisUploadLocalAccPaymentDetails == null)
            irisUploadLocalAccPaymentDetails = new IrisUploadLocalAccPaymentDetails();
        return irisUploadLocalAccPaymentDetails;
    }


    public IrisUploadLocalAccPaymentDetailsResponse createAndExecute() {
        request = javaObjectToString(irisUploadLocalAccPaymentDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, "/auth/getJWTToken");
        irisUploadLocalAccPaymentDetailsResponse = stringToJavaObject(response.asString(), IrisUploadLocalAccPaymentDetailsResponse.class);
        return irisUploadLocalAccPaymentDetailsResponse;
    }

    public IrisUploadLocalAccPaymentDetailsResponse getResponse() {
        return irisUploadLocalAccPaymentDetailsResponse;
    }

    public IrisUploadLocalAccPaymentDetailsRequest getRequest() {
        return irisUploadLocalAccPaymentDetailsRequest;
    }
}
