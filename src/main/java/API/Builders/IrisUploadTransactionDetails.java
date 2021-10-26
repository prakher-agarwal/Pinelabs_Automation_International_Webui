package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUploadTransactionDetailsRequest;
import API.PojoFiles.IrisUploadTransactionDetailsResponse;
import Constants.EnumsRepo;
import io.restassured.response.Response;

public class IrisUploadTransactionDetails extends BaseUtilsAPI {
    static IrisUploadTransactionDetails irisUploadTransactionDetails;
    IrisUploadTransactionDetailsRequest irisUploadTransactionDetailsRequest;
    IrisUploadTransactionDetailsResponse irisUploadTransactionDetailsResponse;
    String request = "{\"hardwareid\":\"0821397985\",\"Devicesubtype\":\"82\"}";

    private IrisUploadTransactionDetails() {
        if (irisUploadTransactionDetailsRequest == null)
            irisUploadTransactionDetailsRequest = new IrisUploadTransactionDetailsRequest();
    }

    public static IrisUploadTransactionDetails getInstance() {
        if (irisUploadTransactionDetails == null)
            irisUploadTransactionDetails = new IrisUploadTransactionDetails();
        return irisUploadTransactionDetails;
    }


    public IrisUploadTransactionDetailsResponse createAndExecute() {
        request = javaObjectToString(irisUploadTransactionDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, "/auth/IrisUploadTransactionDetailsToken");
        irisUploadTransactionDetailsResponse = stringToJavaObject(response.asString(), IrisUploadTransactionDetailsResponse.class);
        return irisUploadTransactionDetailsResponse;
    }

    public IrisUploadTransactionDetailsResponse IrisUploadTransactionDetailsResponse() {
        return irisUploadTransactionDetailsResponse;
    }

    public IrisUploadTransactionDetailsRequest getJwtRequest() {
        return irisUploadTransactionDetailsRequest;
    }
}
