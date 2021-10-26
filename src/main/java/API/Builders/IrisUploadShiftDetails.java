package API.Builders;

import API.Base.BaseUtilsAPI;
import API.PojoFiles.IrisUploadShiftDetailsRequest;
import API.PojoFiles.IrisUploadShiftDetailsResponse;
import Constants.EnumsRepo;
import io.restassured.response.Response;

public class IrisUploadShiftDetails extends BaseUtilsAPI {
    static IrisUploadShiftDetails irisUploadShiftDetails;
    IrisUploadShiftDetailsRequest irisUploadShiftDetailsRequest;
    IrisUploadShiftDetailsResponse irisUploadShiftDetailsResponse;
    String request = "{\"hardwareid\":\"0821397985\",\"Devicesubtype\":\"82\"}";

    private IrisUploadShiftDetails() {
        if (irisUploadShiftDetailsRequest == null)
            irisUploadShiftDetailsRequest = new IrisUploadShiftDetailsRequest();
    }

    public static IrisUploadShiftDetails getInstance() {
        if (irisUploadShiftDetails == null)
            irisUploadShiftDetails = new IrisUploadShiftDetails();
        return irisUploadShiftDetails;
    }


    public IrisUploadShiftDetailsResponse createAndExecute() {
        request = javaObjectToString(irisUploadShiftDetailsRequest);
        setMethod(EnumsRepo.methodName.POST);
        Response response = execute(request, "/auth/irisUploadShiftDetailsToken");
        irisUploadShiftDetailsResponse = stringToJavaObject(response.asString(), IrisUploadShiftDetailsResponse.class);
        return irisUploadShiftDetailsResponse;
    }

    public IrisUploadShiftDetailsResponse irisUploadShiftDetailsResponse() {
        return irisUploadShiftDetailsResponse;
    }

    public IrisUploadShiftDetailsRequest getJwtRequest() {
        return irisUploadShiftDetailsRequest;
    }
}
